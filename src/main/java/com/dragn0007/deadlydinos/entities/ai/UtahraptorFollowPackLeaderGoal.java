package com.dragn0007.deadlydinos.entities.ai;

import com.dragn0007.deadlydinos.entities.utahraptor.Utahraptor;
import com.mojang.datafixers.DataFixUtils;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.List;
import java.util.function.Predicate;

public class UtahraptorFollowPackLeaderGoal extends Goal {
   public final Utahraptor mob;
   public int timeToRecalcPath;
   public int nextStartTick;

   public UtahraptorFollowPackLeaderGoal(Utahraptor p_25249_) {
      this.mob = p_25249_;
      this.nextStartTick = this.nextStartTick(p_25249_);
   }

   public int nextStartTick(Utahraptor mob) {
      return reducedTickDelay(200 + mob.getRandom().nextInt(200) % 20);
   }

   public boolean canUse() {
      if (this.mob.hasFollowers()) {
         return false;
      } else if (this.mob.isFollower()) {
         return true;
      } else if (this.nextStartTick > 0) {
         --this.nextStartTick;
         return false;
      } else {
         this.nextStartTick = this.nextStartTick(this.mob);
         Predicate<Utahraptor> predicate = (follower) -> {
            return follower.canBeFollowed() || !follower.isFollower();
         };
         List<? extends Utahraptor> list = this.mob.level().getEntitiesOfClass(this.mob.getClass(), this.mob.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), predicate);
         Utahraptor Utahraptor = DataFixUtils.orElse(list.stream().filter(com.dragn0007.deadlydinos.entities.utahraptor.Utahraptor::canBeFollowed).findAny(), this.mob);
         Utahraptor.addFollowers(list.stream().filter((mob) -> {
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
         this.mob.pathToLeader();
      }
   }
}