package com.dragn0007.deadlydinos.mixin;

import com.dragn0007.deadlydinos.util.DeadlyDinosCommonConfig;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MilkBucketItem.class)
public abstract class MilkBucketItemMixin {

    @Inject(method = "finishUsingItem", at = @At("HEAD"), cancellable = true)
    private void disableMilkEffectCuration(ItemStack itemStack, Level level, LivingEntity entity, CallbackInfoReturnable<ItemStack> cir) {
        if (DeadlyDinosCommonConfig.MILK_CURE.get()) {
            return;
        }
        if (!level.isClientSide) {
            entity.gameEvent(GameEvent.DRINK);
        }
        if (entity instanceof Player player) {
            player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
        }
        cir.setReturnValue(itemStack);
    }
}
