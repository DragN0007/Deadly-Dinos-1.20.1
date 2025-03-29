package com.dragn0007.deadlydinos.entities.ai;

import java.util.EnumSet;

import com.dragn0007.deadlydinos.entities.util.AbstractDino;
import com.dragn0007.deadlydinos.entities.util.AbstractDinoMount;
import com.dragn0007.deadlydinos.util.DeadlyDinosCommonConfig;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;

public class GroundTieGoal extends Goal {
    private final AbstractDinoMount mob;

    public GroundTieGoal(AbstractDinoMount oMount) {
        this.mob = oMount;
        this.setFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
    }

    public boolean canContinueToUse() {
        return this.mob.isSaddled() && !this.mob.isVehicle() && (Boolean) DeadlyDinosCommonConfig.GROUND_TIE.get() || this.mob.isLeashed();
    }

    public boolean canUse() {
        if (!(Boolean)DeadlyDinosCommonConfig.GROUND_TIE.get()) {
            return false;
        } else if (this.mob.isInWaterOrBubble()) {
            return false;
        } else if (!this.mob.onGround()) {
            return false;
        } else {
            return this.mob.isSaddled() && !this.mob.isVehicle() && (Boolean)DeadlyDinosCommonConfig.GROUND_TIE.get() || this.mob.isLeashed();
        }
    }

    public void start() {
        this.mob.getNavigation().stop();
    }

    public void stop() {
    }
}
