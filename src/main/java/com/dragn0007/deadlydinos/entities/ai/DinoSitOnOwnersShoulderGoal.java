package com.dragn0007.deadlydinos.entities.ai;

import com.dragn0007.deadlydinos.entities.AbstractTamableDino;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.goal.Goal;

public class DinoSitOnOwnersShoulderGoal extends Goal {
   private final AbstractTamableDino entity;
   private ServerPlayer owner;
   private boolean isSittingOnShoulder;

   public DinoSitOnOwnersShoulderGoal(AbstractTamableDino p_25483_) {
      this.entity = p_25483_;
   }

   public boolean canUse() {
      ServerPlayer serverplayer = (ServerPlayer)this.entity.getOwner();
      boolean flag = serverplayer != null && !serverplayer.isSpectator() && !serverplayer.getAbilities().flying && !serverplayer.isInWater() && !serverplayer.isInPowderSnow;
      return !this.entity.isOrderedToSit() && flag && this.entity.canSitOnShoulder();
   }

   public boolean isInterruptable() {
      return !this.isSittingOnShoulder;
   }

   public void start() {
      this.owner = (ServerPlayer)this.entity.getOwner();
      this.isSittingOnShoulder = false;
   }

   public void tick() {
      if (!this.isSittingOnShoulder && !this.entity.isInSittingPose() && !this.entity.isLeashed()) {
         if (this.entity.getBoundingBox().intersects(this.owner.getBoundingBox())) {
            this.isSittingOnShoulder = this.entity.setEntityOnShoulder(this.owner);
         }

      }
   }
}