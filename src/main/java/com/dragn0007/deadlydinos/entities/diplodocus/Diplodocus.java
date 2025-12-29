package com.dragn0007.deadlydinos.entities.diplodocus;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.effects.DDDEffects;
import com.dragn0007.deadlydinos.entities.AbstractDinoMount;
import com.dragn0007.deadlydinos.entities.DDDAnimations;
import com.dragn0007.deadlydinos.entities.ai.DinoOwnerHurtByTargetGoal;
import com.dragn0007.deadlydinos.entities.ai.DinoOwnerHurtTargetGoal;
import com.dragn0007.deadlydinos.entities.ai.GroundTieGoal;
import com.dragn0007.deadlydinos.entities.ai.herd.AbstractMountFollowHerdLeaderGoal;
import com.dragn0007.deadlydinos.items.DDDItems;
import com.dragn0007.deadlydinos.util.DDDNetwork;
import com.dragn0007.deadlydinos.util.DDDSoundEvents;
import com.dragn0007.deadlydinos.util.DDDTags;
import com.dragn0007.deadlydinos.util.DeadlyDinosCommonConfig;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class Diplodocus extends AbstractDinoMount implements GeoEntity {

	public Diplodocus(EntityType<? extends Diplodocus> type, Level level) {
		super(type, level);
		noCulling = true;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 250.0D)
				.add(Attributes.ATTACK_DAMAGE, 6D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1F)
				.add(Attributes.ATTACK_KNOCKBACK, 0.3F)
				.add(Attributes.ARMOR_TOUGHNESS, 2D)
				.add(Attributes.ARMOR, 4D)
				.add(Attributes.MOVEMENT_SPEED, 0.24F)
				.add(Attributes.FOLLOW_RANGE, 48D);
	}

	public float getRiddenSpeed(Player player) {
		return (float)this.getAttributeValue(Attributes.MOVEMENT_SPEED) / 1.8F;
	}

	@Override
	public boolean canJump() {
		return false;
	}

	@Override
	public int getInventorySize() {
		return 27;
	}
	public static final Ingredient FOOD_ITEMS = Ingredient.of(DDDTags.Items.HERBIVORE_EATS);
	public boolean isFood(ItemStack itemStack) {
		return FOOD_ITEMS.test(itemStack);
	}

	public void registerGoals() {
		this.goalSelector.addGoal(0, new GroundTieGoal(this));
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(2, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 2.0D, true));

		this.goalSelector.addGoal(3, new SearchForHerbivoreFoodGoal());
		this.goalSelector.addGoal(3, new RaidGardenGoal(this));
		this.goalSelector.addGoal(0, new DinoOwnerHurtByTargetGoal(this));
		this.goalSelector.addGoal(1, new DinoOwnerHurtTargetGoal(this));
		this.goalSelector.addGoal(4, new AbstractMountFollowHerdLeaderGoal(this));

		this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, false, entity ->
				entity.getType().is(DDDTags.Entity_Types.PREDATORS) && (entity instanceof TamableAnimal && !((TamableAnimal) entity).isTame()) && !this.isBaby()
		));

		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 15.0F, 1.3F, 1.3F,
				entity -> entity instanceof Player && this.isBaby() && !this.isTamed()));

		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, LivingEntity.class, 15.0F, 1.8F, 1.8F,
				entity -> entity.getType().is(DDDTags.Entity_Types.MEDIUM_DINOS_RUN_FROM) && this.isBaby()));

		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, LivingEntity.class, 15.0F, 2.0F, 1.8F,
				entity -> entity.getType().is(DDDTags.Entity_Types.LARGE_PREDATORS) && !this.isTamed()));
	}

	public boolean doHurtTarget(Entity entity) {
		Random random = new Random();
		int chance = random.nextInt(100);
		if (super.doHurtTarget(entity)) {
			if (entity instanceof LivingEntity) {
				if (DeadlyDinosCommonConfig.INJURY_EFFECTS.get()) {
					if (chance <= 20 && chance >= 10) {
						((LivingEntity) entity).addEffect(new MobEffectInstance(DDDEffects.BROKEN_LEG.get(), DeadlyDinosCommonConfig.BROKEN_BONE_HEAL_TIME.get(), 2, true, false, true), this);
					} else if (chance <= 10) {
						((LivingEntity) entity).addEffect(new MobEffectInstance(DDDEffects.BROKEN_ARM.get(), DeadlyDinosCommonConfig.BROKEN_BONE_HEAL_TIME.get(), 2, true, false, true), this);
					}

					if (chance <= 10) {
						((LivingEntity) entity).addEffect(new MobEffectInstance(DDDEffects.CONCUSSION.get(), DeadlyDinosCommonConfig.CONCUSSION_HEAL_TIME.get(), 1, true, false, true), this);
					}
				}
			}

			return true;
		} else {
			return false;
		}
	}

	public int regenHealthCounter = 0;

	public static final EntityDataAccessor<Integer> MODE = SynchedEntityData.defineId(Diplodocus.class, EntityDataSerializers.INT);

	public Vec3 lastServerPos = Vec3.ZERO;

	public enum Mode {
		NO(new ResourceLocation(DeadlyDinos.MODID, "textures/gui/nomode.png")),
		HARVEST(new ResourceLocation(DeadlyDinos.MODID, "textures/gui/harvestmode.png"));

		public final ResourceLocation texture;

		Mode(ResourceLocation texture) {
			this.texture = texture;
		}

		public Mode next() {
			return Mode.values()[(this.ordinal() + 1) % Mode.values().length];
		}
	}

	public int mode() {
		return this.entityData.get(MODE);
	}

	public void cycleMode() {
		this.entityData.set(MODE, (this.entityData.get(MODE) +1) % 2);
	}

	protected Vec3 calcOffset(double x, double y, double z) {
		double rad = this.getYRot() * Math.PI / 180;

		double xOffset = this.position().x + (x * Math.cos(rad) - z * Math.sin(rad));
		double yOffset = this.position().y + y;
		double zOffset = this.position().z + (x * Math.sin(rad) + z * Math.cos(rad));

		return new Vec3(xOffset, yOffset, zOffset);
	}

	private boolean addCropsToInventory(ItemStack stack) {
		for (int slot = 2; slot < this.inventory.getContainerSize(); slot++) {

			ItemStack previousStack = this.inventory.getItem(slot);

			if (!previousStack.isEmpty() && ItemStack.isSameItem(previousStack, stack)) {
				int transferable = Math.min(previousStack.getMaxStackSize() - previousStack.getCount(), stack.getCount());
				if (transferable > 0) {
					previousStack.grow(transferable);
					stack.shrink(transferable);
					if (stack.isEmpty()) return true;
				}
			}

			if (previousStack.isEmpty()) {
				this.inventory.setItem(slot, stack.copy());
				stack.setCount(0);
				return true;
			}
		}
		return stack.isEmpty();
	}

	public void harvestCrop(BlockPos pos) {
		BlockState state = this.level().getBlockState(pos);

		if (state.is(BlockTags.LEAVES)) {
			List<ItemStack> drops = Block.getDrops(state, (ServerLevel) this.level(), pos, null);
			drops.removeIf(itemStack -> itemStack.getItem() != state.getBlock().asItem());
			drops.add(new ItemStack(state.getBlock().asItem()));
			drops.forEach(itemStack -> {
				if (!addCropsToInventory(itemStack)) {
					this.spawnAtLocation(itemStack);
				}
			});
			this.level().removeBlock(pos, false);
		}
	}


	public void harvest() {
		Vec3 left = this.calcOffset(-1, 0.2, 3);
		Vec3 mid = this.calcOffset(0, 0.2, 3);
		Vec3 right = this.calcOffset(1, 0.2, 3);
		Vec3 midleft = this.calcOffset(-1, 1.2, 3);
		Vec3 midmid = this.calcOffset(0, 1.2, 3);
		Vec3 midright = this.calcOffset(1, 1.2, 3);
		Vec3 mid2left = this.calcOffset(-1, 2.2, 3);
		Vec3 mid2mid = this.calcOffset(0, 2.2, 3);
		Vec3 mid2right = this.calcOffset(1, 2.2, 3);
		Vec3 upperleft = this.calcOffset(-1, 3.2, 3);
		Vec3 uppermid = this.calcOffset(0, 3.2, 3);
		Vec3 upperright = this.calcOffset(1, 3.2, 3);
		Vec3 upper2left = this.calcOffset(-1, 3.2, 3);
		Vec3 upper2mid = this.calcOffset(0, 3.2, 3);
		Vec3 upper2right = this.calcOffset(1, 3.2, 3);

		BlockPos leftPos = new BlockPos((int)Math.floor(left.x), (int)Math.floor(left.y), (int)Math.floor(left.z));
		BlockPos midPos = new BlockPos((int)Math.floor(mid.x), (int)Math.floor(mid.y), (int)Math.floor(mid.z));
		BlockPos rightPos = new BlockPos((int)Math.floor(right.x), (int)Math.floor(right.y), (int)Math.floor(right.z));
		BlockPos midleftPos = new BlockPos((int)Math.floor(midleft.x), (int)Math.floor(midleft.y), (int)Math.floor(midleft.z));
		BlockPos midmidPos = new BlockPos((int)Math.floor(midmid.x), (int)Math.floor(midmid.y), (int)Math.floor(midmid.z));
		BlockPos midrightPos = new BlockPos((int)Math.floor(midright.x), (int)Math.floor(midright.y), (int)Math.floor(midright.z));
		BlockPos mid2leftPos = new BlockPos((int)Math.floor(mid2left.x), (int)Math.floor(mid2left.y), (int)Math.floor(mid2left.z));
		BlockPos mid2midPos = new BlockPos((int)Math.floor(mid2mid.x), (int)Math.floor(mid2mid.y), (int)Math.floor(mid2mid.z));
		BlockPos mid2rightPos = new BlockPos((int)Math.floor(mid2right.x), (int)Math.floor(mid2right.y), (int)Math.floor(mid2right.z));
		BlockPos upperleftPos = new BlockPos((int)Math.floor(upperleft.x), (int)Math.floor(upperleft.y), (int)Math.floor(upperleft.z));
		BlockPos uppermidPos = new BlockPos((int)Math.floor(uppermid.x), (int)Math.floor(uppermid.y), (int)Math.floor(uppermid.z));
		BlockPos upperrightPos = new BlockPos((int)Math.floor(upperright.x), (int)Math.floor(upperright.y), (int)Math.floor(upperright.z));
		BlockPos upper2leftPos = new BlockPos((int)Math.floor(upper2left.x), (int)Math.floor(upper2left.y), (int)Math.floor(upper2left.z));
		BlockPos upper2midPos = new BlockPos((int)Math.floor(upper2mid.x), (int)Math.floor(upper2mid.y), (int)Math.floor(upper2mid.z));
		BlockPos upper2rightPos = new BlockPos((int)Math.floor(upper2right.x), (int)Math.floor(upper2right.y), (int)Math.floor(upper2right.z));

		this.harvestCrop(leftPos);
		this.harvestCrop(midPos);
		this.harvestCrop(rightPos);
		this.harvestCrop(midleftPos);
		this.harvestCrop(midmidPos);
		this.harvestCrop(midrightPos);
		this.harvestCrop(mid2leftPos);
		this.harvestCrop(mid2midPos);
		this.harvestCrop(mid2rightPos);
		this.harvestCrop(upperleftPos);
		this.harvestCrop(uppermidPos);
		this.harvestCrop(upperrightPos);
		this.harvestCrop(upper2leftPos);
		this.harvestCrop(upper2midPos);
		this.harvestCrop(upper2rightPos);
	}

	public int tillerCooldown = 0;

	public void handleInput(Input input) {
		this.tillerCooldown = Math.max(this.tillerCooldown - 1, 0);
		if(input.jumping && this.tillerCooldown == 0) {
			DDDNetwork.INSTANCE.sendToServer(new DDDNetwork.ToggleTillerPowerRequest(this.getId()));
			this.tillerCooldown = 10;
		}
	}

	public void tick() {
		super.tick();

		if(!this.level().isClientSide) {
			this.lastServerPos = this.position();
			if(this.isVehicle()) {
				if(this.entityData.get(MODE) == 1) {
					this.harvest();
				}
			}
		} else {
			if(this.getControllingPassenger() instanceof LocalPlayer player) {
				this.handleInput(player.input);
			}
		}

		if (eggsLaid >= DeadlyDinosCommonConfig.DINO_EGG_LAY_AMOUNT.get() && eggLayCooldown >= 100) {
			eggsLaid = 0;
			eggLayCooldown = 0;
		}

		regenHealthCounter++;

		if (this.getHealth() < this.getMaxHealth() && regenHealthCounter >= 800 && this.isAlive()) {
			this.setHealth(this.getHealth() + 2);
			regenHealthCounter = 0;
			this.level().addParticle(ParticleTypes.HEART, this.getRandomX(0.6D), this.getRandomY(), this.getRandomZ(0.6D), 0.7D, 0.7D, 0.7D);
		}

	}

	public int eggTime = this.random.nextInt(DeadlyDinosCommonConfig.DINO_EGG_LAY_TIME.get()) + 6000;

	@Override
	public void aiStep() {
		super.aiStep();

		if (DeadlyDinosCommonConfig.ALLOW_EGG_LAY.get()) {
			if (!this.level().isClientSide && this.isAlive() && !this.isBaby() && --this.eggTime <= 0 && (!DeadlyDinosCommonConfig.GENDERS_AFFECT_BIPRODUCTS.get() || (DeadlyDinosCommonConfig.GENDERS_AFFECT_BIPRODUCTS.get() && this.isFemale()))) {
				this.spawnAtLocation(DDDItems.DIPLODOCUS_EGG.get());
				this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
				this.eggTime = this.random.nextInt(DeadlyDinosCommonConfig.DINO_EGG_LAY_TIME.get()) + 6000;
			}
		}

		if (this.horizontalCollision && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this) && this.isAggressive()) {
			boolean griefEvent = false;
			AABB aabb = this.getBoundingBox().inflate(0.3D);

			for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
				BlockState blockstate = this.level().getBlockState(blockpos);
				if (blockstate.is(DDDTags.Blocks.LARGE_DINO_DESTROYS) && DeadlyDinosCommonConfig.LARGE_DINOS_DESTROY_BLOCKS.get()) {
					griefEvent = this.level().destroyBlock(blockpos, true, this) || griefEvent;
				}
			}
		}

	}

	public void applySpeedEffect() {
		MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0, false, false);
		this.addEffect(effectInstance);
	}

	public boolean hasSpeedEffect() {
		return this.hasEffect(MobEffects.MOVEMENT_SPEED);
	}

	public void removeSpeedEffect() {
		this.removeEffect(MobEffects.MOVEMENT_SPEED);
	}

	public boolean hurt(DamageSource source, float v) {
		super.hurt(source, v);
		Entity entity = source.getDirectEntity();
		if (entity instanceof AbstractArrow) {
			return false;
		}
		return true;
	}

	@Override
	public float getStepHeight() {
		return 1.6F;
	}

	public final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

	public <T extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<T> tAnimationState) {
		double x = this.getX() - this.xo;
		double z = this.getZ() - this.zo;
		boolean isMoving = (x * x + z * z) > 0.0001;
		double currentSpeed = this.getDeltaMovement().lengthSqr();
		double speedThreshold = 0.02;

		AnimationController<T> controller = tAnimationState.getController();

		if (isMoving) {
			if (hasSpeedEffect()) {
				controller.setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(2.3);
			} else if ((!hasSpeedEffect() && currentSpeed > speedThreshold) || (this.isVehicle() && this.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(SPRINT_SPEED_MOD))) {
				controller.setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(2.0);
			} else if (this.isVehicle() && this.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(WALK_SPEED_MOD)) {
				controller.setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(1.5);
			} else {
				controller.setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(1.5);
			}
		} else {
			if (this.isSaddled() && !this.isVehicle() && DeadlyDinosCommonConfig.GROUND_TIE.get()) {
				controller.setAnimation(RawAnimation.begin().then("ground_tied_idle", Animation.LoopType.LOOP));
			} else {
				controller.setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
			}
			controller.setAnimationSpeed(0.7);
		}

		return PlayState.CONTINUE;
	}

	public <T extends GeoAnimatable> PlayState eatingPredicate(software.bernie.geckolib.core.animation.AnimationState<T> tAnimationState) {

		AnimationController<T> controller = tAnimationState.getController();

		if (this.isEating()) {
			controller.setAnimation(RawAnimation.begin().then("attack", Animation.LoopType.PLAY_ONCE));
			controller.setAnimationSpeed(0.8);
		}

		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, "controller", 2, this::predicate));
		controllers.add(new AnimationController<>(this, "eatingController", 2, this::eatingPredicate));
		controllers.add(DDDAnimations.genericAttackAnimation(this, DDDAnimations.ATTACK));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.geoCache;
	}

	public SoundEvent getAmbientSound() {
		super.getAmbientSound();
		return DDDSoundEvents.LARGE_HERBIVORE_AMBIENT.get();
	}

	public SoundEvent getDeathSound() {
		super.getDeathSound();
		return SoundEvents.RAVAGER_DEATH;
	}

	public SoundEvent getHurtSound(DamageSource p_30720_) {
		super.getHurtSound(p_30720_);
		return SoundEvents.POLAR_BEAR_WARNING;
	}

	public void playStepSound(BlockPos p_28254_, BlockState p_28255_) {
		this.playSound(SoundEvents.POLAR_BEAR_STEP, 0.15F, 1.0F);
	}

	@org.jetbrains.annotations.Nullable
	@Override
	public LivingEntity getControllingPassenger() {
		LivingEntity firstPassenger = (LivingEntity) this.getFirstPassenger();
		if (firstPassenger != null && this.isSaddled()) {
			return firstPassenger;
		}
		return null;
	}

	@Override
	public boolean canAddPassenger(Entity entity) {
		return this.getPassengers().size() < 3;
	}

	@Override
	public void positionRider(Entity entity, MoveFunction moveFunction) {
		if (this.hasPassenger(entity)) {
			int i = this.getPassengers().indexOf(entity);

			switch (i) {
				case 0:
					entity.setPos(this.calcOffset(0, 4.8, 0));
					break;
				case 1:
					entity.setPos(this.calcOffset(0.6, 4.8, -1.5));
					break;
				case 2:
					entity.setPos(this.calcOffset(-0.6, 4.8, -1.5));
					break;
			}
		}
	}

	// Generates the base texture
	public ResourceLocation getFemaleTextureLocation() {
		return DiplodocusModel.FemaleVariant.variantFromOrdinal(getVariant()).resourceLocation;
	}

	public ResourceLocation getMaleTextureLocation() {
		return DiplodocusModel.MaleVariant.variantFromOrdinal(getVariant()).resourceLocation;
	}

	public static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Diplodocus.class, EntityDataSerializers.INT);

	public int getVariant() {
		return this.entityData.get(VARIANT);
	}

	public void setVariant(int variant) {
		this.entityData.set(VARIANT, variant);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);

		if (tag.contains("Variant")) {
			setVariant(tag.getInt("Variant"));
		}

		if (tag.contains("Gender")) {
			setGender(tag.getInt("Gender"));
		}

		if (tag.contains("EggLayTime")) {
			this.eggTime = tag.getInt("EggLayTime");
		}

		this.entityData.set(MODE, tag.getInt("Mode"));
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("Variant", getVariant());
		tag.putInt("Gender", getGender());
		tag.putInt("EggLayTime", this.eggTime);
		tag.putInt("Mode", this.entityData.get(MODE));
	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance instance, MobSpawnType spawnType, @Nullable SpawnGroupData data, @Nullable CompoundTag tag) {
		if (data == null) {
			data = new AgeableMobGroupData(0.2F);
		}
		Random random = new Random();

		setGender(random.nextInt(Gender.values().length));

		if (this.isFemale()) {
			setVariant(random.nextInt(DiplodocusModel.FemaleVariant.values().length));
		} else if (this.isMale()) {
			setVariant(random.nextInt(DiplodocusModel.MaleVariant.values().length));
		}

		return super.finalizeSpawn(serverLevelAccessor, instance, spawnType, data, tag);
	}

	public boolean canParent() {
		return !this.isVehicle() && !this.isBaby() && this.isInLove();
	}

	public boolean canMate(Animal animal) {
		if (animal == this) {
			return false;
		} else if (!(animal instanceof Diplodocus)) {
			return false;
		} else {
			if (!DeadlyDinosCommonConfig.GENDERS_AFFECT_BREEDING.get()) {
				return this.canParent() && ((Diplodocus) animal).canParent();
			} else {
				Diplodocus partner = (Diplodocus) animal;
				if (this.canParent() && partner.canParent() && this.getGender() != partner.getGender()) {
					return isFemale();
				}
			}
		}
		return false;
	}

	public int eggsLaid = 0;
	public int eggLayCooldown = 0;

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {

		if ((this.isMale() && DeadlyDinosCommonConfig.GENDERS_AFFECT_BREEDING.get())
				|| !this.isInLove()
				|| !this.isAlive()
				|| eggsLaid >= DeadlyDinosCommonConfig.DINO_EGG_LAY_AMOUNT.get()) {
			return null;
		}

		eggsLaid++;
		dropFertilizedEgg(serverLevel);
		return null;
	}

	public void dropFertilizedEgg(ServerLevel serverLevel) {
		if (!this.isFemale() || !DeadlyDinosCommonConfig.GENDERS_AFFECT_BREEDING.get()) {
			return;
		}

		if ((this.isFemale() && DeadlyDinosCommonConfig.GENDERS_AFFECT_BREEDING.get()) || !DeadlyDinosCommonConfig.GENDERS_AFFECT_BREEDING.get()) {
			ItemStack fertilizedEgg = new ItemStack(DDDItems.FERTILIZED_DIPLODOCUS_EGG.get());
			ItemEntity eggEntity = new ItemEntity(serverLevel, this.getX(), this.getY(), this.getZ(), fertilizedEgg);
			serverLevel.addFreshEntity(eggEntity);
		}

		serverLevel.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.CHICKEN_EGG, SoundSource.NEUTRAL, 1.0F, 1.0F);
	}

	@Override
	public void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(VARIANT, 0);
		this.entityData.define(GENDER, 0);
		this.entityData.define(MODE, 0);
	}

	@Override
	public void dropCustomDeathLoot(DamageSource p_33574_, int p_33575_, boolean p_33576_) {
		super.dropCustomDeathLoot(p_33574_, p_33575_, p_33576_);
		Random random = new Random();

		int eggChance = random.nextInt(100);
		if (this.isFemale() && eggChance <= 5) {
			this.spawnAtLocation(DDDItems.FERTILIZED_DIPLODOCUS_EGG.get());
		}

		int trophyChance = random.nextInt(100);
		if (trophyChance <= 8) {
			this.spawnAtLocation(DDDItems.DIPLODOCUS_TROPHY.get());
		}
	}

}
