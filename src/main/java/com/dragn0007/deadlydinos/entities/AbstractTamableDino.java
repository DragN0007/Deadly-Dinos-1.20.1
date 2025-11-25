package com.dragn0007.deadlydinos.entities;

import com.dragn0007.deadlydinos.util.DDDTags;
import com.dragn0007.deadlydinos.util.DeadlyDinosCommonConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractTamableDino extends TamableAnimal {

    public AbstractTamableDino(EntityType<? extends TamableAnimal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    double x = this.getX() - this.xo;
    double z = this.getZ() - this.zo;
    public boolean isMoving = (x * x + z * z) > 0.0001;

    public boolean doneStalking = false;
    public boolean isDoneStalking() {
        return this.doneStalking;
    }
    public void setDoneStalking(boolean doneStalking) {
        this.doneStalking = doneStalking;
    }

    public boolean isOnSand() {
        BlockState blockState = this.level().getBlockState(this.blockPosition().below());
        return blockState.is(DDDTags.Blocks.SAND);
    }

    public boolean isOnSnow() {
        BlockState blockState = this.level().getBlockState(this.blockPosition().below());
        return blockState.is(Blocks.SNOW) || blockState.is(Blocks.SNOW_BLOCK) || blockState.is(Blocks.POWDER_SNOW);
    }

    public enum Gender {
        FEMALE,
        MALE
    }

    public boolean isFemale() {
        return this.getGender() == 0;
    }
    public boolean isMale() {
        return this.getGender() == 1;
    }
    public static final EntityDataAccessor<Integer> GENDER = SynchedEntityData.defineId(AbstractTamableDino.class, EntityDataSerializers.INT);
    public int getGender() {
        return this.entityData.get(GENDER);
    }
    public void setGender(int gender) {
        this.entityData.set(GENDER, gender);
    }

    public boolean eat = false;
    public boolean isEating() {
        return this.eat;
    }
    public void setEating(boolean eating) {
        this.eat = eating;
    }

    int eatingTick = 0;

    public void tick() {
        super.tick();

        if (eatingTick >= 20) {
            eatingTick = 0;
            setEating(false);
        }

        if (isEating()) {
            eatingTick++;
            navigation.stop();
            setEating(false);
        }
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (this.isFood(itemStack)) {
            int i = this.getAge();
            if (!this.level().isClientSide && i == 0 && this.canFallInLove()) {
                this.usePlayerItem(player, hand, itemStack);
                this.setInLove(player);
                return InteractionResult.SUCCESS;
            }
        }

        if (DeadlyDinosCommonConfig.ALLOW_TAMING.get() && this.isBaby() && !this.isTame() && this.isFood(itemStack) && this.random.nextInt(5) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
            this.tame(player);
            return InteractionResult.SUCCESS;
        }

        if (this.isTame() && this.isBaby() && this.isFood(itemStack)) {
            int i = this.getAge();
            this.usePlayerItem(player, hand, itemStack);
            this.ageUp(getSpeedUpSecondsWhenFeeding(-i), true);
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }

        if (this.level().isClientSide) {
            boolean flag = this.isOwnedBy(player) || this.isTame() || this.isFood(itemStack) && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else if (this.isTame()) {
            if (this.isFood(itemStack) && this.getHealth() < this.getMaxHealth()) {
                this.heal(2.0F);

                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }

                this.gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            } else {
                InteractionResult interactionresult = super.mobInteract(player, hand);
                return interactionresult;
            }
        }

        return InteractionResult.sidedSuccess(this.level().isClientSide);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Wandering", this.getToldToWander());
        tag.putBoolean("Panicking", this.getPanicking());
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);

        if (tag.contains("Wandering")) {
            this.setToldToWander(tag.getBoolean("Wandering"));
        }

        if (tag.contains("Panicking")) {
            this.setPanicking(tag.getBoolean("Panicking"));
        }
    }

    public boolean isPanicking = false;

    public boolean isPanicking() {
        return this.getHealth() < this.getMaxHealth() / 3 && this.isAlive();
    }

    public boolean getPanicking() {
        return this.isPanicking;
    }

    public void setPanicking(boolean panicking) {
        this.isPanicking = panicking;
    }

    class DinoPanicGoal extends PanicGoal {
        public DinoPanicGoal(double v) {
            super(AbstractTamableDino.this, v);
        }

        public boolean shouldPanic() {
            return this.mob.isFreezing() || this.mob.isOnFire() || this.mob.getHealth() < this.mob.getMaxHealth() / 3 && this.mob.isAlive();
        }
    }

    public boolean toldToWander = false;

    public boolean wasToldToWander() {
        return this.toldToWander;
    }

    public boolean getToldToWander() {
        return this.toldToWander;
    }

    public void setToldToWander(boolean toldToWander) {
        this.toldToWander = toldToWander;
    }

    int moreCropsTicks;

    static class PickCropsGoal extends MoveToBlockGoal {
        public final AbstractTamableDino dino;
        public boolean wantsToPick;
        public boolean canPick;

        public PickCropsGoal(AbstractTamableDino dino) {
            super(dino, 0.7F, 16);
            this.dino = dino;
        }

        public boolean canUse() {
        if (this.dino.isTame()) {
            return false;
            } else if (this.nextStartTick <= 0) {
                if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.dino.level(), this.dino)) {
                    return false;
                }

                this.canPick = false;
                this.wantsToPick = true;
            }

            return super.canUse();
        }

        public boolean canContinueToUse() {
            return this.canPick && super.canContinueToUse();
        }

        public void tick() {
            super.tick();

            this.dino.getLookControl().setLookAt(
                    (double)this.blockPos.getX() + 0.5D,
                    this.blockPos.getY() + 1,
                    (double)this.blockPos.getZ() + 0.5D, 10.0F,
                    (float)this.dino.getMaxHeadXRot());

            if (this.isReachedTarget()) {
                Level level = this.dino.level();
                BlockPos blockpos = this.blockPos.above();
                BlockState blockstate = level.getBlockState(blockpos);
                Block block = blockstate.getBlock();

                if (this.canPick && block instanceof CropBlock) {
                    blockstate.getBlock().getDrops(blockstate, (ServerLevel) level, blockpos, null).forEach
                            (stack -> level.addFreshEntity(new ItemEntity(level,
                                    blockpos.getX() + 0.5,
                                    blockpos.getY() + 0.5,
                                    blockpos.getZ() + 0.5, stack)));

                    level.destroyBlock(blockPos, true);
                    level.levelEvent(2001, blockpos, Block.getId(blockstate));
                }

                this.dino.setEating(true);
                this.dino.moreCropsTicks = 0;
                this.canPick = false;
                this.nextStartTick = 0;
            }

        }

        public boolean isValidTarget(LevelReader levelReader, BlockPos blockPos) {
            BlockState blockstate = levelReader.getBlockState(blockPos);
            if (blockstate.is(Blocks.FARMLAND) && this.wantsToPick && !this.canPick) {
                blockstate = levelReader.getBlockState(blockPos.above());
                if (blockstate.getBlock() instanceof CropBlock) {
                    this.canPick = true;
                    return true;
                }
            }

            return false;
        }
    }

    static final Predicate<ItemEntity> DESIRABLE_CARNIVORE_LOOT = (itemEntity) -> {
        return !itemEntity.hasPickUpDelay() && itemEntity.isAlive() && itemEntity.getItem().is(DDDTags.Items.CARNIVORE_DESIRES);
    };

    public class SearchForCarnivoreFoodGoal extends Goal {

        public SearchForCarnivoreFoodGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            if (isTame()) {
                return false;
            } else if (isInPowderSnow) {
                return false;
            } else if (AbstractTamableDino.this.getTarget() == null && AbstractTamableDino.this.getLastHurtByMob() == null) {
                if (AbstractTamableDino.this.getRandom().nextInt(reducedTickDelay(10)) != 0) {
                    return false;
                } else {
                    List<ItemEntity> list = AbstractTamableDino.this.level().getEntitiesOfClass(ItemEntity.class, AbstractTamableDino.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), AbstractTamableDino.DESIRABLE_CARNIVORE_LOOT);
                    return !list.isEmpty();
                }
            } else {
                return false;
            }
        }

        @Override
        public void tick() {
            List<ItemEntity> itemEntities = level().getEntitiesOfClass(ItemEntity.class, getBoundingBox().inflate(8.0D, 8.0D, 8.0D), AbstractTamableDino.DESIRABLE_CARNIVORE_LOOT);

            if (!itemEntities.isEmpty()) {
                ItemEntity itemEntity = itemEntities.get(0);
                getNavigation().moveTo(itemEntity, 1.0D);

                if (distanceToSqr(itemEntity) < 10.0D && itemEntity.getItem().is(DDDTags.Items.CARNIVORE_DESIRES)) {
                    pickUpItem(itemEntity);
                }
            }
        }

        @Override
        public void start() {
            List<ItemEntity> itemEntities = level().getEntitiesOfClass(ItemEntity.class, getBoundingBox().inflate(8.0D, 8.0D, 8.0D), AbstractTamableDino.DESIRABLE_CARNIVORE_LOOT);
            if (!itemEntities.isEmpty()) {
                getNavigation().moveTo(itemEntities.get(0), 1.0D);
            }
        }

        public void pickUpItem(ItemEntity itemEntity) {
            if (itemEntity.getItem().is(DDDTags.Items.CARNIVORE_DESIRES) && this.canUse()) {
                ItemStack itemStack = itemEntity.getItem();
                itemStack.shrink(1);

                if (itemStack.isEmpty()) {
                    itemEntity.discard();
                }
            }
        }
    }

    static final Predicate<ItemEntity> DESIRABLE_HERBIVORE_LOOT = (itemEntity) -> {
        return !itemEntity.hasPickUpDelay() && itemEntity.isAlive() && itemEntity.getItem().is(DDDTags.Items.HERBIVORE_EATS);
    };

    public class SearchForHerbivoreFoodGoal extends Goal {

        public SearchForHerbivoreFoodGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            if (isTame()) {
                return false;
            }
            List<ItemEntity> list = AbstractTamableDino.this.level().getEntitiesOfClass(ItemEntity.class, AbstractTamableDino.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), AbstractDino.DESIRABLE_HERBIVORE_LOOT);
            return !list.isEmpty();
        }

        @Override
        public void tick() {
            List<ItemEntity> itemEntities = level().getEntitiesOfClass(ItemEntity.class, getBoundingBox().inflate(8.0D, 8.0D, 8.0D), AbstractDino.DESIRABLE_HERBIVORE_LOOT);

            if (!itemEntities.isEmpty()) {
                ItemEntity itemEntity = itemEntities.get(0);
                getNavigation().moveTo(itemEntity, 1.0D);

                if (distanceToSqr(itemEntity) < 20.0D && itemEntity.getItem().is(DDDTags.Items.HERBIVORE_EATS)) {
                    pickUpItem(itemEntity);
                }
            }
        }

        @Override
        public void start() {
            List<ItemEntity> itemEntities = level().getEntitiesOfClass(ItemEntity.class, getBoundingBox().inflate(8.0D, 8.0D, 8.0D), AbstractDino.DESIRABLE_HERBIVORE_LOOT);
            if (!itemEntities.isEmpty()) {
                getNavigation().moveTo(itemEntities.get(0), 1.0D);
            }
        }

        public void pickUpItem(ItemEntity itemEntity) {
            if (itemEntity.getItem().is(DDDTags.Items.HERBIVORE_EATS) && this.canUse()) {
                ItemStack itemStack = itemEntity.getItem();
                itemStack.shrink(1);

                if (itemStack.isEmpty()) {
                    itemEntity.discard();
                }
            }
        }
    }



}