package com.dragn0007.deadlydinos.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class BirdFluEffect extends MobEffect {
    public BirdFluEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {
            if (entity.hasEffect(DDDEffects.BIRD_FLU.get())) {
                int amp = entity.getEffect(DDDEffects.BIRD_FLU.get()).getAmplifier();
                int duration = entity.getEffect(DDDEffects.BIRD_FLU.get()).getDuration();
                entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, amp, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, duration, amp, false, false));
                if (amp >= 1) {
                    entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, duration, amp, false, false));
                    entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, duration, 0, false, false));
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}