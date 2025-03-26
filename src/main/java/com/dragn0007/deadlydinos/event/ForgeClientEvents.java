package com.dragn0007.deadlydinos.event;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.dragn0007.deadlydinos.util.DDDNetwork;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DeadlyDinos.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeClientEvents {
    @SubscribeEvent
    public static void onKeyPressEvent(InputEvent.Key event) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        if (event.getAction() == InputConstants.RELEASE && event.getKey() == DDDClientEvent.MOUNT_SPEED_UP.getKey().getValue()) {
            DDDNetwork.INSTANCE.sendToServer(new DDDNetwork.HandleSpeedRequest(1));
        }

        if (event.getAction() == InputConstants.RELEASE && event.getKey() == DDDClientEvent.MOUNT_SLOW_DOWN.getKey().getValue()) {
            DDDNetwork.INSTANCE.sendToServer(new DDDNetwork.HandleSpeedRequest(-1));
        }
    }
}