package com.dragn0007.deadlydinos.world;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.entities.EntityTypes;
import com.dragn0007.deadlydinos.entities.acrocanthosaurus.Acrocanthosaurus;
import com.dragn0007.deadlydinos.entities.anomaly.AnomalyAcrocanthosaurus;
import com.dragn0007.deadlydinos.entities.anomaly.AnomalyAcrocanthosaurusModel;
import com.dragn0007.deadlydinos.entities.util.AbstractDino;
import com.dragn0007.deadlydinos.util.DeadlyDinosCommonConfig;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = DeadlyDinos.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AnomalySpawnReplacer {

    @SubscribeEvent
    public static void onSpawn(EntityJoinLevelEvent event) {

        Random random = new Random();

        if (DeadlyDinosCommonConfig.SPAWN_ANOMALIES.get() && event.getEntity() instanceof Acrocanthosaurus) {

            if (event.getEntity().getClass() == Acrocanthosaurus.class) {
                Acrocanthosaurus acrocanthosaurus = (Acrocanthosaurus) event.getEntity();

                if (event.getLevel().isClientSide) {
                    return;
                }

                AnomalyAcrocanthosaurus anomalyAcrocanthosaurus = EntityTypes.ANOMALOUS_ACROCANTHOSAURUS_ENTITY.get().create(event.getLevel());
                if (anomalyAcrocanthosaurus != null && event.getLevel().getRandom().nextDouble() < 0.02) {
                    anomalyAcrocanthosaurus.copyPosition(acrocanthosaurus);

                    anomalyAcrocanthosaurus.setCustomName(acrocanthosaurus.getCustomName());

                    int randomGender = event.getLevel().getRandom().nextInt(AbstractDino.Gender.values().length);
                    anomalyAcrocanthosaurus.setGender(randomGender);

                    if (anomalyAcrocanthosaurus.isFemale()) {
                        anomalyAcrocanthosaurus.setVariant(random.nextInt(AnomalyAcrocanthosaurusModel.FemaleVariant.values().length));
                    } else if (anomalyAcrocanthosaurus.isMale()) {
                        anomalyAcrocanthosaurus.setVariant(random.nextInt(AnomalyAcrocanthosaurusModel.MaleVariant.values().length));
                    }

                    if (event.getLevel().isClientSide) {
                        acrocanthosaurus.remove(Entity.RemovalReason.DISCARDED);
                    }

                    event.getLevel().addFreshEntity(anomalyAcrocanthosaurus);
                    acrocanthosaurus.remove(Entity.RemovalReason.DISCARDED);

                    event.setCanceled(true);
                }
            }
        }


    }

}