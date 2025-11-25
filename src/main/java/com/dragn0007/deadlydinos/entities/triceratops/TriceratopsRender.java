package com.dragn0007.deadlydinos.entities.triceratops;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TriceratopsRender extends GeoEntityRenderer<Triceratops> {

    public TriceratopsRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TriceratopsModel());
        this.addRenderLayer(new TriceratopsTackLayer(this));
    }

    @Override
    public void preRender(PoseStack poseStack, Triceratops entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        if(entity.isBaby()) {
            poseStack.scale(0.3F, 0.3F, 0.3F);
            model.getBone("crest").ifPresent(b -> b.setScaleY(0.5F));
            model.getBone("crest").ifPresent(b -> b.setScaleX(0.8F));
            model.getBone("crest").ifPresent(b -> b.setScaleZ(0.8F));
        } else {
            poseStack.scale(1.0F, 1.0F, 1.0F);
        }

        if (!entity.isBaby()) {

            if (entity.isFemale()) {
                model.getBone("crest").ifPresent(b -> b.setScaleY(0.6F));
                model.getBone("crest").ifPresent(b -> b.setScaleX(0.8F));
                model.getBone("crest").ifPresent(b -> b.setScaleZ(0.8F));
            } else if (entity.isFemale()) {
                model.getBone("crest").ifPresent(b -> b.setScaleY(1F));
                model.getBone("crest").ifPresent(b -> b.setScaleX(1F));
                model.getBone("crest").ifPresent(b -> b.setScaleZ(1F));
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


