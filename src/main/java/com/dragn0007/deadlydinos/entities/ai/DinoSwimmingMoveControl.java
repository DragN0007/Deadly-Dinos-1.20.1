package com.dragn0007.deadlydinos.entities.ai;

import com.dragn0007.deadlydinos.entities.AbstractDino;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.phys.Vec3;

public class DinoSwimmingMoveControl extends MoveControl {
    private final AbstractDino entity;

    public DinoSwimmingMoveControl(AbstractDino entity) {
        super(entity);
        this.entity = entity;
    }

    @Override
    public void tick() {
        if (this.entity.isInWater()) {
            this.entity.setNoGravity(true);
        } else {
            this.entity.setNoGravity(false);
        }

        if (this.operation == MoveControl.Operation.MOVE_TO && !this.entity.getNavigation().isDone()) {
            double d0 = this.wantedX - this.entity.getX();
            double d1 = this.wantedY - this.entity.getY();
            double d2 = this.wantedZ - this.entity.getZ();
            double distanceSq = d0 * d0 + d1 * d1 + d2 * d2;

            if (distanceSq < 1.0E-7D) {
                this.entity.setSpeed(0.0F);
                return;
            }

            float baseSpeed = (float)(this.speedModifier * this.entity.getAttributeValue(Attributes.MOVEMENT_SPEED));
            this.entity.setSpeed(Mth.lerp(0.125F, this.entity.getSpeed(), baseSpeed));
            float targetYaw = (float)(Mth.atan2(d2, d0) * (180F / (float)Math.PI)) - 90.0F;
            this.entity.setYRot(this.rotlerp(this.entity.getYRot(), targetYaw, 90.0F));
            this.entity.yBodyRot = this.entity.getYRot();

            if (this.entity.isInWater()) {
                double distanceXZ = Math.sqrt(d0 * d0 + d2 * d2);
                float speedMultiplier = 0.2F;

                double moveX = (d0 / distanceXZ) * (double)this.entity.getSpeed() * speedMultiplier;
                double moveZ = (d2 / distanceXZ) * (double)this.entity.getSpeed() * speedMultiplier;

                double distanceTotal = Math.sqrt(distanceSq);
                double moveY = (d1 / distanceTotal) * (double)this.entity.getSpeed() * speedMultiplier;

                this.entity.setDeltaMovement(new Vec3(moveX, moveY, moveZ));
            }
        } else {
            this.entity.setSpeed(0.0F);
            if (this.entity.isInWater()) {
                this.entity.setDeltaMovement(this.entity.getDeltaMovement().multiply(0.8D, 0.8D, 0.8D));
            }
        }
    }
}