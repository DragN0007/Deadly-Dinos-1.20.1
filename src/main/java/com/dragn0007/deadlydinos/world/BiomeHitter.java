package com.dragn0007.deadlydinos.world;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entities.EntityTypes;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class BiomeHitter {

    public static final ResourceKey<BiomeModifier> ADD_FOOD_BOX = registerKey("add_food_box");
    public static final ResourceKey<BiomeModifier> ADD_EQUIPMENT_BOX = registerKey("add_equipment_box");
    public static final ResourceKey<BiomeModifier> ADD_MEDICAL_BOX = registerKey("add_medical_box");

    public static final ResourceKey<BiomeModifier> ACROCANTHOSAURUS_PLAINS = registerKey("acrocanthosaurus_plains");
    public static final ResourceKey<BiomeModifier> MEGARAPTOR_FOREST = registerKey("megaraptor_forest");
    public static final ResourceKey<BiomeModifier> UTAHRAPTOR_HOT = registerKey("utahraptor_hot");
    public static final ResourceKey<BiomeModifier> YUTYRANNUS_COLD = registerKey("yutyrannus_cold");
    public static final ResourceKey<BiomeModifier> PARASAUROLOPHUS_WET = registerKey("parasaurolophus_wet");
    public static final ResourceKey<BiomeModifier> EOCARCHARIA_HOT = registerKey("eocarcharia_hot");
    public static final ResourceKey<BiomeModifier> TRICERATOPS_PLAINS = registerKey("triceratops_plains");
    public static final ResourceKey<BiomeModifier> OLOROTITAN_WET = registerKey("olorotitan_wet");
    public static final ResourceKey<BiomeModifier> VELOCIRAPTOR_DENSE = registerKey("velociraptor_dense");
    public static final ResourceKey<BiomeModifier> MEI_LONG_FOREST = registerKey("mei_long_forest");
    public static final ResourceKey<BiomeModifier> CERATOSAURUS_FOREST = registerKey("ceratosaurus_forest");
    public static final ResourceKey<BiomeModifier> GRYPOSAURUS_WET = registerKey("gryposaurus_wet");
    public static final ResourceKey<BiomeModifier> OVIRAPTOR_HOT = registerKey("oviraptor_hot");
    public static final ResourceKey<BiomeModifier> CROP_SNAIL_WET = registerKey("crop_snail_wet");
    public static final ResourceKey<BiomeModifier> TARBOSAURUS_HOT = registerKey("tarbosaurus_hot");
    public static final ResourceKey<BiomeModifier> AMARGASAURUS_PLAINS = registerKey("amargasaurus_plains");
    public static final ResourceKey<BiomeModifier> DIPLODOCUS_TAIGA = registerKey("diplodocus_taiga");
    public static final ResourceKey<BiomeModifier> ANUROGNATHUS_JUNGLE = registerKey("anurognathus_jungle");
    public static final ResourceKey<BiomeModifier> LIBANOCULEX_WET = registerKey("libanoculex_wet");
    public static final ResourceKey<BiomeModifier> MEGANEURA_FOREST = registerKey("meganeura_forest");
    public static final ResourceKey<BiomeModifier> EUPHOBERIA_HILLS = registerKey("euphoberia_hills");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_FOOD_BOX, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(DDDPlacedFeatures.FOOD_BOX)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_EQUIPMENT_BOX, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(DDDPlacedFeatures.EQUIPMENT_BOX)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_MEDICAL_BOX, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(DDDPlacedFeatures.MEDICAL_BOX)),
                GenerationStep.Decoration.VEGETAL_DECORATION));


        context.register(ACROCANTHOSAURUS_PLAINS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.ACROCANTHOSAURUS.get(),
                        3,
                        1,
                        1
                ))));

        context.register(CERATOSAURUS_FOREST, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.CERATOSAURUS.get(),
                        3,
                        1,
                        1
                ))));

        context.register(EOCARCHARIA_HOT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_HOT_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.EOCARCHARIA.get(),
                        3,
                        1,
                        1
                ))));

        context.register(MEGARAPTOR_FOREST, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.MEGARAPTOR.get(),
                        3,
                        1,
                        4
                ))));

        context.register(MEI_LONG_FOREST, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.MEI_LONG.get(),
                        5,
                        1,
                        4
                ))));

        context.register(OVIRAPTOR_HOT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_HOT_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.OVIRAPTOR.get(),
                        3,
                        1,
                        1
                ))));

        context.register(TARBOSAURUS_HOT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_HOT_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.TARBOSAURUS.get(),
                        2,
                        1,
                        1
                ))));

        context.register(UTAHRAPTOR_HOT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_HOT_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.UTAHRAPTOR.get(),
                        3,
                        1,
                        4
                ))));

        context.register(VELOCIRAPTOR_DENSE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_DENSE),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.VELOCIRAPTOR.get(),
                        3,
                        1,
                        6
                ))));

        context.register(YUTYRANNUS_COLD, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_COLD_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.YUTYRANNUS.get(),
                        3,
                        1,
                        2
                ))));


        context.register(ANUROGNATHUS_JUNGLE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.ANUROGNATHUS.get(),
                        5,
                        1,
                        1
                ))));

        context.register(AMARGASAURUS_PLAINS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.AMARGASAURUS.get(),
                        3,
                        1,
                        1
                ))));

        context.register(DIPLODOCUS_TAIGA, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_TAIGA),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.DIPLODOCUS.get(),
                        4,
                        1,
                        1
                ))));

        context.register(GRYPOSAURUS_WET, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_WET_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.GRYPOSAURUS.get(),
                        5,
                        1,
                        3
                ))));

        context.register(OLOROTITAN_WET, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_WET_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.OLOROTITAN.get(),
                        3,
                        1,
                        3
                ))));

        context.register(PARASAUROLOPHUS_WET, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_WET_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.PARASAUROLOPHUS.get(),
                        3,
                        1,
                        3
                ))));

        context.register(TRICERATOPS_PLAINS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.TRICERATOPS.get(),
                        4,
                        1,
                        3
                ))));


        context.register(CROP_SNAIL_WET, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_WET_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.CROP_SNAIL.get(),
                        5,
                        1,
                        2
                ))));

        context.register(LIBANOCULEX_WET, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_WET_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.LIBANOCULEX.get(),
                        7,
                        1,
                        1
                ))));

        context.register(MEGANEURA_FOREST, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.MEGANEURA.get(),
                        5,
                        2,
                        6
                ))));

        context.register(EUPHOBERIA_HILLS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_HILL),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.EUPHOBERIA.get(),
                        5,
                        1,
                        1
                ))));
    }

    public static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(DeadlyDinos.MODID, name));
    }
}