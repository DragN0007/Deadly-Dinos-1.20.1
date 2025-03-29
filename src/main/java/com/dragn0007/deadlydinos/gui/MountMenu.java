package com.dragn0007.deadlydinos.gui;

import com.dragn0007.deadlydinos.entities.util.AbstractDinoMount;
import com.dragn0007.deadlydinos.util.DDDTags;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class MountMenu extends AbstractContainerMenu {

    public Container container;
    public AbstractDinoMount mount;

    public MountMenu(int containerId, Inventory inventory, FriendlyByteBuf extraData) {
        this(containerId, inventory, new SimpleContainer(extraData.readInt()), (AbstractDinoMount) inventory.player.level().getEntity(extraData.readInt()));
    }

    public MountMenu(int containerId, Inventory inventory, Container container, AbstractDinoMount abstractOMount) {
        super(DDDMenuTypes.MOUNT_MENU.get(), containerId);
        this.container = container;
        this.mount = abstractOMount;

        int oMountSlots = 0;
        this.addSlot(new Slot(this.container, oMountSlots++, 8, 18) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.is(Items.SADDLE) && !this.hasItem() && MountMenu.this.mount.isSaddleable();
            }

            @Override
            public boolean isActive() {
                return MountMenu.this.mount.isSaddleable();
            }
        });

        this.addSlot(new Slot(this.container, oMountSlots++, 8, 36) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                if (itemStack.getItem() instanceof HorseArmorItem) {
                    return !this.hasItem() && MountMenu.this.mount.canWearArmor();
                } else if (itemStack.is(ItemTags.WOOL_CARPETS)) {
                    return !this.hasItem() && MountMenu.this.mount.canWearArmor();
                } else if (itemStack.is(DDDTags.Items.BEDROLL_BEDS)) {
                    return !this.hasItem() && MountMenu.this.mount.canHoldBedroll();
                }
                return false;
            }

            @Override
            public boolean isActive() {
                return MountMenu.this.mount.canWearArmor() || MountMenu.this.mount.canHoldBedroll();
            }
        });

        if(this.mount.hasChest()) {
            for(int y = 0; y < 3; y++) {
                for(int x = 0; x < 8; x++) {
                    this.addSlot(new Slot(this.container, oMountSlots++, 80 + x * 18, 18 + y * 18));
                }
            }
        }

        int playerSlots = 0;
        for(int x = 0; x < 9; x++) {
            this.addSlot(new Slot(inventory, playerSlots++, 8 + x * 18, 142));
        }

        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 9; x++) {
                this.addSlot(new Slot(inventory, playerSlots++, 8 + x * 18, 84 + y * 18));
            }
        }
    }

    public boolean stillValid(Player player) {
        return !this.mount.hasInventoryChanged(this.container) && this.container.stillValid(player) && this.mount.isAlive() && this.mount.distanceTo(player) < 8.0F;
    }

    public ItemStack quickMoveStack(Player player, int slotId) {
        Slot slot = this.slots.get(slotId);
        if(!slot.hasItem()) {
            return ItemStack.EMPTY;
        }

        ItemStack itemStack = slot.getItem();
        ItemStack itemStackCopy = itemStack.copy();
        int containerSize = this.container.getContainerSize();

        if(slotId < containerSize) {
            if(!this.moveItemStackTo(itemStack, containerSize, containerSize + 36, true)) {
                return ItemStack.EMPTY;
            }
        } else if(slotId < containerSize + 36) {
            if(!this.moveItemStackTo(itemStack, 0, containerSize, false)) {
                return ItemStack.EMPTY;
            }
        }

        if(itemStack.getCount() == 0) {
            slot.set(ItemStack.EMPTY);
        }
        slot.setChanged();
        return itemStackCopy;
    }
}