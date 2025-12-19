package com.dragn0007.deadlydinos.entities.giant_crop_snail;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CropSnailRender extends GeoEntityRenderer<CropSnail> {

    public CropSnailRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CropSnailModel());
    }

    @Override
    public void preRender(PoseStack poseStack, CropSnail entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        if(entity.isBaby()) {
            poseStack.scale(0.3F, 0.3F, 0.3F);
        } else {
            if (entity.isFemale()) {
                poseStack.scale(1.1F, 1.1F, 1.1F);
            } else {
                poseStack.scale(1.0F, 1.0F, 1.0F);
            }
        }

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

}


