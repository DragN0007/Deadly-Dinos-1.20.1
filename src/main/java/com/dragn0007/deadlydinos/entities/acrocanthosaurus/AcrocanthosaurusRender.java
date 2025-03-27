package com.dragn0007.deadlydinos.entities.acrocanthosaurus;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AcrocanthosaurusRender extends GeoEntityRenderer<Acrocanthosaurus> {

    public AcrocanthosaurusRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AcrocanthosaurusModel());
    }

    @Override
    public void preRender(PoseStack poseStack, Acrocanthosaurus entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        if(entity.isBaby()) {
            poseStack.scale(0.3F, 0.3F, 0.3F);
        } else {
            poseStack.scale(1.0F, 1.0F, 1.0F);
        }

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

}


