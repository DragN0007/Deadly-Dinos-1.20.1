package com.dragn0007.deadlydinos.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class TaeniasisEffect extends MobEffect {
    public TaeniasisEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {

        if (!entity.level().isClientSide) {
            if (entity.hasEffect(DDDEffects.TAENIASIS.get())) {
                int amp = entity.getEffect(DDDEffects.TAENIASIS.get()).getAmplifier();
                int duration = entity.getEffect(DDDEffects.TAENIASIS.get()).getDuration();
                entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, amp + 1, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, duration, amp + 1, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, duration, amp, false, false));
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}