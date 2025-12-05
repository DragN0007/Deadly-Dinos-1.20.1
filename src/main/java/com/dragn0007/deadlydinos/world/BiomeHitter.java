package com.dragn0007.deadlydinos.world;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entities.EntityTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class BiomeHitter {

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

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ACROCANTHOSAURUS_PLAINS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.ACROCANTHOSAURUS.get(),
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

        context.register(UTAHRAPTOR_HOT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_HOT_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.UTAHRAPTOR.get(),
                        4,
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

        context.register(OLOROTITAN_WET, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_WET_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.OLOROTITAN.get(),
                        4,
                        1,
                        3
                ))));

        context.register(PARASAUROLOPHUS_WET, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_WET_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.PARASAUROLOPHUS.get(),
                        4,
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

    }

    public static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(DeadlyDinos.MODID, name));
    }
}