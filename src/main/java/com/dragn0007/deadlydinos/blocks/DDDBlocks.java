package com.dragn0007.deadlydinos.blocks;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.items.DDDItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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
    public static final RegistryObject<Block> DINO_GIFT_BOX = registerBlock("dino_gift_box",
            () -> new RotatedPillarBlock(Block.Properties.copy(WHITE_WOOL).strength(0.3F)));
//    public static final RegistryObject<Block> DINO_NUGGETS_BOX = registerBlock("dino_nuggets_box",
//            () -> new DinoNuggetBox());

    //Blocks
    public static final RegistryObject<Block> REINFORCED_GLASS = registerBlock("reinforced_glass",
            () -> new Block(Block.Properties.copy(GLASS)));
    public static final RegistryObject<Block> REINFORCED_STONE_BRICKS = registerBlock("reinforced_stone_bricks",
            () -> new Block(Block.Properties.copy(STONE_BRICKS)));
    public static final RegistryObject<Block> REINFORCED_COBBLESTONE = registerBlock("reinforced_cobblestone",
            () -> new Block(Block.Properties.copy(COBBLESTONE)));


    //Wood
    public static final RegistryObject<RotatedPillarBlock> CONIFER_LOG = registerBlock("conifer_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> CONIFER_PLANKS = registerBlock("conifer_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> CONIFER_STAIRS = registerBlock("conifer_stairs",
            () -> new StairBlock(CONIFER_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> CONIFER_SLAB = registerBlock("conifer_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F)));
//    public static final RegistryObject<Block> DFF_CONIFER_SAPLING = registerBlockWithoutItem("dff_conifer_sapling",
//            () -> new SaplingBlock(new ConiferTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> CONIFER_FENCE = registerBlock("conifer_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> CONIFER_FENCE_GATE = registerBlock("conifer_fence_gate",

            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(OAK_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> CONIFER_DOOR = registerBlock("conifer_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(OAK_DOOR), BlockSetType.OAK));
    public static final RegistryObject<Block> CONIFER_TRAPDOOR = registerBlock("conifer_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(OAK_TRAPDOOR), BlockSetType.OAK));


    public static final RegistryObject<RotatedPillarBlock> YEW_LOG = registerBlock("yew_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> YEW_PLANKS = registerBlock("yew_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> YEW_STAIRS = registerBlock("yew_stairs",
            () -> new StairBlock(YEW_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> YEW_SLAB = registerBlock("yew_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F)));
//    public static final RegistryObject<Block> DFF_YEW_SAPLING = registerBlockWithoutItem("dff_yew_sapling",
//            () -> new SaplingBlock(new YewTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> YEW_FENCE = registerBlock("yew_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> YEW_FENCE_GATE = registerBlock("yew_fence_gate",

            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(OAK_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> YEW_DOOR = registerBlock("yew_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(OAK_DOOR), BlockSetType.OAK));
    public static final RegistryObject<Block> YEW_TRAPDOOR = registerBlock("yew_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(OAK_TRAPDOOR), BlockSetType.OAK));


    public static final RegistryObject<RotatedPillarBlock> SEQUOIA_LOG = registerBlock("sequoia_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> SEQUOIA_PLANKS = registerBlock("sequoia_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SEQUOIA_STAIRS = registerBlock("sequoia_stairs",
            () -> new StairBlock(SEQUOIA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SEQUOIA_SLAB = registerBlock("sequoia_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F)));
//    public static final RegistryObject<Block> DFF_SEQUOIA_SAPLING = registerBlockWithoutItem("dff_sequoia_sapling",
//            () -> new SaplingBlock(new SequoiaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> SEQUOIA_FENCE = registerBlock("sequoia_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SEQUOIA_FENCE_GATE = registerBlock("sequoia_fence_gate",

            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(OAK_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> SEQUOIA_DOOR = registerBlock("sequoia_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(OAK_DOOR), BlockSetType.OAK));
    public static final RegistryObject<Block> SEQUOIA_TRAPDOOR = registerBlock("sequoia_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(OAK_TRAPDOOR), BlockSetType.OAK));


    public static final RegistryObject<Block> REINFORCED_ACACIA__PLANKS = registerBlock("reinforced_acacia_planks",
            () -> new Block(Block.Properties.copy(OAK_PLANKS)));
    public static final RegistryObject<Block> REINFORCED_BIRCH_PLANKS = registerBlock("reinforced_birch_planks",
            () -> new Block(Block.Properties.copy(OAK_PLANKS)));
    public static final RegistryObject<Block> REINFORCED_CRIMSON_PLANKS = registerBlock("reinforced_crimson_planks",
            () -> new Block(Block.Properties.copy(CRIMSON_PLANKS)));
    public static final RegistryObject<Block> REINFORCED_DARKOAK_PLANKS = registerBlock("reinforced_dark_oak_planks",
            () -> new Block(Block.Properties.copy(OAK_PLANKS)));
    public static final RegistryObject<Block> REINFORCED_JUNGLE_PLANKS = registerBlock("reinforced_jungle_planks",
            () -> new Block(Block.Properties.copy(OAK_PLANKS)));
    public static final RegistryObject<Block> REINFORCED_OAK_PLANKS = registerBlock("reinforced_oak_planks",
            () -> new Block(Block.Properties.copy(OAK_PLANKS)));
    public static final RegistryObject<Block> REINFORCED_SPRUCE_PLANKS = registerBlock("reinforced_spruce_planks",
            () -> new Block(Block.Properties.copy(OAK_PLANKS)));
    public static final RegistryObject<Block> REINFORCED_WARPED_PLANKS = registerBlock("reinforced_warped_planks",
            () -> new Block(Block.Properties.copy(WARPED_PLANKS)));


    //Plants
    public static final RegistryObject<FlowerBlock> COOKSONIA = registerBlock("cooksonia",
            () -> new FlowerBlock(MobEffects.ABSORPTION, 20, Block.Properties.copy(POPPY)));
    public static final RegistryObject<FlowerBlock> CYCAS = registerBlock("cycas",
            () -> new FlowerBlock(MobEffects.HEAL, 20, Block.Properties.copy(POPPY)));
    public static final RegistryObject<FlowerBlock> CYPERUS = registerBlock("cyperus",
            () -> new FlowerBlock(MobEffects.JUMP, 20, Block.Properties.copy(POPPY)));
    public static final RegistryObject<FlowerBlock> ZOSTEROPHYLLUM = registerBlock("zosterophyllum",
            () -> new FlowerBlock(MobEffects.ABSORPTION, 20, Block.Properties.copy(POPPY)));
    public static final RegistryObject<TallFlowerBlock> CYCADS = registerBlock("cycads",
            () -> new TallFlowerBlock(Block.Properties.copy(PEONY)));
    public static final RegistryObject<TallFlowerBlock> CALAMITES = registerBlock("calamites",
            () -> new TallFlowerBlock(Block.Properties.copy(PEONY)));


    //Decor
    public static final RegistryObject<Block> WIRE_FENCE_1 = registerBlock("wire_fence_1",
            () -> new IronBarsBlock(Block.Properties.copy(Blocks.IRON_BARS)));
    public static final RegistryObject<Block> WIRE_FENCE_2 = registerBlock("wire_fence_2",
            () -> new IronBarsBlock(Block.Properties.copy(Blocks.IRON_BARS)));
    public static final RegistryObject<Block> WIRE_FENCE_3 = registerBlock("wire_fence_3",
            () -> new IronBarsBlock(Block.Properties.copy(Blocks.IRON_BARS)));
    public static final RegistryObject<Block> WIRE_FENCE_4 = registerBlock("wire_fence_4",
            () -> new IronBarsBlock(Block.Properties.copy(Blocks.IRON_BARS)));


    protected static <T extends Block>RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block){
        return BLOCKS.register(name, block);
    }

    protected static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    protected static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        DDDItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    protected static <T extends Block>RegistryObject<T> registerPlantBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerPlantBlockItem(name, toReturn);
        return toReturn;
    }
    protected static <T extends Block> void registerPlantBlockItem(String name, RegistryObject<T> block) {
        DDDItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
