package com.dragn0007.deadlydinos.items.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class TrophyItem extends Item {

    public MobEffectInstance[] effectInstances;

    public TrophyItem(MobEffectInstance... effectInstances) {
        super(new Properties().stacksTo(1).durability(10));
        this.effectInstances = effectInstances;
    }

    @Override
    public Rarity getRarity(ItemStack p_41461_) {
        return Rarity.EPIC;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.ARMOR_EQUIP_GENERIC;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.ARMOR_EQUIP_GENERIC;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 16;
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerEntity, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, playerEntity, hand);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide) {
            for (int i = 0; i < effectInstances.length; i++) {
                pLivingEntity.addEffect(effectInstances[i]);
            }
            pLivingEntity.getItemInHand(InteractionHand.MAIN_HAND).shrink(0);
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);

    }

    @Override
    public void appendHoverText(ItemStack itemStack, Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(itemStack, level, tooltip, flag);

        for (MobEffectInstance effectInstance : effectInstances) {
            String effectName = effectInstance.getEffect().getDisplayName().getString();
            String amplifier = String.format(" Level %d", effectInstance.getAmplifier() + 1);
            String text = effectName + amplifier;

            tooltip.add(Component.translatable(text).withStyle(ChatFormatting.GOLD));
        }
    }
}

