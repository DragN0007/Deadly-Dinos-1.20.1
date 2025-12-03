package com.dragn0007.deadlydinos.entities.olorotitan;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class OlorotitanModel extends DefaultedEntityGeoModel<Olorotitan> {

    public OlorotitanModel() {
        super(new ResourceLocation(DeadlyDinos.MODID, "olorotitan"), true);
    }

    @Override
    public void setCustomAnimations(Olorotitan animatable, long instanceId, AnimationState<Olorotitan> animationState) {

        double x = animatable.getX() - animatable.xo;
        double z = animatable.getZ() - animatable.zo;
        boolean isMoving = (x * x + z * z) > 0.0001;

        CoreGeoBone neck = getAnimationProcessor().getBone("neck");
        CoreGeoBone tail = getAnimationProcessor().getBone("tail");
        CoreGeoBone tail2 = getAnimationProcessor().getBone("tail2");
        CoreGeoBone tail3 = getAnimationProcessor().getBone("tail3");

        EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

        if (neck != null) {
            neck.setRotX(neck.getRotX() + (entityData.headPitch() * Mth.DEG_TO_RAD));
            float maxYaw = Mth.clamp(entityData.netHeadYaw(), -25.0f, 25.0f);
            neck.setRotY(neck.getRotY() + (maxYaw * Mth.DEG_TO_RAD));
        }

        if (tail != null) {
            if (isMoving) {
                float maxYaw = Mth.clamp(entityData.netHeadYaw(), -25.0f, 25.0f);
                tail.setRotY(tail.getRotY() - (maxYaw * Mth.DEG_TO_RAD));
            } else {
                float maxYaw = Mth.clamp(entityData.netHeadYaw(), -10.0f, 10.0f);
                tail.setRotY(tail.getRotY() - (maxYaw * Mth.DEG_TO_RAD));
            }
        }

        if (tail2 != null) {
            if (isMoving) {
                float maxYaw = Mth.clamp(entityData.netHeadYaw(), -25.0f, 25.0f);
                tail2.setRotY(tail2.getRotY() - (maxYaw * Mth.DEG_TO_RAD));
            } else {
                float maxYaw = Mth.clamp(entityData.netHeadYaw(), -10.0f, 10.0f);
                tail2.setRotY(tail2.getRotY() - (maxYaw * Mth.DEG_TO_RAD));
            }
        }

        if (tail3 != null) {
            if (isMoving) {
                float maxYaw = Mth.clamp(entityData.netHeadYaw(), -25.0f, 25.0f);
                tail3.setRotY(tail3.getRotY() - (maxYaw * Mth.DEG_TO_RAD));
            } else {
                float maxYaw = Mth.clamp(entityData.netHeadYaw(), -10.0f, 10.0f);
                tail3.setRotY(tail3.getRotY() - (maxYaw * Mth.DEG_TO_RAD));
            }
        }
    }


    public enum FemaleVariant {
        BROWN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/olorotitan/female_brown.png")),
        BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/olorotitan/female_blue.png")),
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/olorotitan/female_red.png")),
        TAN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/olorotitan/female_tan.png"));

        public final ResourceLocation resourceLocation;
        FemaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static FemaleVariant variantFromOrdinal(int variant) { return FemaleVariant.values()[variant % FemaleVariant.values().length];
        }
    }

    public enum MaleVariant {
        BROWN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/olorotitan/male_brown.png")),
        BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/olorotitan/male_blue.png")),
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/olorotitan/male_red.png")),
        TAN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/olorotitan/male_tan.png"));

        public final ResourceLocation resourceLocation;
        MaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static MaleVariant variantFromOrdinal(int variant) { return MaleVariant.values()[variant % MaleVariant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(DeadlyDinos.MODID, "geo/olorotitan.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(DeadlyDinos.MODID, "animations/olorotitan.animation.json");

    @Override
    public ResourceLocation getModelResource(Olorotitan object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Olorotitan object) {
        if (object.isFemale()) {
            return object.getFemaleTextureLocation();
        } else if (object.isMale()) {
            return object.getMaleTextureLocation();
        } else {
            return object.getFemaleTextureLocation();
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Olorotitan animatable) {
        return ANIMATION;
    }
}

