package com.dragn0007.deadlydinos.blocks;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.blocks.custom.ElectricIronBarsBlock;
import com.dragn0007.deadlydinos.items.DDDItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.*;

public class DDDBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, DeadlyDinos.MODID);

    //Box
//    public static final RegistryObject<Block> DINO_GIFT_BOX = registerBlock("dino_gift_box",
//            () -> new RotatedPillarBlock(Block.Properties.copy(WHITE_WOOL).strength(0.3F)));
//    public static final RegistryObject<Block> DINO_NUGGETS_BOX = registerBlock("dino_nuggets_box",
//            () -> new DinoNuggetBox());

    //Blocks
    public static final RegistryObject<Block> REINFORCED_COBBLESTONE = registerBlock("reinforced_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(COBBLESTONE)));
    public static final RegistryObject<Block> REINFORCED_GLASS = registerBlock("reinforced_glass",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(GLASS)));
    public static final RegistryObject<Block> REINFORCED_STONE_BRICKS = registerBlock("reinforced_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(STONE_BRICKS)));


    //Decor
    public static final RegistryObject<Block> CHAIN_LINK_FENCE = registerBlock("chain_link_fence",
            () -> new IronBarsBlock(Block.Properties.copy(Blocks.IRON_BARS)));
    public static final RegistryObject<Block> HORIZONTAL_BAR_FENCE = registerBlock("horizontal_bar_fence",
            () -> new IronBarsBlock(Block.Properties.copy(Blocks.IRON_BARS)));
    public static final RegistryObject<Block> WIDE_BAR_FENCE = registerBlock("wide_bar_fence",
            () -> new IronBarsBlock(Block.Properties.copy(Blocks.IRON_BARS)));
    public static final RegistryObject<Block> WIRE_FENCE = registerBlock("wire_fence",
            () -> new IronBarsBlock(Block.Properties.copy(Blocks.IRON_BARS)));
    public static final RegistryObject<Block> ELECTRIC_WIRE_FENCE = registerBlock("electric_wire_fence",
            () -> new ElectricIronBarsBlock(Block.Properties.copy(Blocks.IRON_BARS)));


    public static <T extends Block>RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block){
        return BLOCKS.register(name, block);
    }

    public static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        DDDItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static <T extends Block>RegistryObject<T> registerPlantBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerPlantBlockItem(name, toReturn);
        return toReturn;
    }
    public static <T extends Block> void registerPlantBlockItem(String name, RegistryObject<T> block) {
        DDDItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
