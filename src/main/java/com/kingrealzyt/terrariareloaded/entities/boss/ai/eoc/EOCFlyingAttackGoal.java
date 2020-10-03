package com.kingrealzyt.terrariareloaded.entities.boss.ai.eoc;

import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.EnumSet;

public class EOCFlyingAttackGoal extends TargetGoal {

    public static final double TARGET_DISTANCE = 256;

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
    public void tick() {
        PlayerEntity playerEntity = (PlayerEntity) this.goalOwner.getAttackTarget();
        assert playerEntity != null;
        double distance = this.goalOwner.getDistanceSq(playerEntity.getPosX(), playerEntity.getPosY(), playerEntity.getPosZ());
        Path path = this.goalOwner.getNavigator().getPathToEntity(playerEntity, 0);
        this.goalOwner.getNavigator().setPath(path, this.goalOwner.getAttribute(SharedMonsterAttributes.FLYING_SPEED).getBaseValue());
        this.checkAndPerformAttack(playerEntity, distance);
    }

    @Override
    public void startExecuting() {
        this.goalOwner.setAttackTarget(this.nearestTarget);
        //((EOCEntity) this.goalOwner).setFlyingAttack(true);
        super.startExecuting();
    }

    private void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
        double attackReachSqr = this.getAttackReachSqr(enemy);
        if (distToEnemySqr <= attackReachSqr) {
            this.goalOwner.attackEntityAsMob(enemy);
            System.out.println("ATTACK");
        }

    }

    private double getAttackReachSqr(LivingEntity attackTarget) {
        return (this.goalOwner.getWidth() * 2.0F * this.goalOwner.getWidth() * 2.0F + attackTarget.getWidth());
    }
}
