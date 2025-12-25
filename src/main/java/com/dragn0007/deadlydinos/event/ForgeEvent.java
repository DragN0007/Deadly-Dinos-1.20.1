package com.dragn0007.deadlydinos.event;

import com.dragn0007.deadlydinos.effects.DDDEffects;
import com.dragn0007.deadlydinos.util.DDDTags;
import com.dragn0007.deadlydinos.util.DeadlyDinosCommonConfig;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvent {

    @SubscribeEvent
    public static void onLivingEntityUseItem(LivingEntityUseItemEvent.Finish event) {
        Random random = new Random();
        Level level = event.getEntity().level();
        LivingEntity entity = event.getEntity();
        ItemStack stack = event.getItem();

        if (!level.isClientSide) {
            if (stack.is(DDDTags.Items.RAW_MEATS) && random.nextDouble() >= DeadlyDinosCommonConfig.RAW_MEAT_PARASITE_CHANCE.get() && DeadlyDinosCommonConfig.ILLNESS_EFFECTS.get()) {
                if (!entity.hasEffect(DDDEffects.TAENIASIS.get())) {
                    entity.addEffect(new MobEffectInstance(DDDEffects.TAENIASIS.get(), MobEffectInstance.INFINITE_DURATION, 0, true, false, true));
                } else {
                    int amp = entity.getEffect(DDDEffects.TAENIASIS.get()).getAmplifier();
                    if (amp < 3) {
                        entity.addEffect(new MobEffectInstance(DDDEffects.TAENIASIS.get(), MobEffectInstance.INFINITE_DURATION, amp + 1, true, false, true));
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingEntityTakeFallDamage(LivingDamageEvent event) {
        Random random = new Random();
        Level level = event.getEntity().level();
        LivingEntity entity = event.getEntity();
        if (!level.isClientSide) {
            float damage = event.getAmount();
            if (event.getSource().is(DamageTypes.FALL) && damage > 3) {
                float heightCalc = (int) (damage - 3.0F);
                float breakChance = heightCalc * 0.2F;
                if (random.nextFloat() < breakChance) {
                    if (random.nextDouble() >= DeadlyDinosCommonConfig.LEG_BREAK_CHANCE.get() && DeadlyDinosCommonConfig.INJURY_EFFECTS.get()) {
                        if (!entity.hasEffect(DDDEffects.BROKEN_LEG.get())) {
                            entity.addEffect(new MobEffectInstance(DDDEffects.BROKEN_LEG.get(), DeadlyDinosCommonConfig.BROKEN_BONE_HEAL_TIME.get(), 0, true, false, true));
                        } else {
                            int amp = entity.getEffect(DDDEffects.BROKEN_LEG.get()).getAmplifier();
                            if (amp < 3) {
                                entity.addEffect(new MobEffectInstance(DDDEffects.BROKEN_LEG.get(), DeadlyDinosCommonConfig.BROKEN_BONE_HEAL_TIME.get(), amp + 1, true, false, true));
                            }
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerWakeAfterInjury(PlayerWakeUpEvent event) {
        Level level = event.getEntity().level();
        LivingEntity entity = event.getEntity();
        if (!level.isClientSide) {
            if (entity instanceof Player player) {
                int slept = player.getSleepTimer();
                if (entity.hasEffect(DDDEffects.CONCUSSION.get()) && slept >= 80) {
                    int amp = entity.getEffect(DDDEffects.CONCUSSION.get()).getAmplifier();
                    int duration = entity.getEffect(DDDEffects.CONCUSSION.get()).getDuration();
                    entity.removeEffect(DDDEffects.CONCUSSION.get());
                    entity.addEffect(new MobEffectInstance(DDDEffects.CONCUSSION.get(), duration - (duration / 3), amp, true, false, true));

                    if (entity.hasEffect(MobEffects.WEAKNESS) && entity.getEffect(MobEffects.WEAKNESS).getDuration() == duration) {
                        entity.removeEffect(MobEffects.WEAKNESS);
                        entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration - (duration / 3), amp, true, false, true));
                    }
                    if (entity.hasEffect(MobEffects.CONFUSION) && entity.getEffect(MobEffects.CONFUSION).getDuration() == duration) {
                        entity.removeEffect(MobEffects.CONFUSION);
                        entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, duration - (duration / 3), amp, true, false, true));
                    }
                    if (entity.hasEffect(MobEffects.UNLUCK) && entity.getEffect(MobEffects.UNLUCK).getDuration() == duration) {
                        entity.removeEffect(MobEffects.UNLUCK);
                        entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, duration - (duration / 3), amp, true, false, true));
                    }
                    if (entity.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) && entity.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getDuration() == duration) {
                        entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration - (duration / 3), amp, true, false, true));
                    }
                    if (entity.hasEffect(MobEffects.BLINDNESS) && entity.getEffect(MobEffects.BLINDNESS).getDuration() == duration) {
                        entity.removeEffect(MobEffects.BLINDNESS);
                        entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, duration - (duration / 3), amp, true, false, true));
                    }
                }
                if (entity.hasEffect(DDDEffects.BROKEN_LEG.get()) && slept >= 80) {
                    int amp = entity.getEffect(DDDEffects.BROKEN_LEG.get()).getAmplifier();
                    int duration = entity.getEffect(DDDEffects.BROKEN_LEG.get()).getDuration();
                    entity.removeEffect(DDDEffects.BROKEN_LEG.get());
                    entity.addEffect(new MobEffectInstance(DDDEffects.BROKEN_LEG.get(), duration - (duration / 4), amp, true, false, true));

                    if (entity.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) && entity.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getDuration() == duration) {
                        entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration - (duration / 4), amp, true, false, true));
                    }
                }
                if (entity.hasEffect(DDDEffects.BROKEN_ARM.get()) && slept >= 80) {
                    int amp = entity.getEffect(DDDEffects.BROKEN_ARM.get()).getAmplifier();
                    int duration = entity.getEffect(DDDEffects.BROKEN_ARM.get()).getDuration();
                    entity.removeEffect(DDDEffects.BROKEN_ARM.get());
                    entity.addEffect(new MobEffectInstance(DDDEffects.BROKEN_ARM.get(), duration - (duration / 4), amp, true, false, true));

                    if (entity.hasEffect(MobEffects.DIG_SLOWDOWN) && entity.getEffect(MobEffects.DIG_SLOWDOWN).getDuration() == duration) {
                        entity.removeEffect(MobEffects.DIG_SLOWDOWN);
                        entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, duration - (duration / 4), amp, true, false, true));
                    }
                }
            }
        }
    }
}