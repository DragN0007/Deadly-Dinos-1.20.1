package com.dragn0007.deadlydinos.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BirdFluEffect extends MobEffect {
    public BirdFluEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {
            if (!entity.isSprinting()) {
                float damage;
                if (amplifier > 0) {
                    damage = 1F * amplifier;
                } else {
                    damage = 1F;
                }
                entity.hurt(entity.damageSources().generic(), damage);
            } else if (entity.isSprinting()) {
                float damage;
                if (amplifier > 0) {
                    damage = 2F * amplifier;
                } else {
                    damage = 2F;
                }
                entity.hurt(entity.damageSources().generic(), damage);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        if (amplifier > 0) {
            return duration % (60 / amplifier) == 0;
        } else {
            return duration % 40 == 0;
        }
    }
}