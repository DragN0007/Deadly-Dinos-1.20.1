package com.dragn0007.deadlydinos.entities.anomaly;

import com.dragn0007.deadlydinos.entities.EntityTypes;
import com.dragn0007.deadlydinos.entities.ai.AnomalyNearestAttackableTargetGoal;
import com.dragn0007.deadlydinos.entities.util.AbstractDino;
import com.dragn0007.deadlydinos.entities.util.DDDAnimations;
import com.dragn0007.deadlydinos.items.DDDItems;
import com.dragn0007.deadlydinos.util.DDDSoundEvents;
import com.dragn0007.deadlydinos.util.DDDTags;
import com.dragn0007.deadlydinos.util.DeadlyDinosCommonConfig;
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
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
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

public class AnomalyAcrocanthosaurus extends AbstractDino implements GeoEntity {

	public AnomalyAcrocanthosaurus(EntityType<? extends AnomalyAcrocanthosaurus> type, Level level) {
		super(type, level);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 150.0D)
				.add(Attributes.ATTACK_DAMAGE, 20D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1F)
				.add(Attributes.ARMOR_TOUGHNESS, 8D)
				.add(Attributes.ARMOR, 12D)
				.add(Attributes.MOVEMENT_SPEED, 0.32F)
				.add(Attributes.FOLLOW_RANGE, 64D);
	}

	public static final Ingredient FOOD_ITEMS = Ingredient.of(DDDTags.Items.CARNIVORE_EATS);

	public boolean isFood(ItemStack itemStack) {
		return FOOD_ITEMS.test(itemStack);
	}

	public void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(1, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 2.0D, true));
		this.goalSelector.addGoal(1, new AnomalyNearestAttackableTargetGoal<>(this, Monster.class, false));

		this.goalSelector.addGoal(3, new SearchForCarnivoreFoodGoal());

		this.goalSelector.addGoal(1, new AnomalyNearestAttackableTargetGoal<>(this, Player.class, 4, true, false,
				entity -> entity instanceof Player && !this.isBaby()));

		this.goalSelector.addGoal(2, new AnomalyNearestAttackableTargetGoal<>(this, LivingEntity.class, 4, true, false,
				entity -> entity.getType().is(DDDTags.Entity_Types.LARGE_PREDATOR_PREY) && !this.isBaby()));

		this.goalSelector.addGoal(2, new AnomalyNearestAttackableTargetGoal<>(this, LivingEntity.class, 4, true, false,
				entity -> entity.getType().is(DDDTags.Entity_Types.PREDATORS) && !this.isBaby() && !(entity.getType() == (EntityTypes.ANOMALOUS_ACROCANTHOSAURUS_ENTITY.get()))));

		this.goalSelector.addGoal(2, new AnomalyNearestAttackableTargetGoal<>(this, LivingEntity.class, 4, true, false,
				entity -> entity.getType().is(DDDTags.Entity_Types.HERBIVORES) && !this.isBaby()));
	}

	public int regenHealthCounter = 0;

	public void tick() {
		super.tick();

		regenHealthCounter++;

		if (this.getHealth() < this.getMaxHealth() && regenHealthCounter >= 150 && this.isAlive()) {
			this.setHealth(this.getHealth() + 4);
			regenHealthCounter = 0;
			this.level().addParticle(ParticleTypes.HEART, this.getRandomX(0.6D), this.getRandomY(), this.getRandomZ(0.6D), 0.7D, 0.7D, 0.7D);
		}

		if (this.getHealth() < this.getMaxHealth()) {
			if (!this.hasStrengthEffect()) {
				this.applyStrengthEffect();
			}
			if (!this.hasSpeedEffect()) {
				this.applySpeedEffect();
			}
		} else {
			if (this.hasStrengthEffect()) {
				this.removeStrengthEffect();
			}
			if (this.hasSpeedEffect()) {
				this.removeSpeedEffect();
			}
		}

		if (this.getHealth() < this.getMaxHealth() / 3) {
			if (!this.hasStrengthEffect()) {
				this.applyStrengthEffect();
			}
			if (!this.hasSpeedEffect()) {
				this.applySpeedEffect();
			}
		} else {
			if (this.hasStrengthEffect()) {
				this.removeStrengthEffect();
			}
			if (this.hasSpeedEffect()) {
				this.removeSpeedEffect();
			}
		}

	}

	@Override
	public void aiStep() {
		super.aiStep();

		if (this.getHealth() < this.getMaxHealth()) {
			this.level().addParticle(ParticleTypes.SOUL, this.getRandomX(0.6D), this.getRandomY(), this.getRandomZ(0.6D), 0.0D, 0.0D, 0.0D);
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

	public void applyStrengthEffect() {
		MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 2, false, false);
		this.addEffect(effectInstance);
	}

	public boolean hasStrengthEffect() {
		return this.hasEffect(MobEffects.DAMAGE_BOOST);
	}

	public void removeStrengthEffect() {
		this.removeEffect(MobEffects.DAMAGE_BOOST);
	}

	public void applySpeedEffect() {
		MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 2, false, false);
		this.addEffect(effectInstance);
	}

	public boolean hasSpeedEffect() {
		return this.hasEffect(MobEffects.MOVEMENT_SPEED);
	}

	public void removeSpeedEffect() {
		this.removeEffect(MobEffects.MOVEMENT_SPEED);
	}

	public void applyAbsorptionEffect() {
		MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.ABSORPTION, 200, 2, false, false);
		this.addEffect(effectInstance);
	}

	public boolean hasAbsorptionEffect() {
		return this.hasEffect(MobEffects.ABSORPTION);
	}

	public void removeAbsorptionEffect() {
		this.removeEffect(MobEffects.ABSORPTION);
	}

	public boolean hurt(DamageSource source, float v) {
		super.hurt(source, v);
		Entity entity = source.getDirectEntity();
		if (entity instanceof AbstractArrow) {
			return false;
		}
		if (source.is(DamageTypes.ON_FIRE) || source.is(DamageTypes.IN_FIRE)) {
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
		double currentSpeed = this.getDeltaMovement().lengthSqr();
		double speedThreshold = 0.01;

		AnimationController<T> controller = tAnimationState.getController();

		if (tAnimationState.isMoving()) {
			if (hasSpeedEffect()) {
				controller.setAnimation(RawAnimation.begin().then("anomaly_sprint", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(2.2);
			} else if (!hasSpeedEffect() && currentSpeed > speedThreshold) {
				controller.setAnimation(RawAnimation.begin().then("anomaly_sprint", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(1.8);
			} else {
				controller.setAnimation(RawAnimation.begin().then("anomaly_walk", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(1.4);
			}
		} else {
			controller.setAnimation(RawAnimation.begin().then("anomaly_idle", Animation.LoopType.LOOP));
			controller.setAnimationSpeed(1.0);
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
		return DDDSoundEvents.LARGE_CARNIVORE_AMBIENT.get();
	}

	public SoundEvent getDeathSound() {
		super.getDeathSound();
		return SoundEvents.PHANTOM_DEATH;
	}

	public SoundEvent getHurtSound(DamageSource p_30720_) {
		super.getHurtSound(p_30720_);
		return SoundEvents.POLAR_BEAR_WARNING;
	}

	public void playStepSound(BlockPos p_28254_, BlockState p_28255_) {
		this.playSound(SoundEvents.POLAR_BEAR_STEP, 0.15F, 1.0F);
	}

	// Generates the base texture
	public ResourceLocation getFemaleTextureLocation() {
		return AnomalyAcrocanthosaurusModel.FemaleVariant.variantFromOrdinal(getVariant()).resourceLocation;
	}

	public ResourceLocation getMaleTextureLocation() {
		return AnomalyAcrocanthosaurusModel.MaleVariant.variantFromOrdinal(getVariant()).resourceLocation;
	}

	public static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(AnomalyAcrocanthosaurus.class, EntityDataSerializers.INT);

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
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("Variant", getVariant());
		tag.putInt("Gender", getGender());
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
			setVariant(random.nextInt(AnomalyAcrocanthosaurusModel.FemaleVariant.values().length));
		} else if (this.isMale()) {
			setVariant(random.nextInt(AnomalyAcrocanthosaurusModel.MaleVariant.values().length));
		}

		return super.finalizeSpawn(serverLevelAccessor, instance, spawnType, data, tag);
	}

	public boolean canParent() {
		return false;
	}

	public boolean canMate(Animal animal) {
		return false;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
		return null;
	}

	@Override
	public void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(VARIANT, 0);
		this.entityData.define(GENDER, 0);
	}

	@Override
	protected void dropCustomDeathLoot(DamageSource p_33574_, int p_33575_, boolean p_33576_) {
		super.dropCustomDeathLoot(p_33574_, p_33575_, p_33576_);
		Random random = new Random();

		int eggChance = random.nextInt(100);
		if (this.isFemale() && eggChance <= 15) {
			this.spawnAtLocation(DDDItems.FERTILIZED_ACROCANTHOSAURUS_EGG.get());
		}

		this.spawnAtLocation(DDDItems.ACROCANTHOSAURUS_TROPHY.get());
	}

}
