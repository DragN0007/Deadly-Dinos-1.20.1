package com.dragn0007.deadlydinos.entities.utahraptor;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class UtahraptorModel extends GeoModel<Utahraptor> {

    public enum FemaleVariant {
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahraptor/utahraptor_female_red.png")),
        BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahraptor/utahraptor_female_blue.png")),
        GREEN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahraptor/utahraptor_female_green.png"));

        public final ResourceLocation resourceLocation;
        FemaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static FemaleVariant variantFromOrdinal(int variant) { return FemaleVariant.values()[variant % FemaleVariant.values().length];
        }
    }

    public enum MaleVariant {
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahraptor/utahraptor_male_red.png")),
        BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahraptor/utahraptor_male_blue.png")),
        GREEN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahraptor/utahraptor_male_green.png"));

        public final ResourceLocation resourceLocation;
        MaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static MaleVariant variantFromOrdinal(int variant) { return MaleVariant.values()[variant % MaleVariant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(DeadlyDinos.MODID, "geo/utahraptor.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(DeadlyDinos.MODID, "animations/utahraptor.animation.json");

    @Override
    public ResourceLocation getModelResource(Utahraptor object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Utahraptor object) {
        if (object.isFemale()) {
            return object.getFemaleTextureLocation();
        } else if (object.isMale()) {
            return object.getMaleTextureLocation();
        } else {
            return object.getFemaleTextureLocation();
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Utahraptor animatable) {
        return ANIMATION;
    }
}

