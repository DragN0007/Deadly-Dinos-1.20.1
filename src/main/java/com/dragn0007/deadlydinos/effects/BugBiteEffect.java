package com.dragn0007.deadlydinos.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class BugBiteEffect extends MobEffect {
    public BugBiteEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {
            entity.hurt(entity.damageSources().generic(), 0.1F);

            if (entity.hasEffect(DDDEffects.BUG_BITE.get())) {
                int amp = entity.getEffect(DDDEffects.BUG_BITE.get()).getAmplifier();
                int duration = entity.getEffect(DDDEffects.BUG_BITE.get()).getDuration();
                entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, duration, amp, false, false));
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 200 == 0;
    }
}