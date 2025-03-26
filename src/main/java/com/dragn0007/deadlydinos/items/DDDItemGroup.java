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

                        output.accept(DDDItems.RAW_SMALL_MEAT.get());
                        output.accept(DDDItems.COOKED_SMALL_MEAT.get());
                        output.accept(DDDItems.RAW_MEDIUM_MEAT.get());
                        output.accept(DDDItems.COOKED_MEDIUM_MEAT.get());
                        output.accept(DDDItems.RAW_LARGE_MEAT.get());
                        output.accept(DDDItems.COOKED_LARGE_MEAT.get());

                        output.accept(DDDItems.LARGE_CARNIVORE_CLAW.get());
                        output.accept(DDDItems.LARGE_CARNIVORE_LEG.get());
                        output.accept(DDDItems.LARGE_CARNIVORE_RIBS.get());
                        output.accept(DDDItems.LARGE_CARNIVORE_SKULL.get());
                        output.accept(DDDItems.LARGE_CARNIVORE_SPINE.get());
                        output.accept(DDDItems.LARGE_CARNIVORE_TAIL.get());
                        output.accept(DDDItems.LARGE_CARNIVORE_TOOTH.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
