package com.kingrealzyt.terrariareloaded.entities.boss.ai.eoc;

import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;
import java.util.Random;

public class EOCRandomFlyGoal extends Goal {

    private final EOCEntity eoc;

    public EOCRandomFlyGoal(EOCEntity eoc) {
        this.eoc = eoc;
        this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    public boolean shouldExecute() {
        MovementController movementcontroller = this.eoc.getMoveHelper();
        if (!movementcontroller.isUpdating()) {
            return true;
        } else {
            double d0 = movementcontroller.getX() - this.eoc.getPosX();
            double d1 = movementcontroller.getY() - this.eoc.getPosY();
            double d2 = movementcontroller.getZ() - this.eoc.getPosZ();
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
            return d3 < 1.0D || d3 > 3600.0D;
        }
    }


    public boolean shouldContinueExecuting() {
        return false;
    }

    public void startExecuting() {
        Random random = this.eoc.getRNG();
        double d0 = this.eoc.getPosX() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
        double d1 = this.eoc.getPosY() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
        double d2 = this.eoc.getPosZ() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
        this.eoc.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
    }

}
