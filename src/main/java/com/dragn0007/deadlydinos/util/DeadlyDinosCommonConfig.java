package com.dragn0007.deadlydinos.util;

import net.minecraftforge.common.ForgeConfigSpec;

public class DeadlyDinosCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> DINO_EGG_LAY_TIME;
    public static final ForgeConfigSpec.ConfigValue<Integer> DINO_EGG_LAY_AMOUNT;
    public static final ForgeConfigSpec.BooleanValue GENDERS_AFFECT_BIPRODUCTS;
    public static final ForgeConfigSpec.BooleanValue GENDERS_AFFECT_BREEDING;

    static {
        BUILDER.push("Deadly Dinos");

        DINO_EGG_LAY_TIME = BUILDER.comment("Minimum amount of time, in ticks, that a dino can lay an unfertilized egg. Default is 24000 ticks, or 20 minutes.")
                .define("Dino Egg Lay Cooldown", 24000);

        DINO_EGG_LAY_AMOUNT = BUILDER.comment("Amount of Fertilized Eggs a dino should lay after mating. Default is 1.")
                .define("Dino Egg Lay Amount", 1);

        GENDERS_AFFECT_BIPRODUCTS = BUILDER.comment("Should an dino's gender affect the ability to get bi-products from it?")
                .define("Genders Affect Bi-Products/ Eggs", true);

        GENDERS_AFFECT_BREEDING = BUILDER.comment("Should a dino's gender affect how it breeds?")
                .define("Genders Affect Breeding", true);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }

}
