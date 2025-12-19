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

    //INJURIES
    public static final RegistryObject<MobEffect> BLEEDING = MOB_EFFECTS.register("bleeding",
            () -> new BleedingEffect(MobEffectCategory.HARMFUL, 0x5c0d12));

    public static final RegistryObject<MobEffect> BROKEN_ARM = MOB_EFFECTS.register("broken_arm",
            () -> new BrokenArmEffect(MobEffectCategory.HARMFUL, 0x5c0d12));

    public static final RegistryObject<MobEffect> BROKEN_LEG = MOB_EFFECTS.register("broken_leg",
            () -> new BrokenLegEffect(MobEffectCategory.HARMFUL, 0x5c0d12));

    //ILLNESSES
    public static final RegistryObject<MobEffect> BUG_BITE = MOB_EFFECTS.register("bug_bite",
            () -> new BugBiteEffect(MobEffectCategory.NEUTRAL, 0x5c0d12));

    public static final RegistryObject<MobEffect> BIRD_FLU = MOB_EFFECTS.register("bird_flu",
            () -> new BirdFluEffect(MobEffectCategory.HARMFUL, 0x5c0d12));

    public static final RegistryObject<MobEffect> AEROMONAS = MOB_EFFECTS.register("aeromonas",
            () -> new AeromonasEffect(MobEffectCategory.HARMFUL, 0x5c0d12));

    public static final RegistryObject<MobEffect> TAENIASIS = MOB_EFFECTS.register("taeniasis",
            () -> new TaeniasisEffect(MobEffectCategory.HARMFUL, 0x5c0d12));

    public static final RegistryObject<MobEffect> SEPSIS = MOB_EFFECTS.register("sepsis",
            () -> new SepsisEffect(MobEffectCategory.HARMFUL, 0x5c0d12));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}