package com.dragn0007.deadlydinos.entities.ai;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.function.Predicate;

public class AnomalyNearestAttackableTargetGoal<T extends LivingEntity> extends TargetGoal {
   public static final int DEFAULT_RANDOM_INTERVAL = 10;
   public final Class<T> targetType;
   public final int randomInterval;
   @Nullable
   public LivingEntity target;
   public TargetingConditions targetConditions;

   public AnomalyNearestAttackableTargetGoal(Mob p_26060_, Class<T> p_26061_, boolean p_26062_) {
      this(p_26060_, p_26061_, 10, p_26062_, false, (Predicate<LivingEntity>)null);
   }

   public AnomalyNearestAttackableTargetGoal(Mob p_199891_, Class<T> p_199892_, boolean p_199893_, Predicate<LivingEntity> p_199894_) {
      this(p_199891_, p_199892_, 10, p_199893_, false, p_199894_);
   }

   public AnomalyNearestAttackableTargetGoal(Mob p_26064_, Class<T> p_26065_, boolean p_26066_, boolean p_26067_) {
      this(p_26064_, p_26065_, 10, p_26066_, p_26067_, (Predicate<LivingEntity>)null);
   }

   public AnomalyNearestAttackableTargetGoal(Mob p_26053_, Class<T> p_26054_, int p_26055_, boolean p_26056_, boolean p_26057_, @Nullable Predicate<LivingEntity> p_26058_) {
      super(p_26053_, p_26056_, p_26057_);
      this.targetType = p_26054_;
      this.randomInterval = reducedTickDelay(p_26055_);
      this.setFlags(EnumSet.of(Flag.TARGET));
      this.targetConditions = TargetingConditions.forCombat().range(this.getFollowDistance()).selector(p_26058_);
   }

   public boolean canUse() {
      if (this.randomInterval > 0 && this.mob.getRandom().nextInt(this.randomInterval) != 0) {
         return false;
      } else {
         this.findTarget();
         return this.target != null;
      }
   }

   public AABB getTargetSearchArea(double p_26069_) {
      return this.mob.getBoundingBox().inflate(p_26069_, 25.0D, p_26069_);
   }

   public void findTarget() {
      if (this.targetType != Player.class && this.targetType != ServerPlayer.class) {
         this.target = this.mob.level().getNearestEntity(this.mob.level().getEntitiesOfClass(this.targetType, this.getTargetSearchArea(this.getFollowDistance()), (p_148152_) -> {
            return true;
         }), this.targetConditions, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
      } else {
         this.target = this.mob.level().getNearestPlayer(this.targetConditions, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
      }

   }

   public void start() {
      this.mob.setTarget(this.target);
      super.start();
   }

   public void setTarget(@Nullable LivingEntity p_26071_) {
      this.target = p_26071_;
   }
}