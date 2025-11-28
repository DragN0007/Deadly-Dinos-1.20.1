package com.dragn0007.deadlydinos;

import com.dragn0007.deadlydinos.blocks.DDDBlocks;
import com.dragn0007.deadlydinos.common.gui.DDDMenuTypes;
import com.dragn0007.deadlydinos.effects.DDDEffects;
import com.dragn0007.deadlydinos.entities.EntityTypes;
import com.dragn0007.deadlydinos.items.DDDItemGroup;
import com.dragn0007.deadlydinos.items.DDDItems;
import com.dragn0007.deadlydinos.util.DDDSoundEvents;
import com.dragn0007.deadlydinos.util.DeadlyDinosCommonConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib.GeckoLib;

@Mod(DeadlyDinos.MODID)
public class DeadlyDinos
{
    public static final String MODID = "deadlydinos";

    public DeadlyDinos()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DDDItems.register(eventBus);
        DDDItemGroup.register(eventBus);
        DDDBlocks.register(eventBus);
        DDDMenuTypes.register(eventBus);
        DDDSoundEvents.register(eventBus);
        DDDEffects.register(eventBus);
        EntityTypes.ENTITY_TYPES.register(eventBus);

        GeckoLib.initialize();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DeadlyDinosCommonConfig.SPEC, "deadly-dinos-common.toml");

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener((PlayerEvent.PlayerLoggedInEvent warn) -> warn(warn.getEntity()));

        System.out.println("[DragN's Deadly Dinos] Registered DragN's Deadly Dinos!");
    }

    public static void warn(Player entity){

        if (!DeadlyDinosCommonConfig.DEBUG_LOG.get()) {
            return;
        }

        entity.displayClientMessage(Component.empty().append
                (Component.literal(
                        "Welcome to DDD 1.20.1!" +
                        "\n(You can turn this message off by turning off the Debug Log config in deadly-dinos-common.toml)")
                .withStyle(ChatFormatting.DARK_RED)), false);

        entity.displayClientMessage(Component.empty().append
                (Component.literal(
                    "\nWant to report a bug or send feedback? https://github.com/DragN0007/Deadly-Dinos-1.20.1/issues")
                        .withStyle(ChatFormatting.DARK_RED))
                        .withStyle(t -> t.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/DragN0007/Deadly-Dinos-1.20.1/issues"))), false);
    }

}
