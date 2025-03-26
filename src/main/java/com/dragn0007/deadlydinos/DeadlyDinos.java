package com.dragn0007.deadlydinos;

import com.dragn0007.deadlydinos.entities.EntityTypes;
import com.dragn0007.deadlydinos.items.DDDItemGroup;
import com.dragn0007.deadlydinos.items.DDDItems;
import com.dragn0007.deadlydinos.util.DeadlyDinosCommonConfig;
import net.minecraftforge.common.MinecraftForge;
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
        EntityTypes.ENTITY_TYPES.register(eventBus);

        GeckoLib.initialize();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DeadlyDinosCommonConfig.SPEC, "deadly-dinos-common.toml");

        MinecraftForge.EVENT_BUS.register(this);

        System.out.println("[DragN's Deadly Dinos] Registered DragN's Deadly Dinos!");
    }

}
