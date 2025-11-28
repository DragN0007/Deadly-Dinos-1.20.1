package com.dragn0007.deadlydinos.entities.eocarcharia;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EocarchariaRender extends GeoEntityRenderer<Eocarcharia> {

    public EocarchariaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EocarchariaModel());
        this.addRenderLayer(new EocarchariaTackLayer(this));
    }

    @Override
    public void preRender(PoseStack poseStack, Eocarcharia entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        if(entity.isBaby()) {
            poseStack.scale(0.3F, 0.3F, 0.3F);
        } else {
            poseStack.scale(1.0F, 1.0F, 1.0F);
        }

        if (!entity.isBaby()) {

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


