package com.dragn0007.deadlydinos.entities.giant_crop_snail;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CropSnailModel extends DefaultedEntityGeoModel<CropSnail> {

    public CropSnailModel() {
        super(new ResourceLocation(DeadlyDinos.MODID, "giant_crop_snail"), true);
    }

    public enum FemaleVariant {
        BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/giant_crop_snail/blue.png")),
        MAHOGANY(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/giant_crop_snail/mahogany.png")),
        GOLD(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/giant_crop_snail/gold.png")),
        LILAC(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/giant_crop_snail/lilac.png")),
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/giant_crop_snail/red.png"));

        public final ResourceLocation resourceLocation;
        FemaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static FemaleVariant variantFromOrdinal(int variant) { return FemaleVariant.values()[variant % FemaleVariant.values().length];
        }
    }

    public enum MaleVariant {
        BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/giant_crop_snail/blue.png")),
        MAHOGANY(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/giant_crop_snail/mahogany.png")),
        GOLD(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/giant_crop_snail/gold.png")),
        LILAC(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/giant_crop_snail/lilac.png")),
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/giant_crop_snail/red.png"));

        public final ResourceLocation resourceLocation;
        MaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static MaleVariant variantFromOrdinal(int variant) { return MaleVariant.values()[variant % MaleVariant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(DeadlyDinos.MODID, "geo/giant_crop_snail.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(DeadlyDinos.MODID, "animations/giant_crop_snail.animation.json");

    @Override
    public ResourceLocation getModelResource(CropSnail object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(CropSnail object) {
        if (object.isFemale()) {
            return object.getFemaleTextureLocation();
        } else if (object.isMale()) {
            return object.getMaleTextureLocation();
        } else {
            return object.getFemaleTextureLocation();
        }
    }

    @Override
    public ResourceLocation getAnimationResource(CropSnail animatable) {
        return ANIMATION;
    }
}

