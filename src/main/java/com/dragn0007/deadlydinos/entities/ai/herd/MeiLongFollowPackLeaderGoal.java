package com.dragn0007.deadlydinos.entities.ai.herd;

import com.dragn0007.deadlydinos.entities.mei_long.MeiLong;
import com.mojang.datafixers.DataFixUtils;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.List;
import java.util.function.Predicate;

public class MeiLongFollowPackLeaderGoal extends Goal {
   public final MeiLong mob;
   public int timeToRecalcPath;
   public int nextStartTick;

   public MeiLongFollowPackLeaderGoal(MeiLong p_25249_) {
      this.mob = p_25249_;
      this.nextStartTick = this.nextStartTick(p_25249_);
   }

   public int nextStartTick(MeiLong mob) {
      return reducedTickDelay(200 + mob.getRandom().nextInt(200) % 20);
   }

   public boolean canUse() {
      if (this.mob.hasFollowers()) {
         return false;
      } else if (this.mob.isFollower()) {
         return true;
      } else if (mob.isOrderedToSit() || mob.isInSittingPose()) {
         return false;
      } else if (this.nextStartTick > 0) {
         --this.nextStartTick;
         return false;
      } else {
         this.nextStartTick = this.nextStartTick(this.mob);
         Predicate<MeiLong> predicate = (follower) -> {
            return follower.canBeFollowed() || !follower.isFollower();
         };
         List<? extends MeiLong> list = this.mob.level().getEntitiesOfClass(this.mob.getClass(), this.mob.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), predicate);
         MeiLong MeiLong = DataFixUtils.orElse(list.stream().filter(com.dragn0007.deadlydinos.entities.mei_long.MeiLong::canBeFollowed).findAny(), this.mob);
         MeiLong.addFollowers(list.stream().filter((mob) -> {
            return !mob.isFollower();
         }));
         return this.mob.isFollower();
      }
   }

   public boolean canContinueToUse() {
      return this.mob.isFollower() && this.mob.inRangeOfLeader();
   }

   public void start() {
      this.timeToRecalcPath = 0;
   }

   public void stop() {
      this.mob.stopFollowing();
   }

   public void tick() {
      if (--this.timeToRecalcPath <= 0) {
         this.timeToRecalcPath = this.adjustedTickDelay(10);

         MeiLong leader = this.mob.leader;
         if (leader != null) {
            double distanceSq = this.mob.distanceToSqr(leader);
            double minDistanceSq = 4.0D * 4.0D;

            if (distanceSq > minDistanceSq) {
               this.mob.pathToLeader();
            } else {
               this.mob.getNavigation().stop();
            }
         }
      }
   }
}