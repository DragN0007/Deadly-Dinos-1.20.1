package com.dragn0007.deadlydinos.entities.base;

import com.dragn0007.deadlydinos.util.DDDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractDino extends Animal {

    protected AbstractDino(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
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

    public static final EntityDataAccessor<Integer> GENDER = SynchedEntityData.defineId(AbstractDino.class, EntityDataSerializers.INT);

    public int getGender() {
        return this.entityData.get(GENDER);
    }

    public void setGender(int gender) {
        this.entityData.set(GENDER, gender);
    }

    private boolean eat = false;
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

    int moreCropsTicks;

    static class PickCropsGoal extends MoveToBlockGoal {
        public final AbstractDino dino;
        public boolean wantsToPick;
        public boolean canPick;

        public PickCropsGoal(AbstractDino dino) {
            super(dino, 0.7F, 16);
            this.dino = dino;
        }

        public boolean canUse() {
            if (this.nextStartTick <= 0) {
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
                this.dino.moreCropsTicks = 40;
                this.canPick = false;
                this.nextStartTick = 20;
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
        return !itemEntity.hasPickUpDelay() && itemEntity.isAlive() && itemEntity.getItem().is(DDDTags.Items.CARNIVORE_EATS);
    };

    public class SearchForCarnivoreFoodGoal extends Goal {

        public SearchForCarnivoreFoodGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            List<ItemEntity> list = AbstractDino.this.level().getEntitiesOfClass(ItemEntity.class, AbstractDino.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), AbstractDino.DESIRABLE_CARNIVORE_LOOT);
            return !list.isEmpty();
        }

        @Override
        public void tick() {
            List<ItemEntity> itemEntities = level().getEntitiesOfClass(ItemEntity.class, getBoundingBox().inflate(8.0D, 8.0D, 8.0D), AbstractDino.DESIRABLE_CARNIVORE_LOOT);

            if (!itemEntities.isEmpty()) {
                ItemEntity itemEntity = itemEntities.get(0);
                getNavigation().moveTo(itemEntity, 1.0D);

                if (distanceToSqr(itemEntity) < 20.0D && itemEntity.getItem().is(DDDTags.Items.CARNIVORE_EATS)) {
                    pickUpItem(itemEntity);
                }
            }
        }

        @Override
        public void start() {
            List<ItemEntity> itemEntities = level().getEntitiesOfClass(ItemEntity.class, getBoundingBox().inflate(8.0D, 8.0D, 8.0D), AbstractDino.DESIRABLE_CARNIVORE_LOOT);
            if (!itemEntities.isEmpty()) {
                getNavigation().moveTo(itemEntities.get(0), 1.0D);
            }
        }

        private void pickUpItem(ItemEntity itemEntity) {
            if (itemEntity.getItem().is(DDDTags.Items.CARNIVORE_EATS) && this.canUse()) {
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
            List<ItemEntity> list = AbstractDino.this.level().getEntitiesOfClass(ItemEntity.class, AbstractDino.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), AbstractDino.DESIRABLE_HERBIVORE_LOOT);
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

        private void pickUpItem(ItemEntity itemEntity) {
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