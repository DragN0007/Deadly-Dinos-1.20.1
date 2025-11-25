package com.dragn0007.deadlydinos.entities.utahraptor;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class UtahraptorModel extends DefaultedEntityGeoModel<Utahraptor> {

    public UtahraptorModel() {
        super(new ResourceLocation(DeadlyDinos.MODID, "utahraptor"), true);
    }

    @Override
    public void setCustomAnimations(Utahraptor animatable, long instanceId, AnimationState<Utahraptor> animationState) {

        double x = animatable.getX() - animatable.xo;
        double z = animatable.getZ() - animatable.zo;
        boolean isMoving = (x * x + z * z) > 0.0001;

        CoreGeoBone neck = getAnimationProcessor().getBone("neck");
        CoreGeoBone head = getAnimationProcessor().getBone("head");
        CoreGeoBone tail = getAnimationProcessor().getBone("tail");
        CoreGeoBone tail2 = getAnimationProcessor().getBone("tail2");
        CoreGeoBone tail3 = getAnimationProcessor().getBone("tail3");

        EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

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
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahraptor/female_red.png")),
        BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahraptor/female_blue.png")),
        GREEN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahraptor/female_green.png"));

        public final ResourceLocation resourceLocation;
        FemaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static FemaleVariant variantFromOrdinal(int variant) { return FemaleVariant.values()[variant % FemaleVariant.values().length];
        }
    }

    public enum MaleVariant {
        RED(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahraptor/male_red.png")),
        BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahraptor/male_blue.png")),
        GREEN(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/utahraptor/male_green.png"));

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

