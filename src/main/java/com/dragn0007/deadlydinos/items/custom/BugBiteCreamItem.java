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
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class BugBiteCreamItem extends Item {

    public BugBiteCreamItem(Properties properties) {
        super(properties);
    }

    Random random = new Random();

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        if (DeadlyDinosCommonConfig.MEDICAL_SUPPLIES.get()) {
            if (!level.isClientSide && entity.hasEffect(DDDEffects.BUG_BITE.get())) {
                if (random.nextDouble() <= DeadlyDinosCommonConfig.BUG_CREAM_SUCCESS_CHANCE.get()) {
                    int duration = entity.getEffect(DDDEffects.BUG_BITE.get()).getDuration();
                    entity.removeEffect(DDDEffects.BUG_BITE.get());

                    if (entity.hasEffect(MobEffects.UNLUCK) && entity.getEffect(MobEffects.UNLUCK).getDuration() == duration) {
                        entity.removeEffect(MobEffects.UNLUCK);
                    }
                    if (entity instanceof Player player) {
                        player.displayClientMessage(Component.translatable("tooltip.deadlydinos.cured.tooltip").withStyle(ChatFormatting.GOLD), true);
                    }
                } else {
                    if (entity instanceof Player player) {
                        player.displayClientMessage(Component.translatable("tooltip.deadlydinos.not_cured.tooltip").withStyle(ChatFormatting.DARK_RED), true);
                    }
                }
            } else {
                if (entity instanceof Player player) {
                    player.displayClientMessage(Component.translatable("tooltip.deadlydinos.no_ailment.tooltip").withStyle(ChatFormatting.YELLOW), true);
                }
            }

            if (entity instanceof ServerPlayer serverplayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, itemStack);
                serverplayer.awardStat(Stats.ITEM_USED.get(this));
            }

            if (entity instanceof Player && !((Player) entity).getAbilities().instabuild) {
                itemStack.shrink(1);
            }
        }

        return super.finishUsingItem(itemStack, level, entity);
    }

    public int getUseDuration(ItemStack p_42933_) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack p_42931_) {
        return UseAnim.BOW;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemUtils.startUsingInstantly(level, player, hand);
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        String cureChanceText = "Unknown";
        if (DeadlyDinosCommonConfig.BUG_CREAM_SUCCESS_CHANCE.get() <= 0.0) {
            cureChanceText = "No";
        } else if (DeadlyDinosCommonConfig.BUG_CREAM_SUCCESS_CHANCE.get() > 0.0 && DeadlyDinosCommonConfig.BUG_CREAM_SUCCESS_CHANCE.get() <= 0.25) {
            cureChanceText = "Low";
        } else if (DeadlyDinosCommonConfig.BUG_CREAM_SUCCESS_CHANCE.get() > 0.25 && DeadlyDinosCommonConfig.BUG_CREAM_SUCCESS_CHANCE.get() <= 0.75) {
            cureChanceText = "Average";
        } else if (DeadlyDinosCommonConfig.BUG_CREAM_SUCCESS_CHANCE.get() > 0.75 && DeadlyDinosCommonConfig.BUG_CREAM_SUCCESS_CHANCE.get() <= 1.0) {
            cureChanceText = "High";
        }
        if (DeadlyDinosCommonConfig.MEDICAL_SUPPLIES.get()) {
            pTooltipComponents.add(Component.translatable(cureChanceText + " chance of success at soothing itchy bug bites.").withStyle(ChatFormatting.GRAY));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.deadlydinos.medicals_disabled.tooltip").withStyle(ChatFormatting.GRAY));
        }
    }
}
