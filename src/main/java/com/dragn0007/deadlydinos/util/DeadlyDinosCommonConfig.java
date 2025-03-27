package com.dragn0007.deadlydinos.util;

import net.minecraftforge.common.ForgeConfigSpec;

public class DeadlyDinosCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue LARGE_DINOS_DESTROY_BLOCKS;
    public static final ForgeConfigSpec.BooleanValue MEDIUM_DINOS_DESTROY_BLOCKS;
    public static final ForgeConfigSpec.BooleanValue SMALL_DINOS_DESTROY_BLOCKS;
    public static final ForgeConfigSpec.ConfigValue<Integer> DINO_EGG_LAY_TIME;
    public static final ForgeConfigSpec.ConfigValue<Integer> DINO_EGG_LAY_AMOUNT;
    public static final ForgeConfigSpec.BooleanValue GENDERS_AFFECT_BIPRODUCTS;
    public static final ForgeConfigSpec.BooleanValue GENDERS_AFFECT_BREEDING;
    public static final ForgeConfigSpec.ConfigValue<Integer> UTAHRAPTOR_MAX_PACK_COUNT;

    static {
        BUILDER.push("Deadly Dinos");

        LARGE_DINOS_DESTROY_BLOCKS = BUILDER.comment("Should large dinos be able to destroy blocks like cobblestone, wood and glass?")
                .define("Large Dinos Break Blocks", true);

        MEDIUM_DINOS_DESTROY_BLOCKS = BUILDER.comment("Should medium dinos be able to destroy blocks like wood and glass?")
                .define("Medium Dinos Break Blocks", true);

        SMALL_DINOS_DESTROY_BLOCKS = BUILDER.comment("Should small dinos be able to destroy blocks like glass?")
                .define("Small Dinos Break Blocks", true);

        DINO_EGG_LAY_TIME = BUILDER.comment("Minimum amount of time, in ticks, that a dino can lay an unfertilized egg. Default is 24000 ticks, or 20 minutes.")
                .define("Dino Egg Lay Cooldown", 24000);

        DINO_EGG_LAY_AMOUNT = BUILDER.comment("Amount of Fertilized Eggs a dino should lay after mating. Default is 1.")
                .define("Dino Egg Lay Amount", 1);

        GENDERS_AFFECT_BIPRODUCTS = BUILDER.comment("Should an dino's gender affect the ability to get bi-products from it?")
                .define("Genders Affect Bi-Products/ Eggs", true);

        GENDERS_AFFECT_BREEDING = BUILDER.comment("Should a dino's gender affect how it breeds?")
                .define("Genders Affect Breeding", true);

        UTAHRAPTOR_MAX_PACK_COUNT = BUILDER.comment("Maximum amount of Utahraptors that can pack up at once.")
                .define("Max Utahraptor Pack Count", 4);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }

}
