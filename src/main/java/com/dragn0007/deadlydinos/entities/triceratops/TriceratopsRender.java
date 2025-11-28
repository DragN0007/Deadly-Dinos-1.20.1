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
            model.getBone("horn_middle").ifPresent(b -> b.setHidden(true));
            model.getBone("horn_end").ifPresent(b -> b.setHidden(true));
        } else {
            model.getBone("horn_middle").ifPresent(b -> b.setHidden(false));
            model.getBone("horn_end").ifPresent(b -> b.setHidden(false));
        }

        if (!entity.isBaby()) {

            if (entity.isFemale()) {
                model.getBone("horns").ifPresent(b -> b.setScaleY(1F));
                model.getBone("horns").ifPresent(b -> b.setScaleX(1F));
                model.getBone("horns").ifPresent(b -> b.setScaleZ(1F));
                model.getBone("horn_end").ifPresent(b -> b.setHidden(true));
            } else if (entity.isMale()) {
                model.getBone("horns").ifPresent(b -> b.setScaleY(1.05F));
                model.getBone("horns").ifPresent(b -> b.setScaleX(1.05F));
                model.getBone("horns").ifPresent(b -> b.setScaleZ(1.05F));
                model.getBone("horn_end").ifPresent(b -> b.setHidden(false));
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


