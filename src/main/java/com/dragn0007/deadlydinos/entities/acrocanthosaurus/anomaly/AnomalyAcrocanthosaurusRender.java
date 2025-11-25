package com.dragn0007.deadlydinos.entities.acrocanthosaurus.anomaly;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AnomalyAcrocanthosaurusRender extends GeoEntityRenderer<AnomalyAcrocanthosaurus> {

    public AnomalyAcrocanthosaurusRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AnomalyAcrocanthosaurusModel());
    }

    @Override
    public void preRender(PoseStack poseStack, AnomalyAcrocanthosaurus entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

}


