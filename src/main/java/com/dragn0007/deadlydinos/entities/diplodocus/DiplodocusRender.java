package com.dragn0007.deadlydinos.entities.diplodocus;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DiplodocusRender extends GeoEntityRenderer<Diplodocus> {

    public DiplodocusRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DiplodocusModel());
        this.addRenderLayer(new DiplodocusTackLayer(this));
    }

    @Override
    public void preRender(PoseStack poseStack, Diplodocus entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        if(entity.isBaby()) {
            poseStack.scale(0.3F, 0.3F, 0.3F);
        }

        if (!entity.isBaby()) {

            if (entity.hasChest()) {
                model.getBone("saddlebags").ifPresent(b -> b.setHidden(false));
            } else {
                model.getBone("saddlebags").ifPresent(b -> b.setHidden(true));
            }

            if (entity.isSaddled()) {
                model.getBone("saddle").ifPresent(b -> b.setHidden(false));
                model.getBone("reins").ifPresent(b -> b.setHidden(false));
            } else {
                model.getBone("saddle").ifPresent(b -> b.setHidden(true));
                model.getBone("reins").ifPresent(b -> b.setHidden(true));
            }

        }

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

}


