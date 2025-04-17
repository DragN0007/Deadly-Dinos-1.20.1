package com.dragn0007.deadlydinos.event;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entities.EntityTypes;
import com.dragn0007.deadlydinos.entities.acrocanthosaurus.Acrocanthosaurus;
import com.dragn0007.deadlydinos.entities.acrocanthosaurus.AcrocanthosaurusRender;
import com.dragn0007.deadlydinos.entities.anomaly.AnomalyAcrocanthosaurus;
import com.dragn0007.deadlydinos.entities.anomaly.AnomalyAcrocanthosaurusRender;
import com.dragn0007.deadlydinos.entities.utahraptor.Utahraptor;
import com.dragn0007.deadlydinos.entities.utahraptor.UtahraptorRender;
import com.dragn0007.deadlydinos.entities.yutyrannus.Yutyrannus;
import com.dragn0007.deadlydinos.entities.yutyrannus.YutyrannusRender;
import com.dragn0007.deadlydinos.gui.DDDMenuTypes;
import com.dragn0007.deadlydinos.gui.MountScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(modid = DeadlyDinos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DDDEvent {

    @SubscribeEvent
    public static void entityAttrbiuteCreationEvent(EntityAttributeCreationEvent event) {
        event.put(EntityTypes.ACROCANTHOSAURUS_ENTITY.get(), Acrocanthosaurus.createAttributes().build());
        event.put(EntityTypes.ANOMALOUS_ACROCANTHOSAURUS_ENTITY.get(), AnomalyAcrocanthosaurus.createAttributes().build());
        event.put(EntityTypes.UTAHRAPTOR_ENTITY.get(), Utahraptor.createAttributes().build());
        event.put(EntityTypes.YUTYRANNUS_ENTITY.get(), Yutyrannus.createAttributes().build());
    }

    @SubscribeEvent
    public static void clientSetupEvent(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityTypes.ACROCANTHOSAURUS_ENTITY.get(), AcrocanthosaurusRender::new);
        EntityRenderers.register(EntityTypes.ANOMALOUS_ACROCANTHOSAURUS_ENTITY.get(), AnomalyAcrocanthosaurusRender::new);
        EntityRenderers.register(EntityTypes.UTAHRAPTOR_ENTITY.get(), UtahraptorRender::new);
        EntityRenderers.register(EntityTypes.YUTYRANNUS_ENTITY.get(), YutyrannusRender::new);

        MenuScreens.register(DDDMenuTypes.MOUNT_MENU.get(), MountScreen::new);
    }

    @SubscribeEvent
    public static void spawnPlacementRegisterEvent(SpawnPlacementRegisterEvent event) {
        event.register(EntityTypes.ACROCANTHOSAURUS_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.ANOMALOUS_ACROCANTHOSAURUS_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.UTAHRAPTOR_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utahraptor::checkDesertDinoSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.YUTYRANNUS_ENTITY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
    }
}