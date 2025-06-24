package com.dragn0007.deadlydinos.datagen;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.blocks.DDDBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDDBlockstateProvider extends BlockStateProvider {
    public DDDBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DeadlyDinos.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(DDDBlocks.REINFORCED_COBBLESTONE);
        simpleBlockWithItem(DDDBlocks.REINFORCED_GLASS.get(), models().cubeAll(DDDBlocks.REINFORCED_GLASS.getId().getPath(),
                blockTexture(DDDBlocks.REINFORCED_GLASS.get())).renderType("cutout"));
        blockWithItem(DDDBlocks.REINFORCED_STONE_BRICKS);
        }

    public void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    public void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(DeadlyDinos.MODID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    public ResourceLocation wildPlantTexture(String getTextureName) {
        return new ResourceLocation(DeadlyDinos.MODID,"block/" + getTextureName);
    }

}
