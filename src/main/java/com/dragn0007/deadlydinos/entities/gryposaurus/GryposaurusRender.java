package com.dragn0007.deadlydinos.entities.gryposaurus;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GryposaurusRender extends GeoEntityRenderer<Gryposaurus> {

    public GryposaurusRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GryposaurusModel());
        this.addRenderLayer(new GryposaurusCarpetLayer(this));
        this.addRenderLayer(new GryposaurusTackLayer(this));
    }

    @Override
    public void preRender(PoseStack poseStack, Gryposaurus entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        if(entity.isBaby()) {
            poseStack.scale(0.3F, 0.3F, 0.3F);
            model.getBone("crest").ifPresent(b -> b.setHidden(true));
        } else {
            poseStack.scale(1.0F, 1.0F, 1.0F);
        }

        if (!entity.isBaby()) {

            if (entity.isFemale()) {
                model.getBone("crest").ifPresent(b -> b.setHidden(true));
            } else if (entity.isMale()) {
                model.getBone("crest").ifPresent(b -> b.setHidden(false));
            }

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


