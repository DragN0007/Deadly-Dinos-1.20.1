package com.dragn0007.deadlydinos.entities.triceratops;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entities.AbstractDinoMount;
import com.dragn0007.deadlydinos.entities.DDDAnimations;
import com.dragn0007.deadlydinos.entities.ai.DinoOwnerHurtByTargetGoal;
import com.dragn0007.deadlydinos.entities.ai.DinoOwnerHurtTargetGoal;
import com.dragn0007.deadlydinos.entities.ai.GroundTieGoal;
import com.dragn0007.deadlydinos.entities.ai.herd.TriceratopsFollowHerdLeaderGoal;
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
import net.minecraft.world.level.block.CropBlock;
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
import java.util.stream.Stream;

public class Triceratops extends AbstractDinoMount implements GeoEntity {

	public Triceratops(EntityType<? extends Triceratops> type, Level level) {
		super(type, level);
		noCulling = true;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 140.0D)
				.add(Attributes.ATTACK_DAMAGE, 12D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1F)
				.add(Attributes.ATTACK_KNOCKBACK, 0.5F)
				.add(Attributes.ARMOR_TOUGHNESS, 4D)
				.add(Attributes.ARMOR, 12D)
				.add(Attributes.MOVEMENT_SPEED, 0.22F)
				.add(Attributes.FOLLOW_RANGE, 48D);
	}

	public float getRiddenSpeed(Player player) {
		return (float)this.getAttributeValue(Attributes.MOVEMENT_SPEED) / 1.5F;
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
		this.goalSelector.addGoal(1, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 2.0D, true));

		this.goalSelector.addGoal(3, new SearchForHerbivoreFoodGoal());
		this.goalSelector.addGoal(3, new RaidGardenGoal(this));
		this.goalSelector.addGoal(0, new DinoOwnerHurtByTargetGoal(this));
		this.goalSelector.addGoal(1, new DinoOwnerHurtTargetGoal(this));
		this.goalSelector.addGoal(4, new TriceratopsFollowHerdLeaderGoal(this));

		this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, false, entity ->
			entity instanceof Player && (this.position().distanceToSqr(entity.getX() + 0.5D, entity.getY() + 0.5D, entity.getZ() + 0.5D) <= 12.0D) && !this.isTamed() && !this.isBaby()
		));

		this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, false, entity ->
				entity.getType().is(DDDTags.Entity_Types.MEDIUM_PREDATORS) && (entity instanceof TamableAnimal && !((TamableAnimal) entity).isTame()) && !this.isBaby()
		));

		this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, false, entity ->
				entity.getType().is(DDDTags.Entity_Types.SMALL_PREDATORS) && (entity instanceof TamableAnimal && !((TamableAnimal) entity).isTame()) && !this.isBaby()
		));

		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 15.0F, 1.8F, 1.8F,
				entity -> entity instanceof Player && this.isBaby()));

		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, LivingEntity.class, 15.0F, 1.8F, 1.8F,
				entity -> entity.getType().is(DDDTags.Entity_Types.MEDIUM_DINOS_RUN_FROM) && this.isBaby()));

		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, LivingEntity.class, 15.0F, 2.0F, 1.8F,
				entity -> entity.getType().is(DDDTags.Entity_Types.LARGE_PREDATORS) && !this.isTamed()));
	}

	public Triceratops leader;
	public int packSize = 1;

	public int getMaxHerdSize() {
		return DeadlyDinosCommonConfig.TRICERATOPS_MAX_HERD_COUNT.get();
	}

	public boolean hasFollowers() {
		return this.packSize > 1;
	}

	public boolean inRangeOfLeader() {
		return this.distanceToSqr(this.leader) <= 121.0D;
	}

	public void pathToLeader() {
		if (this.isFollower()) {
			this.getNavigation().moveTo(this.leader, 1.0D);
		}

	}

	public void addFollowers(Stream<? extends Triceratops> p_27534_) {
		p_27534_.limit((long)(this.getMaxHerdSize() - this.packSize)).filter((mob) -> {
			return mob != this;
		}).forEach((mob) -> {
			mob.startFollowing(this);
		});
	}

	public boolean isFollower() {
		return this.leader != null && this.leader.isAlive();
	}

	public Triceratops startFollowing(Triceratops mob) {
		this.leader = mob;
		mob.addFollower();
		return mob;
	}

	public void stopFollowing() {
		this.leader.removeFollower();
		this.leader = null;
	}

	public void addFollower() {
		++this.packSize;
	}

	public void removeFollower() {
		--this.packSize;
	}

	public boolean canBeFollowed() {
		return this.hasFollowers() && this.packSize < this.getMaxHerdSize();
	}

	public int regenHealthCounter = 0;

	public static final EntityDataAccessor<Integer> MODE = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.INT);

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
			//cant be put in slot 1 or 2 since the saddle and hidden decor slots sit there
			//the items will just disappear into the void forever if put in these slots, which naturally players cannot do

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
		if(this.level().getBlockState(pos).getBlock() instanceof CropBlock cropBlock) {
			BlockState blockState = this.level().getBlockState(pos);

			if(cropBlock.isMaxAge(blockState)) {
				List<ItemStack> drops = Block.getDrops(blockState, (ServerLevel) this.level(), pos, null);
				drops.remove(new ItemStack(cropBlock.asItem()));
				drops.forEach(itemStack -> {
					if (!addCropsToInventory(itemStack)) {
						this.spawnAtLocation(itemStack);
					}
				});

				this.level().setBlockAndUpdate(pos, cropBlock.getStateForAge(0));
			}
		}
	}

	public void harvest() {
		Vec3 left = this.calcOffset(-1, 0.2, 3);
		Vec3 mid = this.calcOffset(0, 0.2, 3);
		Vec3 right = this.calcOffset(1, 0.2, 3);

		BlockPos leftPos = new BlockPos((int)Math.floor(left.x), (int)Math.floor(left.y), (int)Math.floor(left.z));
		BlockPos midPos = new BlockPos((int)Math.floor(mid.x), (int)Math.floor(mid.y), (int)Math.floor(mid.z));
		BlockPos rightPos = new BlockPos((int)Math.floor(right.x), (int)Math.floor(right.y), (int)Math.floor(right.z));

		this.harvestCrop(leftPos);
		this.harvestCrop(midPos);
		this.harvestCrop(rightPos);
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

		if (this.hasFollowers() && this.level().random.nextInt(200) == 1) {
			List<? extends Triceratops> list = this.level().getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
			if (list.size() <= 1) {
				this.packSize = 1;
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

		if (this.isInWater()) {
			if (!this.hasSpeedEffect()) {
				this.applySpeedEffect();
			}
		} else {
			if (this.hasSpeedEffect()) {
				this.removeSpeedEffect();
			}
		}

	}

	public int eggTime = this.random.nextInt(DeadlyDinosCommonConfig.DINO_EGG_LAY_TIME.get()) + 6000;

	@Override
	public void aiStep() {
		super.aiStep();

		if (!this.level().isClientSide && this.isAlive() && !this.isBaby() && --this.eggTime <= 0 && (!DeadlyDinosCommonConfig.GENDERS_AFFECT_BIPRODUCTS.get() || (DeadlyDinosCommonConfig.GENDERS_AFFECT_BIPRODUCTS.get() && this.isFemale()))) {
			this.spawnAtLocation(DDDItems.TRICERATOPS_EGG.get());
			this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			this.eggTime = this.random.nextInt(DeadlyDinosCommonConfig.DINO_EGG_LAY_TIME.get()) + 6000;
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
		return 1.0F;
	}

	public final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

	public <T extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<T> tAnimationState) {
		double currentSpeed = this.getDeltaMovement().lengthSqr();
		double speedThreshold = 0.02;

		AnimationController<T> controller = tAnimationState.getController();

		if (tAnimationState.isMoving()) {
			if (hasSpeedEffect()) {
				controller.setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(3.2);
			} else if ((!hasSpeedEffect() && currentSpeed > speedThreshold) || (this.isVehicle() && this.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(SPRINT_SPEED_MOD))) {
				controller.setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(2.7);
			} else if (this.isVehicle() && this.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(WALK_SPEED_MOD)) {
				controller.setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(1.7);
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

	@Override
	public void positionRider(Entity entity, MoveFunction moveFunction) {
		if (this.hasPassenger(entity)) {
			double offsetX = 0.0;
			double offsetY = 2.7;
			double offsetZ = 0.3;

			double radYaw = Math.toRadians(this.getYRot());

			double offsetXRotated = offsetX * Math.cos(radYaw) - offsetZ * Math.sin(radYaw);
			double offsetYRotated = offsetY;
			double offsetZRotated = offsetX * Math.sin(radYaw) + offsetZ * Math.cos(radYaw);

			double rotX = this.getX() + offsetXRotated;
			double rotY = this.getY() + offsetYRotated;
			double rotZ = this.getZ() + offsetZRotated;

			entity.setPos(rotX, rotY, rotZ);
		}
	}

	// Generates the base texture
	public ResourceLocation getFemaleTextureLocation() {
		return TriceratopsModel.FemaleVariant.variantFromOrdinal(getVariant()).resourceLocation;
	}

	public ResourceLocation getMaleTextureLocation() {
		return TriceratopsModel.MaleVariant.variantFromOrdinal(getVariant()).resourceLocation;
	}

	public static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.INT);

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
			setVariant(random.nextInt(TriceratopsModel.FemaleVariant.values().length));
		} else if (this.isMale()) {
			setVariant(random.nextInt(TriceratopsModel.MaleVariant.values().length));
		}

		return super.finalizeSpawn(serverLevelAccessor, instance, spawnType, data, tag);
	}

	public boolean canParent() {
		return !this.isVehicle() && !this.isBaby() && this.isInLove();
	}

	public boolean canMate(Animal animal) {
		if (animal == this) {
			return false;
		} else if (!(animal instanceof Triceratops)) {
			return false;
		} else {
			if (!DeadlyDinosCommonConfig.GENDERS_AFFECT_BREEDING.get()) {
				return this.canParent() && ((Triceratops) animal).canParent();
			} else {
				Triceratops partner = (Triceratops) animal;
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
			ItemStack fertilizedEgg = new ItemStack(DDDItems.FERTILIZED_TRICERATOPS_EGG.get());
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
			this.spawnAtLocation(DDDItems.FERTILIZED_TRICERATOPS_EGG.get());
		}

		int trophyChance = random.nextInt(100);
		if (trophyChance <= 8) {
			this.spawnAtLocation(DDDItems.TRICERATOPS_TROPHY.get());
		}
	}

}
