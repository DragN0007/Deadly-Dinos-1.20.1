package com.dragn0007.deadlydinos.entities.euphoberia;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class EuphoberiaModel extends DefaultedEntityGeoModel<Euphoberia> {

    public EuphoberiaModel() {
        super(new ResourceLocation(DeadlyDinos.MODID, "euphoberia"), true);
    }

    public enum FemaleVariant {
        BLACK(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/euphoberia/black.png")),
        MAHOGANY(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/euphoberia/mahogany.png")),
        BROWN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/euphoberia/brown.png")),
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/euphoberia/red.png"));

        public final ResourceLocation resourceLocation;
        FemaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static FemaleVariant variantFromOrdinal(int variant) { return FemaleVariant.values()[variant % FemaleVariant.values().length];
        }
    }

    public enum MaleVariant {
        BLACK(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/euphoberia/black.png")),
        MAHOGANY(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/euphoberia/mahogany.png")),
        BROWN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/euphoberia/brown.png")),
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/euphoberia/red.png"));

        public final ResourceLocation resourceLocation;
        MaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static MaleVariant variantFromOrdinal(int variant) { return MaleVariant.values()[variant % MaleVariant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(DeadlyDinos.MODID, "geo/euphoberia.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(DeadlyDinos.MODID, "animations/euphoberia.animation.json");

    @Override
    public ResourceLocation getModelResource(Euphoberia object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Euphoberia object) {
        if (object.isFemale()) {
            return object.getFemaleTextureLocation();
        } else if (object.isMale()) {
            return object.getMaleTextureLocation();
        } else {
            return object.getFemaleTextureLocation();
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Euphoberia animatable) {
        return ANIMATION;
    }
}

