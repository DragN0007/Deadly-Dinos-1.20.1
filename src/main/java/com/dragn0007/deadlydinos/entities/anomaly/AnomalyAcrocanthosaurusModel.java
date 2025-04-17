package com.dragn0007.deadlydinos.entities.anomaly;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnomalyAcrocanthosaurusModel extends GeoModel<AnomalyAcrocanthosaurus> {

    public enum FemaleVariant {
        BLACK(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/acrocanthosaurus/acrocanthosaurus_female_anomaly.png"));

        public final ResourceLocation resourceLocation;
        FemaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static FemaleVariant variantFromOrdinal(int variant) { return FemaleVariant.values()[variant % FemaleVariant.values().length];
        }
    }

    public enum MaleVariant {
        BLACK(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/acrocanthosaurus/acrocanthosaurus_male_anomaly.png"));

        public final ResourceLocation resourceLocation;
        MaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static MaleVariant variantFromOrdinal(int variant) { return MaleVariant.values()[variant % MaleVariant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(DeadlyDinos.MODID, "geo/anomaly_acrocanthosaurus.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(DeadlyDinos.MODID, "animations/acrocanthosaurus.animation.json");

    @Override
    public ResourceLocation getModelResource(AnomalyAcrocanthosaurus object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(AnomalyAcrocanthosaurus object) {
        if (object.isFemale()) {
            return object.getFemaleTextureLocation();
        } else if (object.isMale()) {
            return object.getMaleTextureLocation();
        } else {
            return object.getFemaleTextureLocation();
        }
    }

    @Override
    public ResourceLocation getAnimationResource(AnomalyAcrocanthosaurus animatable) {
        return ANIMATION;
    }
}

