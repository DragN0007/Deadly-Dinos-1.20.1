package com.dragn0007.deadlydinos.util;

import net.minecraftforge.common.ForgeConfigSpec;

public class DeadlyDinosCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue DEBUG_LOG;
    public static final ForgeConfigSpec.BooleanValue SPAWN_ANOMALIES;
    public static final ForgeConfigSpec.BooleanValue LARGE_DINOS_DESTROY_BLOCKS;
    public static final ForgeConfigSpec.BooleanValue MEDIUM_DINOS_DESTROY_BLOCKS;
    public static final ForgeConfigSpec.BooleanValue SMALL_DINOS_DESTROY_BLOCKS;
    public static final ForgeConfigSpec.BooleanValue GROUND_TIE;
    public static final ForgeConfigSpec.BooleanValue ALLOW_TAMING;
    public static final ForgeConfigSpec.BooleanValue ALLOW_EGG_LAY;
    public static final ForgeConfigSpec.ConfigValue<Integer> DINO_EGG_LAY_TIME;
    public static final ForgeConfigSpec.ConfigValue<Integer> DINO_EGG_LAY_AMOUNT;
    public static final ForgeConfigSpec.BooleanValue GENDERS_AFFECT_BIPRODUCTS;
    public static final ForgeConfigSpec.BooleanValue GENDERS_AFFECT_BREEDING;
    public static final ForgeConfigSpec.ConfigValue<Integer> UTAHRAPTOR_MAX_PACK_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> PARASAUROLOPHUS_MAX_HERD_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> TRICERATOPS_MAX_HERD_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> MEGARAPTOR_MAX_PACK_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> MEI_LONG_MAX_PACK_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> VELOCIRAPTOR_MAX_PACK_COUNT;
    public static final ForgeConfigSpec.ConfigValue<Integer> MEGANEURA_MAX_SWARM_COUNT;
    public static final ForgeConfigSpec.BooleanValue MILK_CURE;
    public static final ForgeConfigSpec.BooleanValue INJURY_EFFECTS;
    public static final ForgeConfigSpec.BooleanValue ILLNESS_EFFECTS;
    public static final ForgeConfigSpec.BooleanValue MEDICAL_SUPPLIES;
    public static final ForgeConfigSpec.BooleanValue SEPSIS;
    public static final ForgeConfigSpec.ConfigValue<Integer> SEPSIS_TIME;
    public static final ForgeConfigSpec.ConfigValue<Integer> BROKEN_BONE_HEAL_TIME;
    public static final ForgeConfigSpec.ConfigValue<Integer> CONCUSSION_HEAL_TIME;
    public static final ForgeConfigSpec.ConfigValue<Double> RAW_MEAT_PARASITE_CHANCE;
    public static final ForgeConfigSpec.ConfigValue<Double> LEG_BREAK_CHANCE;
    public static final ForgeConfigSpec.ConfigValue<Double> GAUZE_SUCCESS_CHANCE;
    public static final ForgeConfigSpec.ConfigValue<Double> BUG_CREAM_SUCCESS_CHANCE;
    public static final ForgeConfigSpec.ConfigValue<Double> ANTI_FLU_SUCCESS_CHANCE;
    public static final ForgeConfigSpec.ConfigValue<Double> ANTI_PARASITIC_SUCCESS_CHANCE;
    public static final ForgeConfigSpec.ConfigValue<Double> ANTI_BACTERIAL_SUCCESS_CHANCE;

    static {
        BUILDER.push("General");
        DEBUG_LOG = BUILDER.comment("Debug Log in Console")
                .define("Debug Log Enabled", false);

        SPAWN_ANOMALIES = BUILDER.comment("Should Anomalies be able to spawn?")
                .define("Anomaly Spawning", true);

        LARGE_DINOS_DESTROY_BLOCKS = BUILDER.comment("Should large dinos be able to destroy blocks like cobblestone, wood and glass?")
                .define("Large Dinos Break Blocks", true);

        MEDIUM_DINOS_DESTROY_BLOCKS = BUILDER.comment("Should medium dinos be able to destroy blocks like wood and glass?")
                .define("Medium Dinos Break Blocks", true);

        SMALL_DINOS_DESTROY_BLOCKS = BUILDER.comment("Should small dinos be able to destroy blocks like glass?")
                .define("Small Dinos Break Blocks", true);

        GROUND_TIE = BUILDER.comment("Should Ridable Dinos \"ground tie\", or stop moving around, when saddled & dismounted?")
                .define("Ground Tie When Dismounted", true);
        BUILDER.pop();

        BUILDER.push("Husbandry");
        ALLOW_TAMING = BUILDER.comment("Should players be able to tame certain kinds of dinos?")
                .define("Allow Taming", true);

        ALLOW_EGG_LAY = BUILDER.comment("Should dinos lay unfertilized eggs once in a while? This may be better turned off on lower-end servers.")
                .define("Allow Egg Laying", true);

        DINO_EGG_LAY_TIME = BUILDER.comment("Minimum amount of time, in ticks, that a dino can lay an unfertilized egg. Default is 24000 ticks, or 20 minutes.")
                .define("Dino Egg Lay Cooldown", 24000);

        DINO_EGG_LAY_AMOUNT = BUILDER.comment("Amount of Fertilized Eggs a dino should lay after mating. Default is 1.")
                .define("Dino Egg Lay Amount", 1);

        GENDERS_AFFECT_BIPRODUCTS = BUILDER.comment("Should an dino's gender affect the ability to get bi-products from it?")
                .define("Genders Affect Bi-Products/ Eggs", true);

        GENDERS_AFFECT_BREEDING = BUILDER.comment("Should a dino's gender affect how it breeds?")
                .define("Genders Affect Breeding", true);
        BUILDER.pop();

        BUILDER.push("Herding & Packing");
        PARASAUROLOPHUS_MAX_HERD_COUNT = BUILDER.comment("Maximum amount of Parasaurolophus that can herd up at once. Default is 6.")
                .define("Max Parasaurolophus Herd Count", 6);

        TRICERATOPS_MAX_HERD_COUNT = BUILDER.comment("Maximum amount of Triceratops that can herd up at once. Default is 6.")
                .define("Max Triceratops Herd Count", 6);

        MEGARAPTOR_MAX_PACK_COUNT = BUILDER.comment("Maximum amount of Megaraptors that can pack up at once. Default is 2.")
                .define("Max Megaraptor Pack Count", 2);

        MEI_LONG_MAX_PACK_COUNT = BUILDER.comment("Maximum amount of Mei Longs that can pack up at once. Default is 4.")
                .define("Max Mei Long Pack Count", 4);

        UTAHRAPTOR_MAX_PACK_COUNT = BUILDER.comment("Maximum amount of Utahraptors that can pack up at once. Default is 6.")
                .define("Max Utahraptor Pack Count", 6);

        VELOCIRAPTOR_MAX_PACK_COUNT = BUILDER.comment("Maximum amount of Velociraptors that can pack up at once. Default is 8.")
                .define("Max Velociraptor Pack Count", 8);

        MEGANEURA_MAX_SWARM_COUNT = BUILDER.comment("Maximum amount of Meganeura that can swarm at once. Default is 8.")
                .define("Max Meganeura Swarm Count", 8);
        BUILDER.pop();

        BUILDER.push("Injuries, Illnesses and Medical");
        MILK_CURE = BUILDER.comment("Should Milk Buckets be able to cure effects like vanilla? Disabled by default for the true apocalypse experience.")
                .define("Milk Buckets Cure Effects", false);

        INJURY_EFFECTS = BUILDER.comment("Should players be able to gain injury effects, such as Bleeding and Broken Bones? Disabling this disables ALL injuries. \nThis may be better turned false if you have a health mod installed (i.e. First Aid, Legendary Survival Overhaul) so that they don't overlap.")
                .define("Injuries Enabled", true);

        ILLNESS_EFFECTS = BUILDER.comment("Should players be able to gain illness effects, such as Avian Flu and Taeniasis? Disabling this disables ALL diseases and infections.")
                .define("Illnesses Enabled", true);

        MEDICAL_SUPPLIES = BUILDER.comment("Should medical supplies, such as Gauze, work for their intended effects? Turning this false will disable all DDD medical supplies and they will no longer work.")
                .define("Medical Supplies Enabled", true);

        SEPSIS = BUILDER.comment("Should some untreated bacterial infections turn into Sepsis over time?")
                .define("Untreated Infections to Sepsis", true);

        SEPSIS_TIME = BUILDER.comment("Amount of time it takes for an untreated infection to turn into Sepsis. Default is 72000, or 3 (vanilla) days.")
                .define("Sepsis Infection Time", 72000);

        BROKEN_BONE_HEAL_TIME = BUILDER.comment("Amount of time it takes for a broken bone to heal. Default is 72000, or 3 (vanilla) days.")
                .define("Broken Bone Heal Time", 72000);

        CONCUSSION_HEAL_TIME = BUILDER.comment("Amount of time it takes for a concussion to heal. Default is 48000, or 2 (vanilla) days.")
                .define("Concussion Heal Time", 72000);

        RAW_MEAT_PARASITE_CHANCE = BUILDER.comment("Chance of getting a parasitic infection from eating raw meat. Default is 0.50 (50%).")
                .define("Raw Meat Parasite Chance", 0.50);

        LEG_BREAK_CHANCE = BUILDER.comment("Chance of breaking your leg when taking moderate/ high fall damage. Default is 0.50 (50%).")
                .define("Leg Break Chance", 0.50);

        GAUZE_SUCCESS_CHANCE = BUILDER.comment("Chance that Gauze Wraps will lower or stop Bleeding. Default is 0.90 (90%).")
                .define("Gauze Wraps Success Chance", 0.90);

        BUG_CREAM_SUCCESS_CHANCE = BUILDER.comment("Chance that Bug Bite Cream will treat itchy bug bites. Default is 0.90 (90%).")
                .define("Bug Bite Cream Success Chance", 0.90);

        ANTI_FLU_SUCCESS_CHANCE = BUILDER.comment("Chance that the Bird Flu Shot will treat Avian Influenza. Default is 0.90 (90%).")
                .define("Bird Flu Shot Success Chance", 0.90);

        ANTI_PARASITIC_SUCCESS_CHANCE = BUILDER.comment("Chance that Parasitic Antibiotics will treat parasitic infections. Default is 0.75 (75%).")
                .define("Parasitic Antibiotics Success Chance", 0.75);

        ANTI_BACTERIAL_SUCCESS_CHANCE = BUILDER.comment("Chance that Bacterial Antibiotics will treat bacterial infections. Default is 0.75 (75%).")
                .define("Bacterial Antibiotics Success Chance", 0.75);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

}
