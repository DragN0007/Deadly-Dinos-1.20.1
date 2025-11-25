package com.dragn0007.deadlydinos.entities.ai;

import com.dragn0007.deadlydinos.entities.AbstractDinoMount;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

import java.util.EnumSet;

public class DinoOwnerHurtByTargetGoal extends TargetGoal {
   public final AbstractDinoMount tameAnimal;
   public LivingEntity ownerLastHurtBy;
   public int timestamp;

   public DinoOwnerHurtByTargetGoal(AbstractDinoMount p_26107_) {
      super(p_26107_, false);
      this.tameAnimal = p_26107_;
      this.setFlags(EnumSet.of(Goal.Flag.TARGET));
   }

   public boolean canUse() {
      if (this.tameAnimal.isTamed()) {
         LivingEntity livingentity = this.tameAnimal.getOwner();
         if (livingentity == null) {
            return false;
         } else {
            this.ownerLastHurtBy = livingentity.getLastHurtByMob();
            int i = livingentity.getLastHurtByMobTimestamp();
            return i != this.timestamp && this.canAttack(this.ownerLastHurtBy, TargetingConditions.DEFAULT) && this.tameAnimal.wantsToAttack(this.ownerLastHurtBy, livingentity);
         }
      } else {
         return false;
      }
   }

   public void start() {
      this.mob.setTarget(this.ownerLastHurtBy);
      LivingEntity livingentity = this.tameAnimal.getOwner();
      if (livingentity != null) {
         this.timestamp = livingentity.getLastHurtByMobTimestamp();
      }

      super.start();
   }
}