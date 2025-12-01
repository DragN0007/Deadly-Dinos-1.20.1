package com.dragn0007.deadlydinos.effects;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDDEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DeadlyDinos.MODID);

    public static final RegistryObject<MobEffect> BLEEDING = MOB_EFFECTS.register("bleeding",
            () -> new BleedingEffect(MobEffectCategory.HARMFUL, 0x5c0d12));

    public static final RegistryObject<MobEffect> BIRD_FLU = MOB_EFFECTS.register("bird_flu",
            () -> new BleedingEffect(MobEffectCategory.HARMFUL, 0x5c0d12));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}