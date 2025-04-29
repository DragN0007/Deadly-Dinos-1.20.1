package com.dragn0007.deadlydinos.entities.parasaurolophus;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ParasaurolophusModel extends GeoModel<Parasaurolophus> {

    public enum FemaleVariant {
        BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/parasaurolophus/parasaurolophus_female_blue.png")),
        CREAM(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/parasaurolophus/parasaurolophus_female_cream.png")),
        LIGHT_BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/parasaurolophus/parasaurolophus_female_light_blue.png")),
        PERIDOT(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/parasaurolophus/parasaurolophus_female_peridot.png")),
        PURPLE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/parasaurolophus/parasaurolophus_female_purple.png")),
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/parasaurolophus/parasaurolophus_female_red.png"));

        public final ResourceLocation resourceLocation;
        FemaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static FemaleVariant variantFromOrdinal(int variant) { return FemaleVariant.values()[variant % FemaleVariant.values().length];
        }
    }

    public enum MaleVariant {
        BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/parasaurolophus/parasaurolophus_male_blue.png")),
        CREAM(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/parasaurolophus/parasaurolophus_male_cream.png")),
        LIGHT_BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/parasaurolophus/parasaurolophus_male_light_blue.png")),
        PERIDOT(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/parasaurolophus/parasaurolophus_male_peridot.png")),
        PURPLE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/parasaurolophus/parasaurolophus_male_purple.png")),
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/parasaurolophus/parasaurolophus_male_red.png"));

        public final ResourceLocation resourceLocation;
        MaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static MaleVariant variantFromOrdinal(int variant) { return MaleVariant.values()[variant % MaleVariant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(DeadlyDinos.MODID, "geo/parasaurolophus.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(DeadlyDinos.MODID, "animations/parasaurolophus.animation.json");

    @Override
    public ResourceLocation getModelResource(Parasaurolophus object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Parasaurolophus object) {
        if (object.isFemale()) {
            return object.getFemaleTextureLocation();
        } else if (object.isMale()) {
            return object.getMaleTextureLocation();
        } else {
            return object.getFemaleTextureLocation();
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Parasaurolophus animatable) {
        return ANIMATION;
    }
}

