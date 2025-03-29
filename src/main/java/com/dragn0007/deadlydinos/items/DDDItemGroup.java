package com.dragn0007.deadlydinos.items;

import com.dragn0007.deadlydinos.DeadlyDinos;
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
                        output.accept(DDDItems.UTAHRAPTOR_SPAWN_EGG.get());
                        output.accept(DDDItems.UTAHRAPTOR_EGG.get());
                        output.accept(DDDItems.FERTILIZED_UTAHRAPTOR_EGG.get());
                        output.accept(DDDItems.YUTYRANNUS_SPAWN_EGG.get());
                        output.accept(DDDItems.YUTYRANNUS_EGG.get());
                        output.accept(DDDItems.FERTILIZED_YUTYRANNUS_EGG.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> DDD_ITEMS = CREATIVE_MODE_TABS.register("ddd_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DDDItems.DDD_ITEMS.get())).title(Component.translatable("itemGroup.ddd_items"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(DDDItems.ACROCANTHOSAURUS_TROPHY.get());
                        output.accept(DDDItems.UTAHRAPTOR_TROPHY.get());
                        output.accept(DDDItems.YUTYRANNUS_TROPHY.get());

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
                        output.accept(DDDItems.TIGER_NUTS.get());
                        output.accept(DDDItems.YEW_PLUM.get());
                        output.accept(DDDItems.TIGER_NUT_BUTTER.get());
                        output.accept(DDDItems.YEW_PLUM_JAM.get());
                        output.accept(DDDItems.PBJ.get());
                        output.accept(DDDItems.GLAZED_RIBS.get());
                        output.accept(DDDItems.RAW_ESCARGOT.get());
                        output.accept(DDDItems.COOKED_ESCARGOT .get());
                        output.accept(DDDItems.DINO_NUGGET_1.get());
                        output.accept(DDDItems.DINO_NUGGET_2.get());
                        output.accept(DDDItems.DINO_NUGGET_3.get());
                        output.accept(DDDItems.HEARTY_SALAD.get());
                        output.accept(DDDItems.SMOOTHIE.get());
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
