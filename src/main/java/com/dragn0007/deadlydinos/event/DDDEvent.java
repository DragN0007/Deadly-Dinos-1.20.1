package com.dragn0007.deadlydinos.event;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.client.TinyInvScreen;
import com.dragn0007.deadlydinos.client.gui.MountScreen;
import com.dragn0007.deadlydinos.client.gui.SmallInvScreen;
import com.dragn0007.deadlydinos.common.gui.DDDMenuTypes;
import com.dragn0007.deadlydinos.entities.EntityTypes;
import com.dragn0007.deadlydinos.entities.acrocanthosaurus.Acrocanthosaurus;
import com.dragn0007.deadlydinos.entities.acrocanthosaurus.AcrocanthosaurusRender;
import com.dragn0007.deadlydinos.entities.acrocanthosaurus.anomaly.AnomalyAcrocanthosaurus;
import com.dragn0007.deadlydinos.entities.acrocanthosaurus.anomaly.AnomalyAcrocanthosaurusRender;
import com.dragn0007.deadlydinos.entities.ceratosaurus.Ceratosaurus;
import com.dragn0007.deadlydinos.entities.ceratosaurus.CeratosaurusRender;
import com.dragn0007.deadlydinos.entities.eocarcharia.Eocarcharia;
import com.dragn0007.deadlydinos.entities.eocarcharia.EocarchariaRender;
import com.dragn0007.deadlydinos.entities.megaraptor.Megaraptor;
import com.dragn0007.deadlydinos.entities.megaraptor.MegaraptorRender;
import com.dragn0007.deadlydinos.entities.mei_long.MeiLong;
import com.dragn0007.deadlydinos.entities.mei_long.MeiLongRender;
import com.dragn0007.deadlydinos.entities.olorotitan.Olorotitan;
import com.dragn0007.deadlydinos.entities.olorotitan.OlorotitanRender;
import com.dragn0007.deadlydinos.entities.parasaurolophus.Parasaurolophus;
import com.dragn0007.deadlydinos.entities.parasaurolophus.ParasaurolophusRender;
import com.dragn0007.deadlydinos.entities.triceratops.Triceratops;
import com.dragn0007.deadlydinos.entities.triceratops.TriceratopsRender;
import com.dragn0007.deadlydinos.entities.utahraptor.Utahraptor;
import com.dragn0007.deadlydinos.entities.utahraptor.UtahraptorRender;
import com.dragn0007.deadlydinos.entities.velociraptor.Velociraptor;
import com.dragn0007.deadlydinos.entities.velociraptor.VelociraptorRender;
import com.dragn0007.deadlydinos.entities.yutyrannus.Yutyrannus;
import com.dragn0007.deadlydinos.entities.yutyrannus.YutyrannusRender;
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
        event.put(EntityTypes.ACROCANTHOSAURUS.get(), Acrocanthosaurus.createAttributes().build());
        event.put(EntityTypes.ANOMALOUS_ACROCANTHOSAURUS.get(), AnomalyAcrocanthosaurus.createAttributes().build());
        event.put(EntityTypes.EOCARCHARIA.get(), Eocarcharia.createAttributes().build());
        event.put(EntityTypes.MEGARAPTOR.get(), Megaraptor.createAttributes().build());
        event.put(EntityTypes.UTAHRAPTOR.get(), Utahraptor.createAttributes().build());
        event.put(EntityTypes.VELOCIRAPTOR.get(), Velociraptor.createAttributes().build());
        event.put(EntityTypes.YUTYRANNUS.get(), Yutyrannus.createAttributes().build());
        event.put(EntityTypes.PARASAUROLOPHUS.get(), Parasaurolophus.createAttributes().build());
        event.put(EntityTypes.TRICERATOPS.get(), Triceratops.createAttributes().build());
        event.put(EntityTypes.OLOROTITAN.get(), Olorotitan.createAttributes().build());
        event.put(EntityTypes.MEI_LONG.get(), MeiLong.createAttributes().build());
        event.put(EntityTypes.CERATOSAURUS.get(), Ceratosaurus.createAttributes().build());
    }

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

        MenuScreens.register(DDDMenuTypes.MOUNT_MENU.get(), MountScreen::new);
        MenuScreens.register(DDDMenuTypes.SMALL_INV_MENU.get(), SmallInvScreen::new);
        MenuScreens.register(DDDMenuTypes.TINY_INV_MENU.get(), TinyInvScreen::new);
    }

    @SubscribeEvent
    public static void spawnPlacementRegisterEvent(SpawnPlacementRegisterEvent event) {
        event.register(EntityTypes.ACROCANTHOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.ANOMALOUS_ACROCANTHOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.EOCARCHARIA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.MEGARAPTOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.UTAHRAPTOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Utahraptor::checkDesertDinoSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.VELOCIRAPTOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.YUTYRANNUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.PARASAUROLOPHUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.TRICERATOPS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.OLOROTITAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.MEI_LONG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(EntityTypes.CERATOSAURUS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
    }
}