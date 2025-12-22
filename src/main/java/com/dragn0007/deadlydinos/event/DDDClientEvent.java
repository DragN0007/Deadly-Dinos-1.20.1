package com.dragn0007.deadlydinos.event;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.client.gui.MountScreen;
import com.dragn0007.deadlydinos.client.gui.SmallInvScreen;
import com.dragn0007.deadlydinos.client.gui.TinyInvScreen;
import com.dragn0007.deadlydinos.common.gui.DDDMenuTypes;
import com.dragn0007.deadlydinos.entities.EntityTypes;
import com.dragn0007.deadlydinos.entities.acrocanthosaurus.AcrocanthosaurusRender;
import com.dragn0007.deadlydinos.entities.acrocanthosaurus.anomaly.AnomalyAcrocanthosaurusRender;
import com.dragn0007.deadlydinos.entities.ceratosaurus.CeratosaurusRender;
import com.dragn0007.deadlydinos.entities.eocarcharia.EocarchariaRender;
import com.dragn0007.deadlydinos.entities.giant_crop_snail.CropSnailRender;
import com.dragn0007.deadlydinos.entities.gryposaurus.GryposaurusRender;
import com.dragn0007.deadlydinos.entities.megaraptor.MegaraptorRender;
import com.dragn0007.deadlydinos.entities.mei_long.MeiLongRender;
import com.dragn0007.deadlydinos.entities.olorotitan.OlorotitanRender;
import com.dragn0007.deadlydinos.entities.oviraptor.OviraptorRender;
import com.dragn0007.deadlydinos.entities.parasaurolophus.ParasaurolophusRender;
import com.dragn0007.deadlydinos.entities.tarbosaurus.TarbosaurusRender;
import com.dragn0007.deadlydinos.entities.triceratops.TriceratopsRender;
import com.dragn0007.deadlydinos.entities.utahraptor.UtahraptorRender;
import com.dragn0007.deadlydinos.entities.velociraptor.VelociraptorRender;
import com.dragn0007.deadlydinos.entities.yutyrannus.YutyrannusRender;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(modid = DeadlyDinos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DDDClientEvent {

    @SubscribeEvent
    public static void clientSetupEvent(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityTypes.ACROCANTHOSAURUS.get(), AcrocanthosaurusRender::new);
        EntityRenderers.register(EntityTypes.ANOMALOUS_ACROCANTHOSAURUS.get(), AnomalyAcrocanthosaurusRender::new);
        EntityRenderers.register(EntityTypes.EOCARCHARIA.get(), EocarchariaRender::new);
        EntityRenderers.register(EntityTypes.MEGARAPTOR.get(), MegaraptorRender::new);
        EntityRenderers.register(EntityTypes.UTAHRAPTOR.get(), UtahraptorRender::new);
        EntityRenderers.register(EntityTypes.VELOCIRAPTOR.get(), VelociraptorRender::new);
        EntityRenderers.register(EntityTypes.YUTYRANNUS.get(), YutyrannusRender::new);
        EntityRenderers.register(EntityTypes.PARASAUROLOPHUS.get(), ParasaurolophusRender::new);
        EntityRenderers.register(EntityTypes.TRICERATOPS.get(), TriceratopsRender::new);
        EntityRenderers.register(EntityTypes.OLOROTITAN.get(), OlorotitanRender::new);
        EntityRenderers.register(EntityTypes.MEI_LONG.get(), MeiLongRender::new);
        EntityRenderers.register(EntityTypes.CERATOSAURUS.get(), CeratosaurusRender::new);
        EntityRenderers.register(EntityTypes.GRYPOSAURUS.get(), GryposaurusRender::new);
        EntityRenderers.register(EntityTypes.OVIRAPTOR.get(), OviraptorRender::new);
        EntityRenderers.register(EntityTypes.CROP_SNAIL.get(), CropSnailRender::new);
        EntityRenderers.register(EntityTypes.TARBOSAURUS.get(), TarbosaurusRender::new);

        MenuScreens.register(DDDMenuTypes.MOUNT_MENU.get(), MountScreen::new);
        MenuScreens.register(DDDMenuTypes.SMALL_INV_MENU.get(), SmallInvScreen::new);
        MenuScreens.register(DDDMenuTypes.TINY_INV_MENU.get(), TinyInvScreen::new);
    }

    public static final KeyMapping MOUNT_SPEED_UP = new KeyMapping("key.deadlydinos.mount_speed_up", InputConstants.KEY_LCONTROL, "key.deadlydinos.categories.deadlydinos");
    public static final KeyMapping MOUNT_SLOW_DOWN = new KeyMapping("key.deadlydinos.mount_slow_down", InputConstants.KEY_LALT, "key.deadlydinos.categories.deadlydinos");
    public static final KeyMapping SWIM_UP = new KeyMapping("key.deadlydinos.swim_up", InputConstants.KEY_SPACE, "key.deadlydinos.categories.deadlydinos");
    public static final KeyMapping SWIM_DOWN = new KeyMapping("key.deadlydinos.swim_down", InputConstants.KEY_LCONTROL, "key.deadlydinos.categories.deadlydinos");

    @SubscribeEvent
    public static void registerKeyBindings(RegisterKeyMappingsEvent event) {
        KeyMapping[] keyMappings = {MOUNT_SPEED_UP, MOUNT_SLOW_DOWN, SWIM_UP, SWIM_DOWN};
        for (KeyMapping keyMapping : keyMappings) {
            event.register(keyMapping);
        }
    }
}