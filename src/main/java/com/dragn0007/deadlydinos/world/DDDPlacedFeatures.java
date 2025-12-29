package com.dragn0007.deadlydinos.world;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class DDDPlacedFeatures {

    public static final ResourceKey<PlacedFeature> FOOD_BOX = registerKey("food_box");
    public static final ResourceKey<PlacedFeature> EQUIPMENT_BOX = registerKey("equipment_box");
    public static final ResourceKey<PlacedFeature> MEDICAL_BOX = registerKey("medical_box");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, FOOD_BOX, configuredFeatures.getOrThrow(DDDConfigFeatures.FOOD_BOX),
                List.of(RarityFilter.onAverageOnceEvery(256),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.anyOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.BASE_STONE_OVERWORLD), BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.SAND))))));

        register(context, EQUIPMENT_BOX, configuredFeatures.getOrThrow(DDDConfigFeatures.EQUIPMENT_BOX),
                List.of(RarityFilter.onAverageOnceEvery(256),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.anyOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.BASE_STONE_OVERWORLD), BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.SAND))))));

        register(context, MEDICAL_BOX, configuredFeatures.getOrThrow(DDDConfigFeatures.MEDICAL_BOX),
                List.of(RarityFilter.onAverageOnceEvery(256),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.noFluid(), BlockPredicate.anyOf(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.DIRT), BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.BASE_STONE_OVERWORLD), BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTags.SAND))))));
    }

    public static ResourceKey<PlacedFeature> registerKey (String name){
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(DeadlyDinos.MODID, name));
    }
    public static void register
    (BootstapContext < PlacedFeature > context, ResourceKey < PlacedFeature > key, Holder < ConfiguredFeature < ?, ?>>
    configuration,
            List < PlacementModifier > modifiers){
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
