package com.dragn0007.deadlydinos.entities.yutyrannus;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YutyrannusModel extends GeoModel<Yutyrannus> {

    public enum FemaleVariant {
        BLACK(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/yutyrannus/yutyrannus_female_black.png")),
        WHITE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/yutyrannus/yutyrannus_female_white.png")),
        PURPLE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/yutyrannus/yutyrannus_female_purple.png"));

        public final ResourceLocation resourceLocation;
        FemaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static FemaleVariant variantFromOrdinal(int variant) { return FemaleVariant.values()[variant % FemaleVariant.values().length];
        }
    }

    public enum MaleVariant {
        BLACK(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/yutyrannus/yutyrannus_male_black.png")),
        WHITE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/yutyrannus/yutyrannus_male_white.png")),
        PURPLE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/yutyrannus/yutyrannus_male_purple.png"));

        public final ResourceLocation resourceLocation;
        MaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static MaleVariant variantFromOrdinal(int variant) { return MaleVariant.values()[variant % MaleVariant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(DeadlyDinos.MODID, "geo/yutyrannus.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(DeadlyDinos.MODID, "animations/yutyrannus.animation.json");

    @Override
    public ResourceLocation getModelResource(Yutyrannus object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Yutyrannus object) {
        if (object.isFemale()) {
            return object.getFemaleTextureLocation();
        } else if (object.isMale()) {
            return object.getMaleTextureLocation();
        } else {
            return object.getFemaleTextureLocation();
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Yutyrannus animatable) {
        return ANIMATION;
    }
}

