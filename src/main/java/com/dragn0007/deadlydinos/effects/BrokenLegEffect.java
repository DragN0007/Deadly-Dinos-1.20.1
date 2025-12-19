package com.dragn0007.deadlydinos.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class BrokenLegEffect extends MobEffect {
    public BrokenLegEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {
            if (!entity.level().isClientSide) {
                if (entity.hasEffect(DDDEffects.BROKEN_LEG.get())) {
                    int amp = entity.getEffect(DDDEffects.BROKEN_LEG.get()).getAmplifier();
                    int duration = entity.getEffect(DDDEffects.BROKEN_LEG.get()).getDuration();
                    entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, amp + 1, false, false));
                    if (amp >= 1) {
                        entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, amp, false, false));
                    }
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
       return true;
    }
}