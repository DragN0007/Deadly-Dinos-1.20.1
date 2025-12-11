package com.dragn0007.deadlydinos.entities;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.common.gui.MountMenu;
import com.dragn0007.deadlydinos.entities.triceratops.Triceratops;
import com.dragn0007.deadlydinos.items.custom.DinosaurArmorItem;
import com.dragn0007.deadlydinos.util.DDDTags;
import com.dragn0007.deadlydinos.util.DeadlyDinosCommonConfig;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SaddleItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Stream;

public abstract class AbstractDinoMount extends AbstractChestedAnimal {

    public net.minecraftforge.common.util.LazyOptional<?> itemHandler = null;

    public static final float MAX_HEALTH = generateMaxHealth((p_272504_) -> {
        return p_272504_ - 1;
    });

    public float getRiddenSpeed(Player player) {
        return (float)this.getAttributeValue(Attributes.MOVEMENT_SPEED);
    }

    public static Ingredient FOOD_ITEMS = Ingredient.of(Items.WHEAT);
    public boolean isFood(ItemStack stack) {
        return FOOD_ITEMS.test(stack);
    }

    public static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("3c50e848-b2e3-404a-9879-7550b12dd09b");
    public static final UUID SPRINT_SPEED_MOD_UUID = UUID.fromString("c9379664-01b5-4e19-a7e9-11264453bdce");
    public static final UUID WALK_SPEED_MOD_UUID = UUID.fromString("59b55c98-e39b-45e2-846c-f91f3e9ea861");

    public static final AttributeModifier SPRINT_SPEED_MOD = new AttributeModifier(SPRINT_SPEED_MOD_UUID, "Sprint speed mod", 0.0D, AttributeModifier.Operation.MULTIPLY_TOTAL);
    public static final AttributeModifier WALK_SPEED_MOD = new AttributeModifier(WALK_SPEED_MOD_UUID, "Walk speed mod", -0.7D, AttributeModifier.Operation.MULTIPLY_TOTAL); // KEEP THIS NEGATIVE. It is calculated by adding 1. So -0.1 actually means 0.9

    public static final EntityDataAccessor<Integer> DATA_CARPET_ID = SynchedEntityData.defineId(AbstractDinoMount.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Optional<UUID>> DATA_OWNERUUID_ID = SynchedEntityData.defineId(AbstractDinoMount.class, EntityDataSerializers.OPTIONAL_UUID);

    public AbstractDinoMount(EntityType<? extends AbstractDinoMount> entityType, Level level) {
        super(entityType, level);
    }

    public boolean isOnSand() {
        BlockState blockState = this.level().getBlockState(this.blockPosition().below());
        return blockState.is(DDDTags.Blocks.SAND);
    }

    public boolean isOnSnow() {
        BlockState blockState = this.level().getBlockState(this.blockPosition().below());
        return blockState.is(Blocks.SNOW) || blockState.is(Blocks.SNOW_BLOCK) || blockState.is(Blocks.POWDER_SNOW);
    }

    public AbstractDinoMount leader;
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

    public void addFollowers(Stream<? extends AbstractDinoMount> p_27534_) {
        p_27534_.limit((long)(this.getMaxHerdSize() - this.packSize)).filter((mob) -> {
            return mob != this;
        }).forEach((mob) -> {
            mob.startFollowing(this);
        });
    }

    public boolean isFollower() {
        return this.leader != null && this.leader.isAlive();
    }

    public AbstractDinoMount startFollowing(AbstractDinoMount mob) {
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

    public static final EntityDataAccessor<Integer> MODE = SynchedEntityData.defineId(AbstractDinoMount.class, EntityDataSerializers.INT);

    public int mode() {
        return this.entityData.get(MODE);
    }

    public void cycleMode() {
        this.entityData.set(MODE, (this.entityData.get(MODE) +1) % 2);
    }

    public enum Mode {
        NO(new ResourceLocation(DeadlyDinos.MODID, "textures/gui/nomode.png")),
        HARVEST(new ResourceLocation(DeadlyDinos.MODID, "textures/gui/harvestmode.png"));

        public final ResourceLocation texture;

        Mode(ResourceLocation texture) {
            this.texture = texture;
        }

        public Triceratops.Mode next() {
            return Triceratops.Mode.values()[(this.ordinal() + 1) % Triceratops.Mode.values().length];
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.hasFollowers() && this.level().random.nextInt(200) == 1) {
            List<? extends AbstractDinoMount> list = this.level().getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
            if (list.size() <= 1) {
                this.packSize = 1;
            }
        }
    }

    protected void tickRidden(Player player, Vec3 vec3) {
        Vec2 vec2 = this.getRiddenRotation(player);

        float degrees = Mth.wrapDegrees(vec2.y - this.getYRot());
        float playerXRot = vec2.x;
        this.setXRot(vec2.x);
        this.xRotO = this.getXRot();
        float yRot = this.getYRot();
        float maxHeadYRot = 25.0f;
        this.yHeadRot = yRot + Mth.clamp(degrees, -maxHeadYRot, maxHeadYRot);
        this.setXRot(playerXRot);
        this.xRotO = this.getXRot();


        if (Math.abs(degrees) > maxHeadYRot) {
            float turnSpeed = 8.0f;
            float yaw = yRot + Mth.clamp(degrees, -turnSpeed, turnSpeed);
            this.setYRot(yaw);
            this.yRotO = yaw;
            this.yBodyRot = yaw;
        } else {
            this.yBodyRot = yRot;
        }
    }

    public boolean doneStalking = false;
    public boolean isDoneStalking() {
        return this.doneStalking;
    }
    public void setDoneStalking(boolean doneStalking) {
        this.doneStalking = doneStalking;
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

    public void createInventory() {
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
        return itemStack.getItem() instanceof DinosaurArmorItem;
    }

    public boolean isBedroll(ItemStack itemStack) {
        return itemStack.is(DDDTags.Items.BEDROLL_BEDS);
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

    @Nullable
    public LivingEntity getControllingPassenger() {
        if (this.isTamed() && this.isSaddled()) {
            return (LivingEntity) this.getFirstPassenger();
        }
        return null;
    }

    public void tame(Player player) {
        this.setTamed(true);
        this.setOwnerUUID(player.getUUID());
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.TAME_ANIMAL.trigger((ServerPlayer)player, this);
        }

    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.is(Items.SHEARS) && player.isShiftKeyDown() && isOwnedBy(player)) {
            if (this.hasChest()) {
                this.dropEquipment();
                this.inventory.removeAllItems();

                this.setChest(false);
                this.playChestEquipsSound();

                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }
        }

        if (this.isFood(itemStack)) {
            int i = this.getAge();
            if (!this.level().isClientSide && i == 0 && this.canFallInLove()) {
                this.usePlayerItem(player, hand, itemStack);
                this.setInLove(player);
                return InteractionResult.SUCCESS;
            }
        }

        if (DeadlyDinosCommonConfig.ALLOW_TAMING.get() && this.isBaby() && !this.isTamed() && this.isFood(itemStack) && this.random.nextInt(5) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
            this.tame(player);
            return InteractionResult.SUCCESS;
        }

        if (this.isTamed() && this.isBaby() && this.isFood(itemStack)) {
            int i = this.getAge();
            this.usePlayerItem(player, hand, itemStack);
            this.ageUp(getSpeedUpSecondsWhenFeeding(-i), true);
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }

        if(!this.isBaby()) {
            if(this.isTamed() && player.isSecondaryUseActive() && isOwnedBy(player)) {
                this.openInventory(player);
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }

            if(this.isVehicle()) {
                return super.mobInteract(player, hand);
            }

            if(!this.hasChest() && itemStack.is(Blocks.CHEST.asItem()) && isOwnedBy(player)) {
                this.setChest(true);
                this.playChestEquipsSound();

                if(!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }

                this.createInventory();
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }
        }

        if (this.level().isClientSide) {
            boolean flag = this.isOwnedBy(player) || this.isTamed() || this.isFood(itemStack) && !this.isTamed();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else if (this.isTamed()) {
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

        if(this.isBaby() || !this.isOwnedBy(player) || !this.isTamed()) {
            return super.mobInteract(player, hand);
        } else {
            this.doPlayerRide(player);
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }
    }

    @Override
    protected void doPlayerRide(Player player) {
        this.setEating(false);
        this.setStanding(false);
        if (!this.level().isClientSide && this.isTamed() && this.isOwnedBy(player)) {
            player.setYRot(this.getYRot());
            player.setXRot(this.getXRot());
            player.startRiding(this);
        }

    }

    @Override
    public boolean canWearArmor() {
        return false;
    }

    public boolean canHoldBedroll() {
        return false;
    }

    public boolean canWearCarpet() {
        return false;
    }

    @Override
    public boolean canPerformRearing() {
        return false;
    }

    public static final EntityDataAccessor<Boolean> DATA_ID_CHEST = SynchedEntityData.defineId(AbstractDinoMount.class, EntityDataSerializers.BOOLEAN);
    public ItemStack getDecorItem() {
        return this.entityData.get(DECOR_ITEM);
    }
    public void setDecorItem(ItemStack decorItem) {
        this.entityData.set(DECOR_ITEM, decorItem);
    }
    public static final EntityDataAccessor<ItemStack> DECOR_ITEM = SynchedEntityData.defineId(AbstractDinoMount.class, EntityDataSerializers.ITEM_STACK);

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(MODE, 0);
        this.entityData.define(DECOR_ITEM, ItemStack.EMPTY);
        this.entityData.define(DATA_ID_CHEST, false);
        this.entityData.define(DATA_OWNERUUID_ID, Optional.empty());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("Mode", this.entityData.get(MODE));

        if (!this.inventory.getItem(1).isEmpty()) {
            compoundTag.put("ArmorItem", this.inventory.getItem(1).save(new CompoundTag()));
        }

        if (!this.inventory.getItem(1).isEmpty()) {
            compoundTag.put("DecorItem", this.inventory.getItem(1).save(new CompoundTag()));
        }

        if (!this.inventory.getItem(0).isEmpty()) {
            compoundTag.put("SaddleItem", this.inventory.getItem(0).save(new CompoundTag()));
        }

        compoundTag.putBoolean("Chested", this.hasChest());
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
        this.entityData.set(MODE, compoundTag.getInt("Mode"));

        if(compoundTag.contains("ArmorItem", 10)) {
            ItemStack itemStack = ItemStack.of(compoundTag.getCompound("ArmorItem"));
            if(!itemStack.isEmpty() && this.isArmor(itemStack)) {
                this.inventory.setItem(1, itemStack);
            }
        }

        if(compoundTag.contains("DecorItem")) {
            ItemStack decorItem = ItemStack.of(compoundTag.getCompound("DecorItem"));
            this.setDecorItem(decorItem);
            this.inventory.setItem(this.decorSlot(), decorItem);
        }

        if (compoundTag.contains("SaddleItem", 10)) {
            ItemStack itemStack = ItemStack.of(compoundTag.getCompound("SaddleItem"));
            if(!itemStack.isEmpty() && this.isSaddle(itemStack)) {
                this.inventory.setItem(0, itemStack);
            }
        }

        if(compoundTag.contains("BedrollItem", 10)) {
            ItemStack itemStack = ItemStack.of(compoundTag.getCompound("BedrollItem"));
            if(!itemStack.isEmpty() && this.isBedroll(itemStack)) {
                this.inventory.setItem(1, itemStack);
            }
        }

        this.setChest(compoundTag.getBoolean("Chested"));

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

    public boolean isOwnedBy(LivingEntity entity) {
        return entity == this.getOwner();
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

            if (itemStack.getItem() instanceof DinosaurArmorItem armorItem) {
                int protection = armorItem.getProtection();
                if (protection > 0) {
                    this.getAttribute(Attributes.ARMOR).addTransientModifier(
                            new AttributeModifier(ARMOR_MODIFIER_UUID, "Dino armor bonus", (double) protection, AttributeModifier.Operation.ADDITION)
                    );
                }
            }
        }
    }

    public ItemStack getBedroll() {
        return this.getItemBySlot(EquipmentSlot.CHEST);
    }

    public void setBedroll(ItemStack itemStack) {
        this.setItemSlot(EquipmentSlot.CHEST, itemStack);
        this.setDropChance(EquipmentSlot.CHEST, 0f);
    }

    @Override
    public void updateContainerEquipment() {
       super.updateContainerEquipment();
       this.setArmorEquipment(this.inventory.getItem(1));
       this.setDropChance(EquipmentSlot.CHEST, 0f);
       this.setDecorItem(this.inventory.getItem(this.decorSlot()));
        if (!this.level().isClientSide) {
            super.updateContainerEquipment();
        }
    }

    public int saddleSlot() {
        return 0;
    }

    public int armorSlot() {
        return 1;
    }

    public int decorSlot() {
        return 1;
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
        }
    }

    public boolean wantsToAttack(LivingEntity entity, LivingEntity living) {
        if (!(entity instanceof Creeper) && !(entity instanceof Ghast)) {
            if (entity instanceof AbstractDinoMount) {
                AbstractDinoMount dinoMount = (AbstractDinoMount)entity;
                return !dinoMount.isTamed() || dinoMount.getOwner() != living;
            } else if (entity instanceof Player && living instanceof Player && !((Player)living).canHarmPlayer((Player)entity)) {
                return false;
            } else if (entity instanceof AbstractHorse && ((AbstractHorse)entity).isTamed()) {
                return false;
            } else {
                return !(entity instanceof TamableAnimal) || !((TamableAnimal)entity).isTame();
            }
        } else {
            return false;
        }
    }


    public static class RaidGardenGoal extends MoveToBlockGoal {
        private final AbstractDinoMount entity;

        public RaidGardenGoal(AbstractDinoMount entity) {
            super(entity, 1F, 64);
            this.entity = entity;
        }

        public boolean canUse() {
            if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.entity.level(), this.entity)) {
                return false;
            }
            if (entity.isTamed()) {
                return false;
            }

            return super.canUse();
        }

        public boolean canContinueToUse() {
            return super.canContinueToUse();
        }

        public void tick() {
            super.tick();
            this.entity.getLookControl().setLookAt((double)this.blockPos.getX() + 0.5D, (double)(this.blockPos.getY() + 1), (double)this.blockPos.getZ() + 0.5D, 10.0F, (float)this.entity.getMaxHeadXRot());
            BlockPos cropPos = this.blockPos.above();
            double distanceSq = this.entity.position().distanceToSqr(cropPos.getX() + 0.5D, cropPos.getY() + 0.5D, cropPos.getZ() + 0.5D);
            if (distanceSq <= 4.0D) {
                Level level = this.entity.level();
                BlockState blockstate = level.getBlockState(cropPos);
                Block block = blockstate.getBlock();

                if (block instanceof CropBlock) {
                    level.removeBlock(cropPos, false);
                }
            }
        }

        public boolean isValidTarget(LevelReader levelReader, BlockPos blockPos) {
            BlockState blockstate = levelReader.getBlockState(blockPos);
            if (blockstate.is(Blocks.FARMLAND)) {
                blockstate = levelReader.getBlockState(blockPos.above());
                if (blockstate.getBlock() instanceof CropBlock) {
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

                if (distanceToSqr(itemEntity) < 10.0D && itemEntity.getItem().is(DDDTags.Items.CARNIVORE_DESIRES)) {
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

        public void pickUpItem(ItemEntity itemEntity) {
            if (itemEntity.getItem().is(DDDTags.Items.CARNIVORE_DESIRES) && this.canUse() && !isTamed()) {
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

        public void pickUpItem(ItemEntity itemEntity) {
            if (itemEntity.getItem().is(DDDTags.Items.HERBIVORE_EATS) && this.canUse() && !isTamed()) {
                ItemStack itemStack = itemEntity.getItem();
                itemStack.shrink(1);

                if (itemStack.isEmpty()) {
                    itemEntity.discard();
                }
            }
        }
    }


}