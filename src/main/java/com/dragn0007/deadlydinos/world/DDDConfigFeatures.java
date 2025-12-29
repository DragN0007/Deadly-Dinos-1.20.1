package com.dragn0007.deadlydinos.world;


import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.blocks.DDDBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class DDDConfigFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> FOOD_BOX = registerKey("food_box");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EQUIPMENT_BOX = registerKey("equipment_box");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEDICAL_BOX = registerKey("medical_box");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, FOOD_BOX, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DDDBlocks.FOOD_SUPPLY_STASH.get())));
        register(context, EQUIPMENT_BOX, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DDDBlocks.EQUIPMENT_SUPPLY_STASH.get())));
        register(context, MEDICAL_BOX, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DDDBlocks.MEDICAL_SUPPLY_STASH.get())));
    }
    
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DeadlyDinos.MODID, name));
    }
    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
      ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}


