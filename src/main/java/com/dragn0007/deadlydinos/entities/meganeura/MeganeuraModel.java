package com.dragn0007.deadlydinos.entities.meganeura;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class MeganeuraModel extends DefaultedEntityGeoModel<Meganeura> {

    public MeganeuraModel() {
        super(new ResourceLocation(DeadlyDinos.MODID, "meganeura"), true);
    }

    public enum FemaleVariant {
        BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/meganeura/blue.png")),
        GREEN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/meganeura/green.png")),
        ORANGE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/meganeura/orange.png")),
        YELLOW(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/meganeura/yellow.png"));

        public final ResourceLocation resourceLocation;
        FemaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static FemaleVariant variantFromOrdinal(int variant) { return FemaleVariant.values()[variant % FemaleVariant.values().length];
        }
    }

    public enum MaleVariant {
        BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/meganeura/blue.png")),
        GREEN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/meganeura/green.png")),
        ORANGE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/meganeura/orange.png")),
        YELLOW(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/meganeura/yellow.png"));

        public final ResourceLocation resourceLocation;
        MaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static MaleVariant variantFromOrdinal(int variant) { return MaleVariant.values()[variant % MaleVariant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(DeadlyDinos.MODID, "geo/meganeura.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(DeadlyDinos.MODID, "animations/meganeura.animation.json");

    @Override
    public ResourceLocation getModelResource(Meganeura object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Meganeura object) {
        if (object.isFemale()) {
            return object.getFemaleTextureLocation();
        } else if (object.isMale()) {
            return object.getMaleTextureLocation();
        } else {
            return object.getFemaleTextureLocation();
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Meganeura animatable) {
        return ANIMATION;
    }
}

