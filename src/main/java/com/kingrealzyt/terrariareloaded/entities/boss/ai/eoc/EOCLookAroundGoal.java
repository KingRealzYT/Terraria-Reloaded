package com.kingrealzyt.terrariareloaded.entities.boss.ai.eoc;

import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.EnumSet;

public class EOCLookAroundGoal extends Goal {

    private final EOCEntity eoc;

    public EOCLookAroundGoal(EOCEntity eoc) {
        this.eoc = eoc;
        this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
    }

    public boolean shouldExecute() {
        return true;
    }


    public void tick() {
        if (this.eoc.getAttackTarget() == null) {
            Vec3d vec3d = this.eoc.getMotion();
            this.eoc.rotationYaw = -((float) MathHelper.atan2(vec3d.x, vec3d.z)) * (180F / (float) Math.PI);
            this.eoc.renderYawOffset = this.eoc.rotationYaw;
        } else {
            LivingEntity livingentity = this.eoc.getAttackTarget();
            double d0 = 64.0D;
            if (livingentity.getDistanceSq(this.eoc) < 4096.0D) {
                double d1 = livingentity.getPosX() - this.eoc.getPosX();
                double d2 = livingentity.getPosZ() - this.eoc.getPosZ();
                this.eoc.rotationYaw = -((float) MathHelper.atan2(d1, d2)) * (180F / (float) Math.PI);
                this.eoc.renderYawOffset = this.eoc.rotationYaw;
            }
        }

    }

}
