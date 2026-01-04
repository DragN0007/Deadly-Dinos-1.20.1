package com.dragn0007.deadlydinos.entities.anurognathus;

import com.dragn0007.deadlydinos.entities.AbstractTamableDino;
import com.dragn0007.deadlydinos.entities.ai.DinoFollowOwnerGoal;
import com.dragn0007.deadlydinos.entities.ai.DinoNearestAttackableTargetGoal;
import com.dragn0007.deadlydinos.entities.ai.DinoSitOnOwnersShoulderGoal;
import com.dragn0007.deadlydinos.items.DDDItems;
import com.dragn0007.deadlydinos.util.DDDSoundEvents;
import com.dragn0007.deadlydinos.util.DDDTags;
import com.dragn0007.deadlydinos.util.DeadlyDinosCommonConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
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
import java.util.Random;

public class Anurognathus extends AbstractTamableDino implements GeoEntity, FlyingAnimal {

	public Anurognathus(EntityType<? extends Anurognathus> type, Level level) {
		super(type, level);
		noCulling = false;
		this.moveControl = new FlyingMoveControl(this, 10, false);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 6.0D)
				.add(Attributes.ATTACK_DAMAGE, 1D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.0F)
				.add(Attributes.MOVEMENT_SPEED, 0.16F)
				.add(Attributes.FLYING_SPEED, 0.35F)
				.add(Attributes.FOLLOW_RANGE, 32D);
	}

	public static final Ingredient FOOD_ITEMS = Ingredient.of(DDDTags.Items.INSECTS);

	public boolean isFood(ItemStack itemStack) {
		return FOOD_ITEMS.test(itemStack);
	}

	public void registerGoals() {
		this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 2.0D, true));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.7F));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));

		this.goalSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.goalSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.goalSelector.addGoal(3, new DinoFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
		this.goalSelector.addGoal(3, new DinoPanicGoal(2.0D));
		this.goalSelector.addGoal(3, new DinoSitOnOwnersShoulderGoal(this));

		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 15.0F, 1.3F, 1.3F,
				entity -> entity instanceof Player && !this.isTame()));

		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, LivingEntity.class, 15.0F, 2.0F, 2.0F,
				entity -> entity.getType().is(DDDTags.Entity_Types.SMALL_DINOS_RUN_FROM) && !this.isTame()));

		this.goalSelector.addGoal(2, new DinoNearestAttackableTargetGoal<>(this, LivingEntity.class, 2, true, false,
				entity -> entity.getType().is(DDDTags.Entity_Types.INSECTS) && !this.isBaby()));
	}

	protected PathNavigation createNavigation(Level p_29417_) {
		FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, p_29417_);
		flyingpathnavigation.setCanOpenDoors(false);
		flyingpathnavigation.setCanFloat(true);
		flyingpathnavigation.setCanPassDoors(true);
		return flyingpathnavigation;
	}

	public boolean isFlying() {
		return !this.onGround();
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();

		if (DeadlyDinosCommonConfig.ALLOW_TAMING.get() && !this.isTame() && this.isFood(itemstack) && this.random.nextInt(5) == 0 && !ForgeEventFactory.onAnimalTame(this, player)) {
			this.tame(player);
			return InteractionResult.SUCCESS;
		}

		if (player.isShiftKeyDown() && !this.isFood(itemstack) && !this.isOrderedToSit() && !this.wasToldToWander() && this.isOwnedBy(player)) {
			this.setToldToWander(true);
			player.displayClientMessage(Component.translatable("tooltip.deadlydinos.wandering.tooltip").withStyle(ChatFormatting.GOLD), true);
			return InteractionResult.SUCCESS;
		}

		if (player.isShiftKeyDown() && !this.isFood(itemstack) && !this.isOrderedToSit() && this.wasToldToWander() && this.isOwnedBy(player)) {
			this.setToldToWander(false);
			player.displayClientMessage(Component.translatable("tooltip.deadlydinos.following.tooltip").withStyle(ChatFormatting.GOLD), true);
			return InteractionResult.SUCCESS;
		}

		if (this.isTame()) {
			if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
				this.heal((float) itemstack.getFoodProperties(this).getNutrition());
				if (!player.getAbilities().instabuild) {
					itemstack.shrink(1);
				}

				this.gameEvent(GameEvent.EAT, this);
				return InteractionResult.SUCCESS;
			} else {
				InteractionResult interactionresult = super.mobInteract(player, hand);
				if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(player)) {
					this.setOrderedToSit(!this.isOrderedToSit());
					this.jumping = false;
					this.navigation.stop();
					this.setTarget(null);
					return InteractionResult.SUCCESS;
				} else {
					return interactionresult;
				}
			}
		}
		return super.mobInteract(player, hand);
	}

	@Override
	public int calculateFallDamage(float v, float v1) {
		return super.calculateFallDamage(v, v1) - 10;
	}

	public int regenHealthCounter = 0;

	public void tick() {
		super.tick();

		if (eggsLaid >= DeadlyDinosCommonConfig.DINO_EGG_LAY_AMOUNT.get() && eggLayCooldown >= 100) {
			eggsLaid = 0;
			eggLayCooldown = 0;
		}

		regenHealthCounter++;

		if (this.getHealth() < this.getMaxHealth() && regenHealthCounter >= 600 && this.isAlive()) {
			this.setHealth(this.getHealth() + 2);
			regenHealthCounter = 0;
			this.level().addParticle(ParticleTypes.HEART, this.getRandomX(0.6D), this.getRandomY(), this.getRandomZ(0.6D), 0.7D, 0.7D, 0.7D);
		}

	}

	public int eggTime = this.random.nextInt(DeadlyDinosCommonConfig.DINO_EGG_LAY_TIME.get()) + 6000;

	@Override
	public void aiStep() {
		super.aiStep();

		Vec3 vec3 = this.getDeltaMovement();
		if (!this.onGround() && vec3.y < 0.0D) {
			this.setDeltaMovement(vec3.multiply(1.0D, 0.8D, 1.0D));
		}

		if (DeadlyDinosCommonConfig.ALLOW_EGG_LAY.get()) {
			if (!this.level().isClientSide && this.isAlive() && !this.isBaby() && --this.eggTime <= 0 && (!DeadlyDinosCommonConfig.GENDERS_AFFECT_BIPRODUCTS.get() || (DeadlyDinosCommonConfig.GENDERS_AFFECT_BIPRODUCTS.get() && this.isFemale()))) {
				this.spawnAtLocation(DDDItems.ANUROGNATHUS_EGG.get());
				this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
				this.eggTime = this.random.nextInt(DeadlyDinosCommonConfig.DINO_EGG_LAY_TIME.get()) + 6000;
			}
		}

	}

	protected void checkFallDamage(double p_29370_, boolean p_29371_, BlockState p_29372_, BlockPos p_29373_) {
	}

	public boolean hurt(DamageSource p_29378_, float p_29379_) {
		if (this.isInvulnerableTo(p_29378_)) {
			return false;
		} else {
			if (!this.level().isClientSide) {
				this.setOrderedToSit(false);
			}

			return super.hurt(p_29378_, p_29379_);
		}
	}


	@Override
	public float getStepHeight() {
		return 1.6F;
	}

	public final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

	public <T extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<T> tAnimationState) {
		double currentSpeed = this.getDeltaMovement().lengthSqr();
		double speedThreshold = 0.02;
		double x = this.getX() - this.xo;
		double z = this.getZ() - this.zo;
		boolean isMoving = (x * x + z * z) > 0.0001;

		AnimationController<T> controller = tAnimationState.getController();

		if (this.isFlying()) {
			controller.setAnimation(RawAnimation.begin().then("fly", Animation.LoopType.LOOP));
			controller.setAnimationSpeed(2.6);
		}

		if (isMoving) {
			if (this.onGround()) {
				controller.setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(0.9);
			}
		} else {
			if (isInSittingPose() || isRidingShoulder()) {
				controller.setAnimation(RawAnimation.begin().then("sit", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(0.9);
			} else {
				controller.setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(1.0);
			}
		}

		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, "controller", 2, this::predicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.geoCache;
	}

	public float getVoicePitch() {
		return getPitch(this.random);
	}

	public static float getPitch(RandomSource source) {
		return (source.nextFloat() - source.nextFloat()) * 0.2F + 2.5F;
	}

	@Nullable
	public SoundEvent getAmbientSound() {
		return getAmbient(this.level(), this.level().random);
	}

	public static SoundEvent getAmbient(Level level, RandomSource source) {
		return DDDSoundEvents.RAPTOR_AMBIENT.get();
	}

	public SoundEvent getDeathSound() {
		super.getDeathSound();
		return SoundEvents.PHANTOM_DEATH;
	}

	public SoundEvent getHurtSound(DamageSource p_30720_) {
		super.getHurtSound(p_30720_);
		return SoundEvents.PHANTOM_DEATH;
	}

	public void playStepSound(BlockPos p_28254_, BlockState p_28255_) {
		this.playSound(SoundEvents.WOLF_STEP, 0.15F, 1.0F);
	}

	// Generates the base texture
	public ResourceLocation getFemaleTextureLocation() {
		return AnurognathusModel.FemaleVariant.variantFromOrdinal(getVariant()).resourceLocation;
	}

	public ResourceLocation getMaleTextureLocation() {
		return AnurognathusModel.MaleVariant.variantFromOrdinal(getVariant()).resourceLocation;
	}

	public static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Anurognathus.class, EntityDataSerializers.INT);

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
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("Variant", getVariant());
		tag.putInt("Gender", getGender());
		tag.putInt("EggLayTime", this.eggTime);
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
			setVariant(random.nextInt(AnurognathusModel.FemaleVariant.values().length));
		} else if (this.isMale()) {
			setVariant(random.nextInt(AnurognathusModel.MaleVariant.values().length));
		}

		return super.finalizeSpawn(serverLevelAccessor, instance, spawnType, data, tag);
	}

	public boolean canParent() {
		return !this.isBaby() && this.isInLove();
	}

	public boolean canMate(Animal animal) {
		if (animal == this) {
			return false;
		} else if (!(animal instanceof Anurognathus)) {
			return false;
		} else {
			if (!DeadlyDinosCommonConfig.GENDERS_AFFECT_BREEDING.get()) {
				return this.canParent() && ((Anurognathus) animal).canParent();
			} else {
				Anurognathus partner = (Anurognathus) animal;
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
			ItemStack fertilizedEgg = new ItemStack(DDDItems.FERTILIZED_ANUROGNATHUS_EGG.get());
			ItemEntity eggEntity = new ItemEntity(serverLevel, this.getX(), this.getY(), this.getZ(), fertilizedEgg);
			serverLevel.addFreshEntity(eggEntity);
		}

		serverLevel.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.CHICKEN_EGG, SoundSource.NEUTRAL, 1.0F, 1.0F);
	}

	protected static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Anurognathus.class, EntityDataSerializers.BYTE);

	@Override
	public void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(VARIANT, 0);
		this.entityData.define(GENDER, 0);
		this.entityData.define(DATA_FLAGS_ID, (byte)0);
	}

	@Override
	public void dropCustomDeathLoot(DamageSource p_33574_, int p_33575_, boolean p_33576_) {
		super.dropCustomDeathLoot(p_33574_, p_33575_, p_33576_);
		Random random = new Random();

		int eggChance = random.nextInt(100);
		if (this.isFemale() && this.isFemale() && eggChance <= DeadlyDinosCommonConfig.EGG_CHANCE.get()) {
			this.spawnAtLocation(DDDItems.FERTILIZED_ANUROGNATHUS_EGG.get());
		}
	}

}
