package com.dragn0007.deadlydinos.event;

import com.dragn0007.deadlydinos.DeadlyDinos;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = DeadlyDinos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DDDClientEvent {

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