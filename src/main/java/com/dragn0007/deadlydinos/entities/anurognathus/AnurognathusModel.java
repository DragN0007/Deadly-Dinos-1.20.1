package com.dragn0007.deadlydinos.entities.anurognathus;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class AnurognathusModel extends DefaultedEntityGeoModel<Anurognathus> {

    public AnurognathusModel() {
        super(new ResourceLocation(DeadlyDinos.MODID, "anurognathus"), true);
    }

    @Override
    public void setCustomAnimations(Anurognathus animatable, long instanceId, AnimationState<Anurognathus> animationState) {

        CoreGeoBone neck = getAnimationProcessor().getBone("neck");
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

        if (!animatable.isRidingShoulder()) {
            if (neck != null) {
                neck.setRotX(neck.getRotX() + (entityData.headPitch() * Mth.DEG_TO_RAD));
                float maxYaw = Mth.clamp(entityData.netHeadYaw(), -25.0f, 25.0f);
                neck.setRotY(neck.getRotY() + (maxYaw * Mth.DEG_TO_RAD));
            }

            if (head != null) {
                head.setRotX(head.getRotX() + (entityData.headPitch() * Mth.DEG_TO_RAD));
                float maxYaw = Mth.clamp(entityData.netHeadYaw(), -25.0f, 25.0f);
                head.setRotY(head.getRotY() + (maxYaw * Mth.DEG_TO_RAD));
            }
        }
    }

    public enum FemaleVariant {
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/anurognathus/female_red.png")),
        BROWN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/anurognathus/female_brown.png")),
        SILVER(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/anurognathus/female_silver.png")),
        TAN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/anurognathus/female_tan.png"));

        public final ResourceLocation resourceLocation;
        FemaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static FemaleVariant variantFromOrdinal(int variant) { return FemaleVariant.values()[variant % FemaleVariant.values().length];
        }
    }

    public enum MaleVariant {
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/anurognathus/male_red.png")),
        BROWN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/anurognathus/male_brown.png")),
        SILVER(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/anurognathus/male_silver.png")),
        TAN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/anurognathus/male_tan.png"));

        public final ResourceLocation resourceLocation;
        MaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static MaleVariant variantFromOrdinal(int variant) { return MaleVariant.values()[variant % MaleVariant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(DeadlyDinos.MODID, "geo/anurognathus.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(DeadlyDinos.MODID, "animations/anurognathus.animation.json");

    @Override
    public ResourceLocation getModelResource(Anurognathus object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Anurognathus object) {
        if (object.isFemale()) {
            return object.getFemaleTextureLocation();
        } else if (object.isMale()) {
            return object.getMaleTextureLocation();
        } else {
            return object.getFemaleTextureLocation();
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Anurognathus animatable) {
        return ANIMATION;
    }
}

