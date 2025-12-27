package com.dragn0007.deadlydinos.entities.amargasaurus;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class AmargasaurusModel extends DefaultedEntityGeoModel<Amargasaurus> {

    public AmargasaurusModel() {
        super(new ResourceLocation(DeadlyDinos.MODID, "amargasaurus"), true);
    }

    @Override
    public void setCustomAnimations(Amargasaurus animatable, long instanceId, AnimationState<Amargasaurus> animationState) {

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

        CoreGeoBone row_1 = getAnimationProcessor().getBone("spikes_row_1");
        CoreGeoBone row_2 = getAnimationProcessor().getBone("spikes_row_2");
        CoreGeoBone row_3 = getAnimationProcessor().getBone("spikes_row_3");
        CoreGeoBone row_4 = getAnimationProcessor().getBone("spikes_row_4");
        CoreGeoBone row_5 = getAnimationProcessor().getBone("spikes_row_5");

        if (animatable.isInOffensive()) {
            row_1.setRotX(-94.5F);
            row_2.setRotX(-94.5F);
            row_3.setRotX(-94.5F);
            row_4.setRotX(-94.5F);
            row_5.setRotX(-94.5F);
        } else if (animatable.isInDefensive()) {
            row_1.setRotX(32);
            row_2.setRotX(32);
            row_3.setRotX(32);
            row_4.setRotX(32);
            row_5.setRotX(32);
        } else {
            row_1.setRotX(0);
            row_2.setRotX(0);
            row_3.setRotX(0);
            row_4.setRotX(0);
            row_5.setRotX(0);
        }
    }


    public enum FemaleVariant {
        BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/amargasaurus/female_blue.png")),
        IVORY(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/amargasaurus/female_ivory.png")),
        PURPLE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/amargasaurus/female_purple.png")),
        SILVER(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/amargasaurus/female_silver.png"));

        public final ResourceLocation resourceLocation;
        FemaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static FemaleVariant variantFromOrdinal(int variant) { return FemaleVariant.values()[variant % FemaleVariant.values().length];
        }
    }

    public enum MaleVariant {
        BLUE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/amargasaurus/male_blue.png")),
        IVORY(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/amargasaurus/male_ivory.png")),
        PURPLE(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/amargasaurus/male_purple.png")),
        SILVER(new ResourceLocation(DeadlyDinos.MODID, "textures/entity/amargasaurus/male_silver.png"));

        public final ResourceLocation resourceLocation;
        MaleVariant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static MaleVariant variantFromOrdinal(int variant) { return MaleVariant.values()[variant % MaleVariant.values().length];
        }
    }

    public static final ResourceLocation MODEL = new ResourceLocation(DeadlyDinos.MODID, "geo/amargasaurus.geo.json");
    public static final ResourceLocation ANIMATION = new ResourceLocation(DeadlyDinos.MODID, "animations/amargasaurus.animation.json");

    @Override
    public ResourceLocation getModelResource(Amargasaurus object) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Amargasaurus object) {
        if (object.isFemale()) {
            return object.getFemaleTextureLocation();
        } else if (object.isMale()) {
            return object.getMaleTextureLocation();
        } else {
            return object.getFemaleTextureLocation();
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Amargasaurus animatable) {
        return ANIMATION;
    }
}

