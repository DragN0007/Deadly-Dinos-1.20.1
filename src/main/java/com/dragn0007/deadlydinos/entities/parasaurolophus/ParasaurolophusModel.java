package com.dragn0007.deadlydinos.entities.parasaurolophus;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entities.acrocanthosaurus.Acrocanthosaurus;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ParasaurolophusModel extends DefaultedEntityGeoModel<Parasaurolophus> {

    public ParasaurolophusModel() {
        super(new ResourceLocation(DeadlyDinos.MODID, "parasaurolophus"), true);
    }

    @Override
    public void setCustomAnimations(Parasaurolophus animatable, long instanceId, AnimationState<Parasaurolophus> animationState) {

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

