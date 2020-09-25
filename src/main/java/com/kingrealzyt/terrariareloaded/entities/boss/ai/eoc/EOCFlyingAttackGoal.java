package com.kingrealzyt.terrariareloaded.entities.boss.ai.eoc;

import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.EnumSet;

public class EOCFlyingAttackGoal extends TargetGoal {

    public static final double TARGET_DISTANCE = 200;

    private PlayerEntity nearestTarget;
    private final EntityPredicate targetSelector;

    public EOCFlyingAttackGoal(EOCEntity eoc) {
        super(eoc, true);
        this.setMutexFlags(EnumSet.of(Flag.TARGET));
        this.targetSelector = new EntityPredicate().setDistance(this.getTargetDistance());
    }

    @Override
    public boolean shouldExecute() {
        this.findNearestTarget();
        return this.nearestTarget != null;
    }

    private void findNearestTarget() {
        this.nearestTarget = this.goalOwner.world.getClosestPlayer(this.targetSelector, this.goalOwner, this.goalOwner.getPosX(), this.goalOwner.getPosYEye(), this.goalOwner.getPosZ());
    }

    private AxisAlignedBB getTargetableArea() {
        return this.goalOwner.getBoundingBox().grow(TARGET_DISTANCE, 4.0D, TARGET_DISTANCE);
    }

    @Override
    public void startExecuting() {
        this.goalOwner.setAttackTarget(this.nearestTarget);
        ((EOCEntity) this.goalOwner).setFlyingAttack(true);
        super.startExecuting();
    }
}
