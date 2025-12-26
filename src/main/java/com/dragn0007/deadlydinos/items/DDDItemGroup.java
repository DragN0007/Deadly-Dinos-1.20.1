package com.dragn0007.deadlydinos.items;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.blocks.DDDBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DDDItemGroup {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DeadlyDinos.MODID);

    public static final RegistryObject<CreativeModeTab> DDD_ENTITIES = CREATIVE_MODE_TABS.register("ddd_entities",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DDDItems.DDD_ENTITIES.get())).title(Component.translatable("itemGroup.ddd_entities"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(DDDItems.ACROCANTHOSAURUS_SPAWN_EGG.get());
                        output.accept(DDDItems.ACROCANTHOSAURUS_EGG.get());
                        output.accept(DDDItems.FERTILIZED_ACROCANTHOSAURUS_EGG.get());
                        output.accept(DDDItems.CERATOSAURUS_SPAWN_EGG.get());
                        output.accept(DDDItems.CERATOSAURUS_EGG.get());
                        output.accept(DDDItems.FERTILIZED_CERATOSAURUS_EGG.get());
                        output.accept(DDDItems.EOCARCHARIA_SPAWN_EGG.get());
                        output.accept(DDDItems.EOCARCHARIA_EGG.get());
                        output.accept(DDDItems.FERTILIZED_EOCARCHARIA_EGG.get());
                        output.accept(DDDItems.MEGARAPTOR_SPAWN_EGG.get());
                        output.accept(DDDItems.MEGARAPTOR_EGG.get());
                        output.accept(DDDItems.FERTILIZED_MEGARAPTOR_EGG.get());
                        output.accept(DDDItems.MEI_LONG_SPAWN_EGG.get());
                        output.accept(DDDItems.MEI_LONG_EGG.get());
                        output.accept(DDDItems.FERTILIZED_MEI_LONG_EGG.get());
                        output.accept(DDDItems.OVIRAPTOR_SPAWN_EGG.get());
                        output.accept(DDDItems.OVIRAPTOR_EGG.get());
                        output.accept(DDDItems.FERTILIZED_OVIRAPTOR_EGG.get());
                        output.accept(DDDItems.TARBOSAURUS_SPAWN_EGG.get());
                        output.accept(DDDItems.TARBOSAURUS_EGG.get());
                        output.accept(DDDItems.FERTILIZED_TARBOSAURUS_EGG.get());
                        output.accept(DDDItems.UTAHRAPTOR_SPAWN_EGG.get());
                        output.accept(DDDItems.UTAHRAPTOR_EGG.get());
                        output.accept(DDDItems.FERTILIZED_UTAHRAPTOR_EGG.get());
                        output.accept(DDDItems.VELOCIRAPTOR_SPAWN_EGG.get());
                        output.accept(DDDItems.VELOCIRAPTOR_EGG.get());
                        output.accept(DDDItems.FERTILIZED_VELOCIRAPTOR_EGG.get());
                        output.accept(DDDItems.YUTYRANNUS_SPAWN_EGG.get());
                        output.accept(DDDItems.YUTYRANNUS_EGG.get());
                        output.accept(DDDItems.FERTILIZED_YUTYRANNUS_EGG.get());

                        output.accept(DDDItems.DIPLODOCUS_SPAWN_EGG.get());
                        output.accept(DDDItems.DIPLODOCUS_EGG.get());
                        output.accept(DDDItems.FERTILIZED_DIPLODOCUS_EGG.get());
                        output.accept(DDDItems.GRYPOSAURUS_SPAWN_EGG.get());
                        output.accept(DDDItems.GRYPOSAURUS_EGG.get());
                        output.accept(DDDItems.FERTILIZED_GRYPOSAURUS_EGG.get());
                        output.accept(DDDItems.OLOROTITAN_SPAWN_EGG.get());
                        output.accept(DDDItems.OLOROTITAN_EGG.get());
                        output.accept(DDDItems.FERTILIZED_OLOROTITAN_EGG.get());
                        output.accept(DDDItems.PARASAUROLOPHUS_SPAWN_EGG.get());
                        output.accept(DDDItems.PARASAUROLOPHUS_EGG.get());
                        output.accept(DDDItems.FERTILIZED_PARASAUROLOPHUS_EGG.get());
                        output.accept(DDDItems.TRICERATOPS_SPAWN_EGG.get());
                        output.accept(DDDItems.TRICERATOPS_EGG.get());
                        output.accept(DDDItems.FERTILIZED_TRICERATOPS_EGG.get());

                        output.accept(DDDItems.GIANT_CROP_SNAIL_SPAWN_EGG.get());
                        output.accept(DDDItems.GIANT_CROP_SNAIL_EGG.get());
                        output.accept(DDDItems.FERTILIZED_GIANT_CROP_SNAIL_EGG.get());

                        output.accept(DDDItems.ANOMALY_ACROCANTHOSAURUS_SPAWN_EGG.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> DDD_ITEMS = CREATIVE_MODE_TABS.register("ddd_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DDDItems.DDD_ITEMS.get())).title(Component.translatable("itemGroup.ddd_items"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(DDDItems.ACROCANTHOSAURUS_TROPHY.get());
                        output.accept(DDDItems.EOCARCHARIA_TROPHY.get());
                        output.accept(DDDItems.MEGARAPTOR_TROPHY.get());
                        output.accept(DDDItems.MEI_LONG_TROPHY.get());
                        output.accept(DDDItems.OVIRAPTOR_TROPHY.get());
                        output.accept(DDDItems.TARBOSAURUS_TROPHY.get());
                        output.accept(DDDItems.UTAHRAPTOR_TROPHY.get());
                        output.accept(DDDItems.VELOCIRAPTOR_TROPHY.get());
                        output.accept(DDDItems.YUTYRANNUS_TROPHY.get());
                        output.accept(DDDItems.DIPLODOCUS_TROPHY.get());
                        output.accept(DDDItems.GRYPOSAURUS_TROPHY.get());
                        output.accept(DDDItems.OLOROTITAN_TROPHY.get());
                        output.accept(DDDItems.PARASAUROLOPHUS_TROPHY.get());
                        output.accept(DDDItems.TRICERATOPS_TROPHY.get());

                        output.accept(DDDItems.EOCARCHARIA_ARMOR.get());

                        output.accept(DDDItems.ANOMALY_BONE_SWORD.get());
                        output.accept(DDDItems.ANOMALY_BONE_PICKAXE.get());
                        output.accept(DDDItems.ANOMALY_BONE_SHOVEL.get());
                        output.accept(DDDItems.ANOMALY_BONE_AXE.get());
                        output.accept(DDDItems.ANOMALY_BONE_HOE.get());
                        output.accept(DDDItems.ANOMALY_BONE_DAGGER.get());
                        output.accept(DDDItems.ANOMALY_BONE_GREATSWORD.get());
                        output.accept(DDDItems.ANOMALY_BONE_BATTLEAXE.get());
                        output.accept(DDDItems.ANOMALY_BONE_WARHAMMER.get());

                        output.accept(DDDItems.BONE_SWORD.get());
                        output.accept(DDDItems.BONE_PICKAXE.get());
                        output.accept(DDDItems.BONE_SHOVEL.get());
                        output.accept(DDDItems.BONE_AXE.get());
                        output.accept(DDDItems.BONE_HOE.get());
                        output.accept(DDDItems.BONE_DAGGER.get());
                        output.accept(DDDItems.BONE_GREATSWORD.get());
                        output.accept(DDDItems.BONE_BATTLEAXE.get());
                        output.accept(DDDItems.BONE_WARHAMMER.get());

                        output.accept(DDDItems.RIOT_HELMET.get());
                        output.accept(DDDItems.RIOT_CHESTPLATE.get());
                        output.accept(DDDItems.RIOT_LEGGINGS.get());
                        output.accept(DDDItems.RIOT_BOOTS.get());

                        output.accept(DDDBlocks.REINFORCED_COBBLESTONE.get());
                        output.accept(DDDBlocks.REINFORCED_GLASS.get());
                        output.accept(DDDBlocks.REINFORCED_STONE_BRICKS.get());
                        output.accept(DDDBlocks.CHAIN_LINK_FENCE.get());
                        output.accept(DDDBlocks.HORIZONTAL_BAR_FENCE.get());
                        output.accept(DDDBlocks.WIDE_BAR_FENCE.get());
                        output.accept(DDDBlocks.WIRE_FENCE.get());
                        output.accept(DDDBlocks.ELECTRIC_WIRE_FENCE.get());
                        output.accept(DDDBlocks.FOOD_SUPPLY_STASH.get());
                        output.accept(DDDBlocks.EQUIPMENT_SUPPLY_STASH.get());
                        output.accept(DDDBlocks.MEDICAL_SUPPLY_STASH.get());

                        output.accept(DDDItems.SMALL_CARNIVORE_CLAW.get());
                        output.accept(DDDItems.SMALL_CARNIVORE_LEG.get());
                        output.accept(DDDItems.SMALL_CARNIVORE_RIBS.get());
                        output.accept(DDDItems.SMALL_CARNIVORE_SKULL.get());
                        output.accept(DDDItems.SMALL_CARNIVORE_SPINE.get());
                        output.accept(DDDItems.SMALL_CARNIVORE_TAIL.get());
                        output.accept(DDDItems.SMALL_CARNIVORE_TOOTH.get());
                        output.accept(DDDItems.SMALL_RAPTOR_CLAW.get());

                        output.accept(DDDItems.MEDIUM_CARNIVORE_CLAW.get());
                        output.accept(DDDItems.MEDIUM_CARNIVORE_LEG.get());
                        output.accept(DDDItems.MEDIUM_CARNIVORE_RIBS.get());
                        output.accept(DDDItems.MEDIUM_CARNIVORE_SKULL.get());
                        output.accept(DDDItems.MEDIUM_CARNIVORE_SPINE.get());
                        output.accept(DDDItems.MEDIUM_CARNIVORE_TAIL.get());
                        output.accept(DDDItems.MEDIUM_CARNIVORE_TOOTH.get());
                        output.accept(DDDItems.MEDIUM_RAPTOR_CLAW.get());

                        output.accept(DDDItems.LARGE_CARNIVORE_CLAW.get());
                        output.accept(DDDItems.LARGE_CARNIVORE_LEG.get());
                        output.accept(DDDItems.LARGE_CARNIVORE_RIBS.get());
                        output.accept(DDDItems.LARGE_CARNIVORE_SKULL.get());
                        output.accept(DDDItems.LARGE_CARNIVORE_SPINE.get());
                        output.accept(DDDItems.LARGE_CARNIVORE_TAIL.get());
                        output.accept(DDDItems.LARGE_CARNIVORE_TOOTH.get());

                        output.accept(DDDItems.SMALL_HERBIVORE_CLAW.get());
                        output.accept(DDDItems.SMALL_HERBIVORE_LEG.get());
                        output.accept(DDDItems.SMALL_HERBIVORE_RIBS.get());
                        output.accept(DDDItems.SMALL_HERBIVORE_SKULL.get());
                        output.accept(DDDItems.SMALL_HERBIVORE_SPINE.get());
                        output.accept(DDDItems.SMALL_HERBIVORE_TAIL.get());
                        output.accept(DDDItems.SMALL_HERBIVORE_TOOTH.get());

                        output.accept(DDDItems.MEDIUM_HERBIVORE_CLAW.get());
                        output.accept(DDDItems.MEDIUM_HERBIVORE_LEG.get());
                        output.accept(DDDItems.MEDIUM_HERBIVORE_RIBS.get());
                        output.accept(DDDItems.MEDIUM_HERBIVORE_SKULL.get());
                        output.accept(DDDItems.MEDIUM_HERBIVORE_SPINE.get());
                        output.accept(DDDItems.MEDIUM_HERBIVORE_TAIL.get());
                        output.accept(DDDItems.MEDIUM_HERBIVORE_TOOTH.get());

                        output.accept(DDDItems.LARGE_HERBIVORE_CLAW.get());
                        output.accept(DDDItems.LARGE_HERBIVORE_LEG.get());
                        output.accept(DDDItems.LARGE_HERBIVORE_RIBS.get());
                        output.accept(DDDItems.LARGE_HERBIVORE_SKULL.get());
                        output.accept(DDDItems.LARGE_HERBIVORE_SPINE.get());
                        output.accept(DDDItems.LARGE_HERBIVORE_TAIL.get());
                        output.accept(DDDItems.LARGE_HERBIVORE_TOOTH.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> DDD_FOOD = CREATIVE_MODE_TABS.register("ddd_food",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DDDItems.DDD_FOOD.get())).title(Component.translatable("itemGroup.ddd_food"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(DDDItems.GAUZE_WRAP.get());
                        output.accept(DDDItems.BUG_BITE_CREAM.get());
                        output.accept(DDDItems.BIRD_FLU_SHOT.get());
                        output.accept(DDDItems.BACTERIAL_ANTIBIOTIC.get());
                        output.accept(DDDItems.PARASITIC_ANTIBIOTIC.get());

                        output.accept(DDDItems.RAW_SMALL_MEAT.get());
                        output.accept(DDDItems.COOKED_SMALL_MEAT.get());
                        output.accept(DDDItems.RAW_MEDIUM_MEAT.get());
                        output.accept(DDDItems.COOKED_MEDIUM_MEAT.get());
                        output.accept(DDDItems.RAW_LARGE_MEAT.get());
                        output.accept(DDDItems.COOKED_LARGE_MEAT.get());
                        output.accept(DDDItems.CRACKER.get());
                        output.accept(DDDItems.DINO_SANDWICH.get());
                        output.accept(DDDItems.CANNED_VEGGIES.get());
                        output.accept(DDDItems.CANNED_MEAT.get());
                        output.accept(DDDItems.CANNED_STEW.get());
                        output.accept(DDDItems.MRE.get());
                        output.accept(DDDItems.SODA.get());
                        output.accept(DDDItems.RAW_ESCARGOT.get());
                        output.accept(DDDItems.COOKED_ESCARGOT .get());
//                        output.accept(DDDItems.DINO_NUGGET_1.get());
//                        output.accept(DDDItems.DINO_NUGGET_2.get());
//                        output.accept(DDDItems.DINO_NUGGET_3.get());
                        output.accept(DDDItems.HEARTY_SALAD.get());
                        output.accept(DDDItems.DINO_DUMPLING.get());
                        output.accept(DDDItems.CHICKEN_NOODLE_SOUP.get());
                        output.accept(DDDItems.DINO_ROAST.get());
                        output.accept(DDDItems.BONE_MARROW.get());
                        output.accept(DDDItems.BROTH.get());
                        output.accept(DDDItems.DOUGH.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
