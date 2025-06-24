package com.dragn0007.deadlydinos.entities.megaraptor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MegaraptorRender extends GeoEntityRenderer<Megaraptor> {

    public MegaraptorRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MegaraptorModel());
    }

    @Override
    public void preRender(PoseStack poseStack, Megaraptor entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        if(entity.isBaby()) {
            poseStack.scale(0.3F, 0.3F, 0.3F);
        } else {
            poseStack.scale(1.0F, 1.0F, 1.0F);
        }

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

}


