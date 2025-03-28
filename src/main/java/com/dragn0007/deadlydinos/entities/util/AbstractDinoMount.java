package com.dragn0007.deadlydinos.entities.util;

import com.dragn0007.deadlydinos.gui.MountMenu;
import com.dragn0007.deadlydinos.util.DDDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.animal.horse.AbstractChestedHorse;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.WoolCarpetBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public abstract class AbstractDinoMount extends AbstractChestedHorse {

    public net.minecraftforge.common.util.LazyOptional<?> itemHandler = null;

    public static final float MAX_HEALTH = generateMaxHealth((p_272504_) -> {
        return p_272504_ - 1;
    });

    public static final Ingredient FOOD_ITEMS = Ingredient.of(Items.WHEAT);
    public boolean isFood(ItemStack stack) {
        return FOOD_ITEMS.test(stack);
    }

    public static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("3c50e848-b2e3-404a-9879-7550b12dd09b");
    public static final UUID SPRINT_SPEED_MOD_UUID = UUID.fromString("c9379664-01b5-4e19-a7e9-11264453bdce");
    public static final UUID WALK_SPEED_MOD_UUID = UUID.fromString("59b55c98-e39b-45e2-846c-f91f3e9ea861");

    public static final AttributeModifier SPRINT_SPEED_MOD = new AttributeModifier(SPRINT_SPEED_MOD_UUID, "Sprint speed mod", 0.3D, AttributeModifier.Operation.MULTIPLY_TOTAL);
    public static final AttributeModifier WALK_SPEED_MOD = new AttributeModifier(WALK_SPEED_MOD_UUID, "Walk speed mod", -0.7D, AttributeModifier.Operation.MULTIPLY_TOTAL); // KEEP THIS NEGATIVE. It is calculated by adding 1. So -0.1 actually means 0.9

    public static final EntityDataAccessor<Integer> DATA_CARPET_ID = SynchedEntityData.defineId(AbstractDinoMount.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Optional<UUID>> DATA_OWNERUUID_ID = SynchedEntityData.defineId(AbstractDinoMount.class, EntityDataSerializers.OPTIONAL_UUID);

    public AbstractDinoMount(EntityType<? extends AbstractDinoMount> entityType, Level level) {
        super(entityType, level);
    }

    public void openInventory(Player player) {
        if(player instanceof ServerPlayer serverPlayer && this.isTamed()) {
            NetworkHooks.openScreen(serverPlayer, new SimpleMenuProvider((containerId, inventory, p) -> {
                return new MountMenu(containerId, inventory, this.inventory, this);
            }, this.getDisplayName()), (data) -> {
                data.writeInt(this.getInventorySize());
                data.writeInt(this.getId());
            });
        }
    }

    protected void createInventory() {
        SimpleContainer simplecontainer = this.inventory;
        this.inventory = new SimpleContainer(this.getInventorySize());
        if (simplecontainer != null) {
            simplecontainer.removeListener(this);
            int i = Math.min(simplecontainer.getContainerSize(), this.inventory.getContainerSize());

            for(int j = 0; j < i; ++j) {
                ItemStack itemstack = simplecontainer.getItem(j);
                if (!itemstack.isEmpty()) {
                    this.inventory.setItem(j, itemstack.copy());
                }
            }
        }

        this.inventory.addListener(this);
        this.updateContainerEquipment();
        this.itemHandler = net.minecraftforge.common.util.LazyOptional.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this.inventory));
    }

    @Override
    public void openCustomInventoryScreen(Player player) {
        this.openInventory(player);
    }

    @Override
    public boolean canParent() {
        return !this.isVehicle() && !this.isPassenger() && this.isTamed() && !this.isBaby() && this.isInLove();
    }

    @Override
    public boolean isSaddleable() {
        return this.isAlive() && !this.isBaby() && this.isTamed();
    }

    public boolean isSaddle(ItemStack itemStack) {
        return itemStack.getItem() instanceof SaddleItem;
    }

    @Override
    public void equipSaddle(@Nullable SoundSource p_30546_) {
        this.inventory.setItem(0, new ItemStack(Items.SADDLE));
    }

    @Override
    public boolean hasChest() {
        return this.entityData.get(DATA_ID_CHEST);
    }

    @Override
    public void setChest(boolean p_30505_) {
        this.entityData.set(DATA_ID_CHEST, p_30505_);
    }

    @Override
    public boolean isSaddled() {
        return this.getFlag(4);
    }

    @Override
    public boolean isArmor(ItemStack itemStack) {
        return itemStack.getItem() instanceof HorseArmorItem || itemStack.is(ItemTags.WOOL_CARPETS);
    }

    @Override
    public double getPassengersRidingOffset() {
        return super.getPassengersRidingOffset() - 0.25D;
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

    public static final EntityDataAccessor<Integer> GENDER = SynchedEntityData.defineId(AbstractDinoMount.class, EntityDataSerializers.INT);

    public int getGender() {
        return this.entityData.get(GENDER);
    }

    public void setGender(int gender) {
        this.entityData.set(GENDER, gender);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.is(Items.SHEARS) && player.isShiftKeyDown()) {
            if (this.hasChest()) {
                this.dropEquipment();
                this.inventory.removeAllItems();

                this.setChest(false);
                this.playChestEquipsSound();

                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }
        }

        if(!this.isBaby()) {
            if(this.isTamed() && player.isSecondaryUseActive()) {
                this.openInventory(player);
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }

            if(this.isVehicle()) {
                return super.mobInteract(player, hand);
            }
        }

        if(!itemStack.isEmpty()) {
            if(this.isFood(itemStack)) {
                return this.fedFood(player, itemStack);
            }

            InteractionResult interactionResult = itemStack.interactLivingEntity(player, this, hand);
            if(interactionResult.consumesAction()) {
                return interactionResult;
            }

            if(!this.isTamed()) {
                this.makeMad();
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }

            if(!this.hasChest() && itemStack.is(Blocks.CHEST.asItem())) {
                this.setChest(true);
                this.playChestEquipsSound();
                if(!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }

                this.createInventory();
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }

            boolean canSaddle = !this.isBaby() && !this.isSaddled() && this.isSaddle(itemStack);
            if(this.isArmor(itemStack) || canSaddle) {
                this.openInventory(player);
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }
        }

        if(this.isBaby()) {
            return super.mobInteract(player, hand);
        } else {
            this.doPlayerRide(player);
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }
    }

    @Override
    public boolean canWearArmor() {
        return true;
    }

    private static final EntityDataAccessor<Boolean> DATA_ID_CHEST = SynchedEntityData.defineId(AbstractDinoMount.class, EntityDataSerializers.BOOLEAN);

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_CARPET_ID, -1);
        this.entityData.define(DATA_ID_CHEST, false);
        this.entityData.define(DATA_OWNERUUID_ID, Optional.empty());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        if (!this.inventory.getItem(1).isEmpty()) {
            compoundTag.put("ArmorItem", this.inventory.getItem(1).save(new CompoundTag()));
        }

        if (!this.inventory.getItem(1).isEmpty()) {
            compoundTag.put("DecorItem", this.inventory.getItem(1).save(new CompoundTag()));
        }

        if (!this.inventory.getItem(0).isEmpty()) {
            compoundTag.put("SaddleItem", this.inventory.getItem(0).save(new CompoundTag()));
        }

        compoundTag.putBoolean("ChestedHorse", this.hasChest());
        if (this.hasChest()) {
            ListTag listtag = new ListTag();
        }

        if (this.getOwnerUUID() != null) {
            compoundTag.putUUID("Owner", this.getOwnerUUID());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if(compoundTag.contains("ArmorItem", 10)) {
            ItemStack itemStack = ItemStack.of(compoundTag.getCompound("ArmorItem"));
            if(!itemStack.isEmpty() && this.isArmor(itemStack)) {
                this.inventory.setItem(1, itemStack);
            }
        }

        if (compoundTag.contains("DecorItem", 10)) {
            this.inventory.setItem(1, ItemStack.of(compoundTag.getCompound("DecorItem")));
        }

        if (compoundTag.contains("SaddleItem", 10)) {
            ItemStack itemStack = ItemStack.of(compoundTag.getCompound("SaddleItem"));
            if(!itemStack.isEmpty() && this.isSaddle(itemStack)) {
                this.inventory.setItem(0, itemStack);
            }
        }

        this.setChest(compoundTag.getBoolean("ChestedHorse"));

        this.updateContainerEquipment();

        UUID uuid;
        if (compoundTag.hasUUID("Owner")) {
            uuid = compoundTag.getUUID("Owner");
        } else {
            String s = compoundTag.getString("Owner");
            uuid = OldUsersConverter.convertMobOwnerIfNecessary(this.getServer(), s);
        }

        if (uuid != null) {
            try {
                this.setOwnerUUID(uuid);
                this.setTamed(true);
            } catch (Throwable throwable) {
                this.setTamed(false);
            }
        }
    }

    @Nullable
    public UUID getOwnerUUID() {
        return this.entityData.get(DATA_OWNERUUID_ID).orElse((UUID)null);
    }

    public void setOwnerUUID(@Nullable UUID p_21817_) {
        this.entityData.set(DATA_OWNERUUID_ID, Optional.ofNullable(p_21817_));
    }

    public boolean isOwnedBy(LivingEntity p_21831_) {
        return p_21831_ == this.getOwner();
    }

    public ItemStack getArmor() {
        return this.getItemBySlot(EquipmentSlot.CHEST);
    }

    public void setArmor(ItemStack itemStack) {
        this.setItemSlot(EquipmentSlot.CHEST, itemStack);
        this.setDropChance(EquipmentSlot.CHEST, 0f);
    }

    public void setArmorEquipment(ItemStack itemStack) {
        this.setArmor(itemStack);
        if (!this.level().isClientSide) {
            this.getAttribute(Attributes.ARMOR).removeModifier(ARMOR_MODIFIER_UUID);

            if (itemStack.getItem() instanceof HorseArmorItem horseArmorItem) {
                int protection = horseArmorItem.getProtection();
                if (protection > 0) {
                    this.getAttribute(Attributes.ARMOR).addTransientModifier(
                            new AttributeModifier(ARMOR_MODIFIER_UUID, "Horse armor bonus", (double) protection, AttributeModifier.Operation.ADDITION)
                    );
                }
            }
        }
    }

    @Override
    public void updateContainerEquipment() {
       super.updateContainerEquipment();
       this.setArmorEquipment(this.inventory.getItem(1));
       this.setDropChance(EquipmentSlot.CHEST, 0f);
        if (!this.level().isClientSide) {
            super.updateContainerEquipment();
            this.setCarpet(getDyeColor(this.inventory.getItem(1)));
        }
    }

    public void setCarpet(@Nullable DyeColor p_30772_) {
        this.entityData.set(DATA_CARPET_ID, p_30772_ == null ? -1 : p_30772_.getId());
    }

    @Nullable
    public static DyeColor getDyeColor(ItemStack p_30836_) {
        Block block = Block.byItem(p_30836_.getItem());
        return block instanceof WoolCarpetBlock ? ((WoolCarpetBlock)block).getColor() : null;
    }

    @Nullable
    public DyeColor getCarpet() {
        int i = this.entityData.get(DATA_CARPET_ID);
        return i == -1 ? null : DyeColor.byId(i);
    }

    @Override
    public void containerChanged(Container container) {
        ItemStack prevArmor = this.getArmor();
        super.containerChanged(container);
        ItemStack newArmor = this.getArmor();
        if(this.tickCount > 20 && this.isArmor(newArmor) && prevArmor != newArmor) {
            this.playSound(SoundEvents.HORSE_ARMOR, 0.5f, 1f);
        }
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity livingEntity) {
        this.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(SPRINT_SPEED_MOD);
        this.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(WALK_SPEED_MOD);
        return super.getDismountLocationForPassenger(livingEntity);
    }

    public void handleSpeedRequest(int speedMod) {
        AttributeInstance movementSpeed = this.getAttribute(Attributes.MOVEMENT_SPEED);

        if (speedMod == -1 && movementSpeed.hasModifier(SPRINT_SPEED_MOD)) {
            movementSpeed.removeModifier(SPRINT_SPEED_MOD);
        } else if (speedMod == -1 && !movementSpeed.hasModifier(WALK_SPEED_MOD)) {
            movementSpeed.addTransientModifier(WALK_SPEED_MOD);
        } else if (speedMod == 1 && movementSpeed.hasModifier(WALK_SPEED_MOD)) {
            movementSpeed.removeModifier(WALK_SPEED_MOD);
        } else if (speedMod == 1 && !movementSpeed.hasModifier(SPRINT_SPEED_MOD)) {
            movementSpeed.addTransientModifier(SPRINT_SPEED_MOD);
        }
    }

    double x = this.getX() - this.xo;
    double z = this.getZ() - this.zo;
    public boolean isMoving = (x * x + z * z) > 0.0001;

    @Override
    public boolean handleEating(Player player, ItemStack stack) {
        int i = 0;
        int j = 0;
        float f = 0.0F;
        boolean flag = false;
        if (stack.is(Items.WHEAT)) {
            i = 90;
            j = 6;
            f = 10.0F;
            if (this.isTamed() && this.getAge() == 0 && this.canFallInLove()) {
                flag = true;
                this.setInLove(player);
            }
        }

        if (this.getHealth() < this.getMaxHealth() && f > 0.0F) {
            this.heal(f);
            flag = true;
        }

        if (this.isBaby() && i > 0) {
            this.level().addParticle(ParticleTypes.HAPPY_VILLAGER, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), 0.0D, 0.0D, 0.0D);
            if (!this.level().isClientSide) {
                this.ageUp(i);
            }

            flag = true;
        }

        if (j > 0 && (flag || !this.isTamed()) && this.getTemper() < this.getMaxTemper()) {
            flag = true;
            if (!this.level().isClientSide) {
                this.modifyTemper(j);
            }
        }

        if (flag) {
            this.gameEvent(GameEvent.ENTITY_INTERACT);
            if (!this.isSilent()) {
                SoundEvent soundevent = this.getEatingSound();
                if (soundevent != null) {
                    this.level().playSound(null, this.getX(), this.getY(), this.getZ(), this.getEatingSound(), this.getSoundSource(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
                }
            }
        }

        return flag;
    }

    int moreCropsTicks;

    static class PickCropsGoal extends MoveToBlockGoal {
        public final AbstractDinoMount dino;
        public boolean wantsToPick;
        public boolean canPick;

        public PickCropsGoal(AbstractDinoMount dino) {
            super(dino, 0.7F, 16);
            this.dino = dino;
        }

        public boolean canUse() {
            if (this.dino.isTamed()) {
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
            if (isTamed()) {
                return false;
            } else if (isInPowderSnow) {
                return false;
            } else if (AbstractDinoMount.this.getTarget() == null && AbstractDinoMount.this.getLastHurtByMob() == null) {
                if (AbstractDinoMount.this.getRandom().nextInt(reducedTickDelay(10)) != 0) {
                    return false;
                } else {
                    List<ItemEntity> list = AbstractDinoMount.this.level().getEntitiesOfClass(ItemEntity.class, AbstractDinoMount.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), AbstractDinoMount.DESIRABLE_CARNIVORE_LOOT);
                    return !list.isEmpty();
                }
            } else {
                return false;
            }
        }

        @Override
        public void tick() {
            List<ItemEntity> itemEntities = level().getEntitiesOfClass(ItemEntity.class, getBoundingBox().inflate(8.0D, 8.0D, 8.0D), AbstractDinoMount.DESIRABLE_CARNIVORE_LOOT);

            if (!itemEntities.isEmpty()) {
                ItemEntity itemEntity = itemEntities.get(0);
                getNavigation().moveTo(itemEntity, 1.0D);

                if (distanceToSqr(itemEntity) < 10.0D && itemEntity.getItem().is(DDDTags.Items.CARNIVORE_EATS)) {
                    pickUpItem(itemEntity);
                }
            }
        }

        @Override
        public void start() {
            List<ItemEntity> itemEntities = level().getEntitiesOfClass(ItemEntity.class, getBoundingBox().inflate(8.0D, 8.0D, 8.0D), AbstractDinoMount.DESIRABLE_CARNIVORE_LOOT);
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
            if (isTamed()) {
                return false;
            }
            List<ItemEntity> list = AbstractDinoMount.this.level().getEntitiesOfClass(ItemEntity.class, AbstractDinoMount.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), AbstractDino.DESIRABLE_HERBIVORE_LOOT);
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