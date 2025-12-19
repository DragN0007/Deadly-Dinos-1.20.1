package com.dragn0007.deadlydinos.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class SepsisEffect extends MobEffect {
    public SepsisEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {

        if (!entity.level().isClientSide) {
            if (entity.hasEffect(DDDEffects.SEPSIS.get())) {
                int amp = entity.getEffect(DDDEffects.SEPSIS.get()).getAmplifier();
                int duration = entity.getEffect(DDDEffects.SEPSIS.get()).getDuration();
                entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, amp + 1, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, duration, amp + 1, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, duration, amp + 1, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, amp + 1, false, false));
                entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, duration, amp + 1, false, false));

                float damage;
                if (amplifier > 0) {
                    damage = 1F * amplifier;
                } else {
                    damage = 1F;
                }
                entity.hurt(entity.damageSources().generic(), damage);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 40 == 0;
    }
}