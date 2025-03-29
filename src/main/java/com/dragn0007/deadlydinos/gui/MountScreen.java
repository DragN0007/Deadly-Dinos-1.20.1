package com.dragn0007.deadlydinos.gui;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entities.util.AbstractDinoMount;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class MountScreen extends AbstractContainerScreen<MountMenu> {

    public static final ResourceLocation MOUNT_INVENTORY_LOCATION = new ResourceLocation(DeadlyDinos.MODID, "textures/gui/dino_mount.png");
    public final AbstractDinoMount mount;

    public MountScreen(MountMenu oMountMenu, Inventory inventory, Component component) {
        super(oMountMenu, inventory, component);
        this.mount = oMountMenu.mount;
    }

    @Override
    protected void init() {
        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;
    }

    public void renderBg(GuiGraphics graphics, float f, int i, int j) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
        RenderSystem.setShaderTexture(0, MOUNT_INVENTORY_LOCATION);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        graphics.blit(MOUNT_INVENTORY_LOCATION, x, y, 0, 0, this.imageWidth, this.imageHeight);

        if (this.mount.hasChest()) {
            graphics.blit(MOUNT_INVENTORY_LOCATION,x + 25, y + 17, 0, this.imageHeight, 144, 54);
        }

        if (this.mount.isSaddleable()) {
            graphics.blit(MOUNT_INVENTORY_LOCATION,x + 7, y + 17, 18, this.imageHeight + 54, 18, 18);
        }

        if (this.mount.canWearArmor()) {
            graphics.blit(MOUNT_INVENTORY_LOCATION,x + 7, y + 35, 0, this.imageHeight + 54, 18, 18);
        }

        if (this.mount.canHoldBedroll()) {
            graphics.blit(MOUNT_INVENTORY_LOCATION, x + 7, y + 35, 54, this.imageHeight + 54, 18, 18);
        }

        if (this.mount.canWearCarpet()) {
            if (!this.mount.canWearArmor()) {
                graphics.blit(MOUNT_INVENTORY_LOCATION,x + 7, y + 35, 36, this.imageHeight + 54, 18, 18);
            }
            graphics.blit(MOUNT_INVENTORY_LOCATION,x + 7, y + 53, 36, this.imageHeight + 54, 18, 18);
        }

        if (this.mount.isFemale()) {
            graphics.blit(MOUNT_INVENTORY_LOCATION, x + 161, y + 9, 90, this.imageHeight + 54, 8, 8);
        }

        if (this.mount.isMale()) {
            graphics.blit(MOUNT_INVENTORY_LOCATION, x + 161, y + 9, 98, this.imageHeight + 54, 8, 8);
        }

    }

    @Override
    public void render(GuiGraphics graphics, int i, int i1, float v) {
        this.renderBackground(graphics);
        super.render(graphics, i, i1, v);
        this.renderTooltip(graphics, i, i1);
    }

}

