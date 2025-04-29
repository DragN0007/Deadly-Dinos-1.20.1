package com.dragn0007.deadlydinos.world;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entities.EntityTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class BiomeHitter {

    public static final ResourceKey<BiomeModifier> ACROCANTHOSAURUS_PLAINS = registerKey("acrocanthosaurus_plains");
    public static final ResourceKey<BiomeModifier> UTAHRAPTOR_HOT = registerKey("utahraptor_hot");
    public static final ResourceKey<BiomeModifier> YUTYRANNUS_COLD = registerKey("yutyrannus_cold");
    public static final ResourceKey<BiomeModifier> PARASAUROLOPHUS_WET = registerKey("parasaurolophus_wet");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ACROCANTHOSAURUS_PLAINS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.ACROCANTHOSAURUS_ENTITY.get(),
                        2,
                        1,
                        1
                ))));

        context.register(UTAHRAPTOR_HOT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_HOT_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.UTAHRAPTOR_ENTITY.get(),
                        4,
                        1,
                        4
                ))));

        context.register(YUTYRANNUS_COLD, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_COLD_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.YUTYRANNUS_ENTITY.get(),
                        3,
                        1,
                        2
                ))));

        context.register(PARASAUROLOPHUS_WET, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_WET_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.PARASAUROLOPHUS_ENTITY.get(),
                        3,
                        1,
                        3
                ))));

    }

    public static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(DeadlyDinos.MODID, name));
    }
}