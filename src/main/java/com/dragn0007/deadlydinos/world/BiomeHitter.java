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

    public static final ResourceKey<BiomeModifier> SPAWN_ACROCANTHOSAURUS_PLAINS = registerKey("spawn_acrocanthosaurus_plains");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(SPAWN_ACROCANTHOSAURUS_PLAINS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                List.of(new MobSpawnSettings.SpawnerData(EntityTypes.ACROCANTHOSAURUS_ENTITY.get(),
                        5,
                        1,
                        1
                ))));

    }

    public static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(DeadlyDinos.MODID, name));
    }
}