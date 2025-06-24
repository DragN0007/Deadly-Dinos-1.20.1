package com.dragn0007.deadlydinos.datagen.biglooter;

import com.dragn0007.deadlydinos.blocks.DDDBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class DDDBlockLoot extends BlockLootSubProvider {

    public DDDBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        dropSelf(DDDBlocks.REINFORCED_COBBLESTONE.get());
        dropSelf(DDDBlocks.REINFORCED_GLASS.get());
        dropSelf(DDDBlocks.REINFORCED_STONE_BRICKS.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DDDBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
