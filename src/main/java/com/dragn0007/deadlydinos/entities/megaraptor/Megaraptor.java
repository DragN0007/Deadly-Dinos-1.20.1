package com.dragn0007.deadlydinos.entities.megaraptor;

import com.dragn0007.deadlydinos.entities.EntityTypes;
import com.dragn0007.deadlydinos.entities.ai.DinoNearestAttackableTargetGoal;
import com.dragn0007.deadlydinos.entities.ai.MegaraptorFollowPackLeaderGoal;
import com.dragn0007.deadlydinos.entities.ai.StalkMeleeAttackGoal;
import com.dragn0007.deadlydinos.entities.ai.UtahraptorFollowPackLeaderGoal;
import com.dragn0007.deadlydinos.entities.util.AbstractDino;
import com.dragn0007.deadlydinos.entities.util.DDDAnimations;
import com.dragn0007.deadlydinos.items.DDDItems;
import com.dragn0007.deadlydinos.util.DDDSoundEvents;
import com.dragn0007.deadlydinos.util.DDDTags;
import com.dragn0007.deadlydinos.util.DeadlyDinosCommonConfig;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.Util;
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
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
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
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Megaraptor extends AbstractDino implements GeoEntity {

	//todo: eggs

	public Megaraptor(EntityType<? extends Megaraptor> type, Level level) {
		super(type, level);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 50.0D)
				.add(Attributes.ATTACK_DAMAGE, 10D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.8F)
				.add(Attributes.ARMOR_TOUGHNESS, 2D)
				.add(Attributes.ARMOR, 4D)
				.add(Attributes.MOVEMENT_SPEED, 0.28F)
				.add(Attributes.FOLLOW_RANGE, 46D);
	}

	public static final Ingredient FOOD_ITEMS = Ingredient.of(DDDTags.Items.CARNIVORE_EATS);
	public boolean isFood(ItemStack itemStack) {
		return FOOD_ITEMS.test(itemStack);
	}

	public void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(1, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.7F));
		this.goalSelector.addGoal(1, new DinoNearestAttackableTargetGoal<>(this, Monster.class, false));

		this.goalSelector.addGoal(1, new StalkMeleeAttackGoal(this, 2.0D, true));
		this.goalSelector.addGoal(3, new MegaraptorFollowPackLeaderGoal(this));
		this.goalSelector.addGoal(3, new SearchForCarnivoreFoodGoal());
		this.goalSelector.addGoal(3, new DinoPanicGoal(2.0D));

		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 15.0F, 1.8F, 1.8F,
				entity -> entity instanceof Player && this.isBaby()));

		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, LivingEntity.class, 15.0F, 1.8F, 1.8F,
				entity -> entity.getType().is(DDDTags.Entity_Types.SMALL_DINOS_RUN_FROM) && this.isBaby()));

		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, LivingEntity.class, 15.0F, 2.0F, 1.8F,
				entity -> entity.getType().is(DDDTags.Entity_Types.MEDIUM_DINOS_RUN_FROM) && !this.hasFollowers() && !this.isFollower()));

		this.goalSelector.addGoal(1, new DinoNearestAttackableTargetGoal<>(this, Player.class, 2, true, false,
				entity -> entity instanceof Player && !this.isBaby()));

		this.goalSelector.addGoal(2, new DinoNearestAttackableTargetGoal<>(this, LivingEntity.class, 2, true, false,
				entity -> entity.getType().is(DDDTags.Entity_Types.MEDIUM_PREDATOR_PREY) && !this.isBaby()));

		this.goalSelector.addGoal(2, new DinoNearestAttackableTargetGoal<>(this, LivingEntity.class, 2, true, false,
				entity -> entity.getType().is(DDDTags.Entity_Types.LARGE_PREDATORS) && !this.isBaby() && (this.isFollower() || this.hasFollowers())));

		this.goalSelector.addGoal(2, new DinoNearestAttackableTargetGoal<>(this, LivingEntity.class, 2, true, false,
				entity -> entity.getType().is(DDDTags.Entity_Types.MEDIUM_PREDATORS)  && !(entity.getType() == (EntityTypes.UTAHRAPTOR_ENTITY.get())) && !entity.getType().is(DDDTags.Entity_Types.RAPTORS) && !this.isBaby() && (this.isFollower() || this.hasFollowers())));

		this.goalSelector.addGoal(2, new DinoNearestAttackableTargetGoal<>(this, LivingEntity.class, 2, true, false,
				entity -> entity.getType().is(DDDTags.Entity_Types.SMALL_PREDATORS) && !this.isBaby()));

		this.goalSelector.addGoal(2, new DinoNearestAttackableTargetGoal<>(this, LivingEntity.class, 2, true, false,
				entity -> entity.getType().is(DDDTags.Entity_Types.HERBIVORES) && !this.isBaby() && (this.isFollower() || this.hasFollowers())));

		this.goalSelector.addGoal(2, new DinoNearestAttackableTargetGoal<>(this, LivingEntity.class, 2, true, false,
				entity -> (entity.getType().is(DDDTags.Entity_Types.SMALL_HERBIVORES) || entity.getType().is(DDDTags.Entity_Types.MEDIUM_HERBIVORES)) && !this.isBaby()));
	}

	public boolean doHurtTarget(Entity entity) {
		Random random = new Random();
		int chance = random.nextInt(100);
		if (super.doHurtTarget(entity)) {
			if (entity instanceof LivingEntity) {
				int i = 0;
				if (this.level().getDifficulty() == Difficulty.NORMAL) {
					i = 7;
				} else if (this.level().getDifficulty() == Difficulty.HARD) {
					i = 15;
				}

				if (i > 0 && chance <= 50) {
					((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, i * 20, 0), this);
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public int calculateFallDamage(float v, float v1) {
		return super.calculateFallDamage(v, v1) - 10;
	}

	public Megaraptor leader;
	public int packSize = 1;

	public int getMaxHerdSize() {
		return DeadlyDinosCommonConfig.MEGARAPTOR_MAX_PACK_COUNT.get();
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

	public void addFollowers(Stream<? extends Megaraptor> p_27534_) {
		p_27534_.limit((long)(this.getMaxHerdSize() - this.packSize)).filter((mob) -> {
			return mob != this;
		}).forEach((mob) -> {
			mob.startFollowing(this);
		});
	}

	public boolean isFollower() {
		return this.leader != null && this.leader.isAlive();
	}

	public Megaraptor startFollowing(Megaraptor mob) {
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


	public void tick() {
		super.tick();

		if (this.hasFollowers() && this.level().random.nextInt(200) == 1) {
			List<? extends Megaraptor> list = this.level().getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
			if (list.size() <= 1) {
				this.packSize = 1;
			}
		}

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

		if (this.isDoneStalking()) {
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

	public void applyStrengthEffect() {
		MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1, false, false);
		this.addEffect(effectInstance);
	}

	public boolean hasStrengthEffect() {
		return this.hasEffect(MobEffects.DAMAGE_BOOST);
	}

	public void removeStrengthEffect() {
		this.removeEffect(MobEffects.DAMAGE_BOOST);
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

	public int eggTime = this.random.nextInt(DeadlyDinosCommonConfig.DINO_EGG_LAY_TIME.get()) + 6000;

	@Override
	public void aiStep() {
		super.aiStep();

		if (!this.level().isClientSide && this.isAlive() && !this.isBaby() && --this.eggTime <= 0 && (!DeadlyDinosCommonConfig.GENDERS_AFFECT_BIPRODUCTS.get() || (DeadlyDinosCommonConfig.GENDERS_AFFECT_BIPRODUCTS.get() && this.isFemale()))) {
			this.spawnAtLocation(DDDItems.UTAHRAPTOR_EGG.get());
			this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			this.eggTime = this.random.nextInt(DeadlyDinosCommonConfig.DINO_EGG_LAY_TIME.get()) + 6000;
		}

		if (this.horizontalCollision && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this) && this.isAggressive()) {
			boolean griefEvent = false;
			AABB aabb = this.getBoundingBox().inflate(0.3D);

			for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
				BlockState blockstate = this.level().getBlockState(blockpos);
				if (blockstate.is(DDDTags.Blocks.MEDIUM_DINO_DESTROYS) && DeadlyDinosCommonConfig.MEDIUM_DINOS_DESTROY_BLOCKS.get()) {
					griefEvent = this.level().destroyBlock(blockpos, true, this) || griefEvent;
				}
			}
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
		double stalkSpeedThreshold = 0.01;
		double x = this.getX() - this.xo;
		double z = this.getZ() - this.zo;
		boolean isMoving = (x * x + z * z) > 0.0001;

		AnimationController<T> controller = tAnimationState.getController();

		if (!this.onGround() && this.isAggressive()) {
			controller.setAnimation(RawAnimation.begin().then("jump", Animation.LoopType.LOOP));
			controller.setAnimationSpeed(1.5);
		} else if (isMoving) {
			if (currentSpeed > speedThreshold && this.onGround()) {
				controller.setAnimation(RawAnimation.begin().then("sprint", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(2.2);
			} else if (currentSpeed < stalkSpeedThreshold) {
				controller.setAnimation(RawAnimation.begin().then("stalk", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(1.0);
			} else {
				controller.setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
				controller.setAnimationSpeed(2.0);
			}
		} else {
			controller.setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
			controller.setAnimationSpeed(0.9);
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
		return MegaraptorModel.FemaleVariant.variantFromOrdinal(getVariant()).resourceLocation;
	}

	public ResourceLocation getMaleTextureLocation() {
		return MegaraptorModel.MaleVariant.variantFromOrdinal(getVariant()).resourceLocation;
	}

	public static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Megaraptor.class, EntityDataSerializers.INT);

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
			setVariant(random.nextInt(MegaraptorModel.FemaleVariant.values().length));
		} else if (this.isMale()) {
			setVariant(random.nextInt(MegaraptorModel.MaleVariant.values().length));
		}

		return super.finalizeSpawn(serverLevelAccessor, instance, spawnType, data, tag);
	}

	public boolean canParent() {
		return !this.isBaby() && this.isInLove();
	}

	public boolean canMate(Animal animal) {
		if (animal == this) {
			return false;
		} else if (!(animal instanceof Megaraptor)) {
			return false;
		} else {
			if (!DeadlyDinosCommonConfig.GENDERS_AFFECT_BREEDING.get()) {
				return this.canParent() && ((Megaraptor) animal).canParent();
			} else {
				Megaraptor partner = (Megaraptor) animal;
				if (this.canParent() && partner.canParent() && this.getGender() != partner.getGender()) {
					return true;
				}

				if (DeadlyDinosCommonConfig.GENDERS_AFFECT_BREEDING.get() && this.canParent() && partner.canParent() && this.getGender() != partner.getGender()) {
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

		if (this.isMale() || !this.isInLove() || !this.isAlive() || eggsLaid >= DeadlyDinosCommonConfig.DINO_EGG_LAY_AMOUNT.get()) {
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

		if (this.isFemale()) {
			ItemStack fertilizedEgg = new ItemStack(DDDItems.FERTILIZED_UTAHRAPTOR_EGG.get());
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
	}

	@Override
	public void dropCustomDeathLoot(DamageSource p_33574_, int p_33575_, boolean p_33576_) {
		super.dropCustomDeathLoot(p_33574_, p_33575_, p_33576_);
		Random random = new Random();

		int eggChance = random.nextInt(100);
		if (this.isFemale() && eggChance <= 5) {
			this.spawnAtLocation(DDDItems.FERTILIZED_UTAHRAPTOR_EGG.get());
		}

		int trophyChance = random.nextInt(100);
		if (trophyChance <= 8) {
			this.spawnAtLocation(DDDItems.UTAHRAPTOR_TROPHY.get());
		}
	}

}
