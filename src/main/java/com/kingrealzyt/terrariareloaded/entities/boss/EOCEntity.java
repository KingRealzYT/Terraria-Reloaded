package com.kingrealzyt.terrariareloaded.entities.boss;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

import java.util.EnumSet;

public class EOCEntity extends FlyingEntity implements IMob {

    public EOCEntity(EntityType<? extends EOCEntity> type, World worldIn) {
        super(type, worldIn);
        this.moveController = new EOCEntity.MoveHelperController(this);
    }

    private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.NOTCHED_12)).setDarkenSky(true);

    @Override
    protected void registerGoals() {
        super.registerGoals();
        //this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
        //this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp());
        this.goalSelector.addGoal(5, new EOCEntity.RandomFlyGoal(this));
        this.goalSelector.addGoal(7, new EOCEntity.LookAroundGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.9D);
    }

    static class MoveHelperController extends MovementController {
        private final EOCEntity parentEntity;
        private int courseChangeCooldown;

        public MoveHelperController(EOCEntity eoc) {
            super(eoc);
            this.parentEntity = eoc;
        }

        public void tick() {
            if (this.action == MovementController.Action.MOVE_TO) {
                if (this.courseChangeCooldown-- <= 0) {
                    this.courseChangeCooldown += this.parentEntity.getRNG().nextInt(5) + 2;
                    Vec3d vec3d = new Vec3d(this.posX - this.parentEntity.getPosX(), this.posY - this.parentEntity.getPosY(), this.posZ - this.parentEntity.getPosZ());
                    double d0 = vec3d.length();
                    vec3d = vec3d.normalize();
                    if (this.func_220673_a(vec3d, MathHelper.ceil(d0))) {
                        this.parentEntity.setMotion(this.parentEntity.getMotion().add(vec3d.scale(0.1D)));
                    } else {
                        this.action = MovementController.Action.WAIT;
                    }
                }

            }
        }

        private boolean func_220673_a(Vec3d p_220673_1_, int p_220673_2_) {
            AxisAlignedBB axisalignedbb = this.parentEntity.getBoundingBox();

            for (int i = 1; i < p_220673_2_; ++i) {
                axisalignedbb = axisalignedbb.offset(p_220673_1_);
                if (!this.parentEntity.world.hasNoCollisions(this.parentEntity, axisalignedbb)) {
                    return false;
                }
            }

            return true;
        }

    }

    @Override
    public void tick() {
        super.tick();
    }


    static class LookAroundGoal extends Goal {
        private final EOCEntity parentEntity;

        public LookAroundGoal(EOCEntity eoc) {
            this.parentEntity = eoc;
            this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
        }
        @Override
        public boolean shouldExecute() {
            return true;
        }

    }
    static class RandomFlyGoal extends Goal {
        private final EOCEntity eocEntity;

        public RandomFlyGoal(EOCEntity eoc) {
            this.eocEntity = eoc;
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean shouldExecute() {
            return true;
        }
    }

    public void addTrackingPlayer(ServerPlayerEntity player) {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void removeTrackingPlayer(ServerPlayerEntity player) {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    public boolean isNonBoss() {
        return false;
    }

}

