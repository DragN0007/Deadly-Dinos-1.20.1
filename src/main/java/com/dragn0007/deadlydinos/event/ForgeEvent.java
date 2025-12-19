package com.dragn0007.deadlydinos.event;

import com.dragn0007.deadlydinos.effects.DDDEffects;
import com.dragn0007.deadlydinos.util.DDDTags;
import com.dragn0007.deadlydinos.util.DeadlyDinosCommonConfig;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
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
            if (stack.is(DDDTags.Items.RAW_MEATS) && random.nextDouble() >= DeadlyDinosCommonConfig.RAW_MEAT_PARASITE_CHANCE.get()) {
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
            if (event.getSource().is(DamageTypes.FALL) && event.getAmount() > 3) {
                if (random.nextDouble() >= DeadlyDinosCommonConfig.LEG_BREAK_CHANCE.get()) {
                    if (!entity.hasEffect(DDDEffects.BROKEN_LEG.get())) {
                        entity.addEffect(new MobEffectInstance(DDDEffects.BROKEN_LEG.get(), 72000, 0, true, false, true));
                    } else {
                        int amp = entity.getEffect(DDDEffects.BROKEN_LEG.get()).getAmplifier();
                        if (amp < 3) {
                            entity.addEffect(new MobEffectInstance(DDDEffects.BROKEN_LEG.get(), 72000, amp + 1, true, false, true));
                        }
                    }
                }
            }
        }
    }
}