package com.dragn0007.deadlydinos.items.custom;

import com.dragn0007.deadlydinos.effects.DDDEffects;
import com.dragn0007.deadlydinos.util.DeadlyDinosCommonConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

public class GauzeItem extends Item {

    public GauzeItem(Properties properties) {
        super(properties);
    }

    Random random = new Random();

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        if (!level.isClientSide && random.nextDouble() <= DeadlyDinosCommonConfig.GAUZE_SUCCESS_CHANCE.get()) {
            if (entity.hasEffect(DDDEffects.BLEEDING.get())) {
                int amp = entity.getEffect(DDDEffects.BLEEDING.get()).getAmplifier();
                int duration = entity.getEffect(DDDEffects.BLEEDING.get()).getDuration();
                entity.removeEffect(DDDEffects.BLEEDING.get());
                if (amp > 0) {
                    entity.addEffect(new MobEffectInstance(DDDEffects.BLEEDING.get(), duration, amp - 1, false, true));
                    if (entity instanceof Player player) {
                        player.displayClientMessage(Component.translatable("tooltip.deadlydinos.bleed_slowed.tooltip").withStyle(ChatFormatting.WHITE), true);
                    }
                } else {
                    if (entity instanceof Player player) {
                        player.displayClientMessage(Component.translatable("tooltip.deadlydinos.bleed_stopped.tooltip").withStyle(ChatFormatting.GOLD), true);
                    }
                }
            } else {
                if (entity instanceof Player player) {
                    player.displayClientMessage(Component.translatable("tooltip.deadlydinos.no_ailment.tooltip").withStyle(ChatFormatting.YELLOW), true);
                }
            }
        } else {
            if (entity instanceof Player player) {
                player.displayClientMessage(Component.translatable("tooltip.deadlydinos.gauze_failed.tooltip").withStyle(ChatFormatting.DARK_RED), true);
            }
        }

        if (entity instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, itemStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (entity instanceof Player && !((Player)entity).getAbilities().instabuild) {
            itemStack.shrink(1);
        }

        return super.finishUsingItem(itemStack, level, entity);
    }

    public int getUseDuration(ItemStack p_42933_) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack p_42931_) {
        return UseAnim.BRUSH;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemUtils.startUsingInstantly(level, player, hand);
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        String cureChanceText = "Unknown";
        if (DeadlyDinosCommonConfig.GAUZE_SUCCESS_CHANCE.get() <= 0.25) {
            cureChanceText = "Low";
        } else if (DeadlyDinosCommonConfig.GAUZE_SUCCESS_CHANCE.get() > 0.25 && DeadlyDinosCommonConfig.GAUZE_SUCCESS_CHANCE.get() <= 0.75) {
            cureChanceText = "Average";
        } else if (DeadlyDinosCommonConfig.GAUZE_SUCCESS_CHANCE.get() > 0.75 && DeadlyDinosCommonConfig.GAUZE_SUCCESS_CHANCE.get() <= 1.0) {
            cureChanceText = "High";
        }
        pTooltipComponents.add(Component.translatable(cureChanceText + " chance of success at stopping or slowing bleeding.").withStyle(ChatFormatting.GRAY));
    }
}
