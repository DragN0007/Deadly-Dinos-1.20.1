package com.dragn0007.deadlydinos.util;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDDSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DeadlyDinos.MODID);

    public static final RegistryObject<SoundEvent> LARGE_CARNIVORE_AMBIENT = registerSoundEvents("large_carnivore_ambient");
    public static final RegistryObject<SoundEvent> MEDIUM_CARNIVORE_AMBIENT = registerSoundEvents("medium_carnivore_ambient");
    public static final RegistryObject<SoundEvent> RAPTOR_AMBIENT = registerSoundEvents("raptor_ambient");
    public static final RegistryObject<SoundEvent> LARGE_HERBIVORE_AMBIENT = registerSoundEvents("large_herbivore_ambient");
    public static final RegistryObject<SoundEvent> MEDIUM_HERBIVORE_AMBIENT = registerSoundEvents("medium_herbivore_ambient");
    public static final RegistryObject<SoundEvent> HERBIVORE_HISS = registerSoundEvents("herbivore_hiss");

    public static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DeadlyDinos.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}