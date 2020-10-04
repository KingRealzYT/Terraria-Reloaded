package com.kingrealzyt.terrariareloaded.entities.boss;

import com.kingrealzyt.terrariareloaded.init.SoundInit;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

import javax.annotation.Nullable;
import java.util.EnumSet;

@SuppressWarnings("all")
public class EOC2Entity extends MonsterEntity {
    protected static final DataParameter<Byte> EOC_FLAGS = EntityDataManager.createKey(EOC2Entity.class, DataSerializers.BYTE);
    private MobEntity owner;
    @Nullable
    private BlockPos boundOrigin;
    private boolean limitedLifespan;
    private int limitedLifeTicks;

    private static final double ALTITUDE_FLYING_THRESHOLD = 2;
    private static final double MAX_HEALTH = 400.0D;
    private static final double MOVEMENT_SPEED_FLYING = 0.7D;
    private static final double FOLLOW_RANGE = 256.0D;
    private static final double KNOCKBACK_RESISTANCE = 0.9F;
    private static final double ATTACK_DAMAGE = 0.5; //TODO change it later
    //If more players fighting against the eoc, then is this the chance, when the eoc switching the attacker
    private static final double ATTACKER_SWITCHING_CHANCE = 0.3D;
    private static final double MIN_ATTACK_RANGE = 0;
    private static final double MAX_ATTACK_RANGE = 4096.0 * 2.0;

    private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

    public EOC2Entity(EntityType<? extends EOC2Entity> p_i50190_1_, World p_i50190_2_) {
        super(p_i50190_1_, p_i50190_2_);
        this.moveController = new EOC2Entity.MoveHelperController(this);
        this.experienceValue = 3;
    }

    public void move(MoverType typeIn, Vec3d pos) {
        super.move(typeIn, pos);
        this.doBlockCollisions();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        this.noClip = true;
        super.tick();
        this.noClip = false;
        this.setNoGravity(true);
        if (this.limitedLifespan && --this.limitedLifeTicks <= 0) {
            this.limitedLifeTicks = 20;
            this.attackEntityFrom(DamageSource.STARVE, 0.0F);
        }
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(4, new EOC2Entity.ChargeAttackGoal());
        this.goalSelector.addGoal(8, new EOC2Entity.MoveRandomGoal());
        this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400.0D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(MOVEMENT_SPEED_FLYING);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(FOLLOW_RANGE);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(MOVEMENT_SPEED_FLYING);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(EOC_FLAGS, (byte)0);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains("BoundX")) {
            this.boundOrigin = new BlockPos(compound.getInt("BoundX"), compound.getInt("BoundY"), compound.getInt("BoundZ"));
        }

        if (compound.contains("LifeTicks")) {
            this.setLimitedLife(compound.getInt("LifeTicks"));
        }

    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        if (this.boundOrigin != null) {
            compound.putInt("BoundX", this.boundOrigin.getX());
            compound.putInt("BoundY", this.boundOrigin.getY());
            compound.putInt("BoundZ", this.boundOrigin.getZ());
        }

        if (this.limitedLifespan) {
            compound.putInt("LifeTicks", this.limitedLifeTicks);
        }

    }


    public MobEntity getOwner() {
        return this.owner;
    }

    @Nullable
    public BlockPos getBoundOrigin() {
        return this.boundOrigin;
    }

    public void setBoundOrigin(@Nullable BlockPos boundOriginIn) {
        this.boundOrigin = null;
    }

    private boolean getEOCFlag(int mask) {
        int i = this.dataManager.get(EOC_FLAGS);
        return (i & mask) != 0;
    }

    private void setEOCFlag(int mask, boolean value) {
        int i = this.dataManager.get(EOC_FLAGS);
        if (value) {
            i = i | mask;
        } else {
            i = i & ~mask;
        }

        this.dataManager.set(EOC_FLAGS, (byte)(i & 255));
    }

    public boolean isCharging() {
        return this.getEOCFlag(1);
    }

    public void setCharging(boolean charging) {
        this.setEOCFlag(1, charging);
    }

    public void setOwner(MobEntity ownerIn) {
        this.owner = ownerIn;
    }

    public void setLimitedLife(int limitedLifeTicksIn) {
        this.limitedLifespan = false;
        this.limitedLifeTicks = limitedLifeTicksIn;
    }

    @Override
    public void livingTick() {
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
        super.livingTick();
    }


    /**
     * Gets how bright this entity is.
     */
    public float getBrightness() {
        return 1.0F;
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    @Override
    public boolean isNonBoss() {
        return false;
    }

    class ChargeAttackGoal extends Goal {
        public ChargeAttackGoal() {
            this.setMutexFlags(EnumSet.of(Flag.MOVE));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            if (EOC2Entity.this.getAttackTarget() != null && !EOC2Entity.this.getMoveHelper().isUpdating() && EOC2Entity.this.rand.nextInt(7) == 0) {
                return EOC2Entity.this.getDistanceSq(EOC2Entity.this.getAttackTarget()) > 4.0D;
            } else {
                return false;
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            return EOC2Entity.this.getMoveHelper().isUpdating() && EOC2Entity.this.isCharging() && EOC2Entity.this.getAttackTarget() != null && EOC2Entity.this.getAttackTarget().isAlive();
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            LivingEntity livingentity = EOC2Entity.this.getAttackTarget();
            Vec3d vec3d = livingentity.getEyePosition(1.0F);
            EOC2Entity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 2.0D);
            EOC2Entity.this.setCharging(true);
            EOC2Entity.this.playSound(SoundInit.ENTITYBOSSROAR.get(), 1.0F, 1.0F);
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            EOC2Entity.this.setCharging(false);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            LivingEntity livingentity = EOC2Entity.this.getAttackTarget();
            if (EOC2Entity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                EOC2Entity.this.attackEntityAsMob(livingentity);
                EOC2Entity.this.setCharging(false);
            } else {
                double d0 = EOC2Entity.this.getDistanceSq(livingentity);
                if (d0 < 9.0D) {
                    Vec3d vec3d = livingentity.getEyePosition(1.0F);
                    EOC2Entity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 2.0D);
                }
            }

        }
    }

    class CopyOwnerTargetGoal extends TargetGoal {
        private final EntityPredicate field_220803_b = (new EntityPredicate()).setLineOfSiteRequired().setUseInvisibilityCheck();

        public CopyOwnerTargetGoal(CreatureEntity creature) {
            super(creature, false);
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return EOC2Entity.this.owner != null && EOC2Entity.this.owner.getAttackTarget() != null && this.isSuitableTarget(EOC2Entity.this.owner.getAttackTarget(), this.field_220803_b);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            EOC2Entity.this.setAttackTarget(EOC2Entity.this.owner.getAttackTarget());
            super.startExecuting();
        }
    }

    class MoveHelperController extends MovementController {
        public MoveHelperController(EOC2Entity vex) {
            super(vex);
        }

        public void tick() {
            if (this.action == Action.MOVE_TO) {
                Vec3d vec3d = new Vec3d(this.posX - EOC2Entity.this.getPosX(), this.posY - EOC2Entity.this.getPosY(), this.posZ - EOC2Entity.this.getPosZ());
                double d0 = vec3d.length();
                if (d0 < EOC2Entity.this.getBoundingBox().getAverageEdgeLength()) {
                    this.action = Action.WAIT;
                    EOC2Entity.this.setMotion(EOC2Entity.this.getMotion().scale(0.5D));
                } else {
                    EOC2Entity.this.setMotion(EOC2Entity.this.getMotion().add(vec3d.scale(this.speed * 0.05D / d0)));
                    if (EOC2Entity.this.getAttackTarget() == null) {
                        Vec3d vec3d1 = EOC2Entity.this.getMotion();
                        EOC2Entity.this.rotationYaw = -((float)MathHelper.atan2(vec3d1.x, vec3d1.z)) * (180F / (float)Math.PI);
                        EOC2Entity.this.renderYawOffset = EOC2Entity.this.rotationYaw;
                    } else {
                        double d2 = EOC2Entity.this.getAttackTarget().getPosX() - EOC2Entity.this.getPosX();
                        double d1 = EOC2Entity.this.getAttackTarget().getPosZ() - EOC2Entity.this.getPosZ();
                        EOC2Entity.this.rotationYaw = -((float)MathHelper.atan2(d2, d1)) * (180F / (float)Math.PI);
                        EOC2Entity.this.renderYawOffset = EOC2Entity.this.rotationYaw;
                    }
                }

            }
        }
    }

    class MoveRandomGoal extends Goal {
        public MoveRandomGoal() {
            this.setMutexFlags(EnumSet.of(Flag.MOVE));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return !EOC2Entity.this.getMoveHelper().isUpdating() && EOC2Entity.this.rand.nextInt(7) == 0;
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            return false;
        }
//

        /**
         * Keep ticking a continuous task that hasd already been started
         */
        public void tick() {
            BlockPos blockpos = EOC2Entity.this.getBoundOrigin();
            if (blockpos == null) {
                blockpos = new BlockPos(EOC2Entity.this);
            }
//
            for(int i = 0; i < 3; ++i) {
                BlockPos blockpos1 = blockpos.add(EOC2Entity.this.rand.nextInt(15) - 7, EOC2Entity.this.rand.nextInt(11) - 5, EOC2Entity.this.rand.nextInt(15) - 7);
                if (EOC2Entity.this.world.isAirBlock(blockpos1)) {
                    EOC2Entity.this.moveController.setMoveTo((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 0.25D);
                    if (EOC2Entity.this.getAttackTarget() == null) {
                        EOC2Entity.this.getLookController().setLookPosition((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 180.0F, 20.0F);
                    }
                    break;
                }
            }

        }
    }
}

