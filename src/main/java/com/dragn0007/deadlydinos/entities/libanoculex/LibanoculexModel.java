package com.dragn0007.deadlydinos.entities.libanoculex;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class LibanoculexModel extends DefaultedEntityGeoModel<Libanoculex> {

    public LibanoculexModel() {
        super(new ResourceLocation(DeadlyDinos.MODID, "libanoculex"), true);
    }

    public enum FemaleVariant {
        BLACK(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/libanoculex/black.png")),
        MAHOGANY(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/libanoculex/mahogany.png")),
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/libanoculex/red.png")),
        SEAL(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/libanoculex/seal.png"));

        public final ResourceLocation resourceLocation;
        FemaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static FemaleVariant variantFromOrdinal(int variant) { return FemaleVariant.values()[variant % FemaleVariant.values().length];
        }
    }

    public enum MaleVariant {
        BLACK(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/libanoculex/black.png")),
        MAHOGANY(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/libanoculex/mahogany.png")),
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/libanoculex/red.png")),
        SEAL(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/libanoculex/seal.png"));

        public final ResourceLocation resourceLocation;
        MaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static MaleVariant variantFromOrdinal(int variant) { return MaleVariant.values()[variant % MaleVariant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(DeadlyDinos.MODID, "geo/libanoculex.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(DeadlyDinos.MODID, "animations/libanoculex.animation.json");

    @Override
    public ResourceLocation getModelResource(Libanoculex object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Libanoculex object) {
        if (object.isFemale()) {
            return object.getFemaleTextureLocation();
        } else if (object.isMale()) {
            return object.getMaleTextureLocation();
        } else {
            return object.getFemaleTextureLocation();
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Libanoculex animatable) {
        return ANIMATION;
    }
}

