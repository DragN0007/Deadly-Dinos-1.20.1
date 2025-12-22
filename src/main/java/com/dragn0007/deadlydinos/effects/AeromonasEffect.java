package com.dragn0007.deadlydinos.effects;

import com.dragn0007.deadlydinos.util.DeadlyDinosCommonConfig;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class AeromonasEffect extends MobEffect {
    public AeromonasEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    public int turnIntoSepsisTick = 300;

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (DeadlyDinosCommonConfig.SEPSIS.get()) {
            turnIntoSepsisTick++;
        }

        if (!entity.level().isClientSide) {
            if (entity.hasEffect(DDDEffects.AEROMONAS.get())) {
                int amp = entity.getEffect(DDDEffects.AEROMONAS.get()).getAmplifier();
                int duration = entity.getEffect(DDDEffects.AEROMONAS.get()).getDuration();
                entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, amp + 1, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, duration, amp + 1, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, duration, amp, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, amp, false, false));

                if (amp > 1) {
                    entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, duration, amp, false, false));
                }

                if (turnIntoSepsisTick >= DeadlyDinosCommonConfig.SEPSIS_TIME.get() && DeadlyDinosCommonConfig.SEPSIS.get()) { //you are now fucked
                    entity.addEffect(new MobEffectInstance (DDDEffects.SEPSIS.get(), MobEffectInstance.INFINITE_DURATION, 1, true, false));
                    entity.removeEffect(DDDEffects.AEROMONAS.get());
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}