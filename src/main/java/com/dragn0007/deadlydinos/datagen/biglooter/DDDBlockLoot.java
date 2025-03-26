package com.dragn0007.deadlydinos.datagen.biglooter;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;

import java.util.Set;

public class DDDBlockLoot extends BlockLootSubProvider {
    public DDDBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

    }

//    @Override
//    protected Iterable<Block> getKnownBlocks() {
//        return DDDBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
//    }
}
