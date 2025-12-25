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

public class BacterialAntibioticItem extends Item {

    public BacterialAntibioticItem(Properties properties) {
        super(properties);
    }

    Random random = new Random();

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        if (DeadlyDinosCommonConfig.MEDICAL_SUPPLIES.get()) {
            if (!level.isClientSide) {
                if (random.nextDouble() <= DeadlyDinosCommonConfig.ANTI_BACTERIAL_SUCCESS_CHANCE.get()) {
                    if (entity.hasEffect(DDDEffects.AEROMONAS.get())) {
                        int duration = entity.getEffect(DDDEffects.AEROMONAS.get()).getDuration();
                        entity.removeEffect(DDDEffects.AEROMONAS.get());

                        if (entity.hasEffect(MobEffects.WEAKNESS) && entity.getEffect(MobEffects.WEAKNESS).getDuration() == duration) {
                            entity.removeEffect(MobEffects.WEAKNESS);
                        }
                        if (entity.hasEffect(MobEffects.BLINDNESS) && entity.getEffect(MobEffects.BLINDNESS).getDuration() == duration) {
                            entity.removeEffect(MobEffects.BLINDNESS);
                        }
                        if (entity.hasEffect(MobEffects.CONFUSION) && entity.getEffect(MobEffects.CONFUSION).getDuration() == duration) {
                            entity.removeEffect(MobEffects.CONFUSION);
                        }
                        if (entity.hasEffect(MobEffects.DIG_SLOWDOWN) && entity.getEffect(MobEffects.DIG_SLOWDOWN).getDuration() == duration) {
                            entity.removeEffect(MobEffects.DIG_SLOWDOWN);
                        }
                        if (entity.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) && entity.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getDuration() == duration) {
                            entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                        }

                        if (entity instanceof Player player) {
                            player.displayClientMessage(Component.translatable("tooltip.deadlydinos.cured.tooltip").withStyle(ChatFormatting.GOLD), true);
                        }
                    }

                    if (random.nextDouble() <= 0.25) {
                        if (entity.hasEffect(DDDEffects.SEPSIS.get())) {
                            int duration = entity.getEffect(DDDEffects.SEPSIS.get()).getDuration();
                            entity.removeEffect(DDDEffects.SEPSIS.get());

                            if (entity.hasEffect(MobEffects.WEAKNESS) && entity.getEffect(MobEffects.WEAKNESS).getDuration() == duration) {
                                entity.removeEffect(MobEffects.WEAKNESS);
                            }
                            if (entity.hasEffect(MobEffects.BLINDNESS) && entity.getEffect(MobEffects.BLINDNESS).getDuration() == duration) {
                                entity.removeEffect(MobEffects.BLINDNESS);
                            }
                            if (entity.hasEffect(MobEffects.CONFUSION) && entity.getEffect(MobEffects.CONFUSION).getDuration() == duration) {
                                entity.removeEffect(MobEffects.CONFUSION);
                            }
                            if (entity.hasEffect(MobEffects.DIG_SLOWDOWN) && entity.getEffect(MobEffects.DIG_SLOWDOWN).getDuration() == duration) {
                                entity.removeEffect(MobEffects.DIG_SLOWDOWN);
                            }
                            if (entity.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) && entity.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getDuration() == duration) {
                                entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                            }

                            if (entity instanceof Player player) {
                                player.displayClientMessage(Component.translatable("tooltip.deadlydinos.cured.tooltip").withStyle(ChatFormatting.GOLD), true);
                            }
                        }
                    } else {
                        if (entity instanceof Player player) {
                            player.displayClientMessage(Component.translatable("tooltip.deadlydinos.not_cured.tooltip").withStyle(ChatFormatting.DARK_RED), true);
                        }
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
        if (DeadlyDinosCommonConfig.ANTI_BACTERIAL_SUCCESS_CHANCE.get() <= 0.0) {
            cureChanceText = "No";
        } else if (DeadlyDinosCommonConfig.ANTI_BACTERIAL_SUCCESS_CHANCE.get() > 0.0 && DeadlyDinosCommonConfig.ANTI_BACTERIAL_SUCCESS_CHANCE.get() <= 0.25) {
            cureChanceText = "Low";
        } else if (DeadlyDinosCommonConfig.ANTI_BACTERIAL_SUCCESS_CHANCE.get() > 0.25 && DeadlyDinosCommonConfig.ANTI_BACTERIAL_SUCCESS_CHANCE.get() <= 0.75) {
            cureChanceText = "Average";
        } else if (DeadlyDinosCommonConfig.ANTI_BACTERIAL_SUCCESS_CHANCE.get() > 0.75 && DeadlyDinosCommonConfig.ANTI_BACTERIAL_SUCCESS_CHANCE.get() <= 1.0) {
            cureChanceText = "High";
        }

        if (DeadlyDinosCommonConfig.MEDICAL_SUPPLIES.get()) {
            pTooltipComponents.add(Component.translatable(cureChanceText + " chance of success at curing bacterial infections.").withStyle(ChatFormatting.GRAY));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.deadlydinos.medicals_disabled.tooltip").withStyle(ChatFormatting.GRAY));
        }
    }
}
