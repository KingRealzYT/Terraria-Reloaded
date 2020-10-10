package com.kingrealzyt.terrariareloaded.entities.enemy;

import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import com.kingrealzyt.terrariareloaded.init.ModEntityTypes;
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
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.EnumSet;

@SuppressWarnings("all")
public class DemonEntity extends MonsterEntity {
    protected static final DataParameter<Byte> DEMON_FLAGS = EntityDataManager.createKey(DemonEntity.class, DataSerializers.BYTE);
    private MobEntity owner;
    @Nullable
    private BlockPos boundOrigin;
    private boolean limitedLifespan;
    private int limitedLifeTicks;

    private static final double ALTITUDE_FLYING_THRESHOLD = 2;
    private static final double MAX_HEALTH = 50.0F;
    private static final double MOVEMENT_SPEED_FLYING = 0.6D;
    private static final double FOLLOW_RANGE = 19.0D;
    private static final double KNOCKBACK_RESISTANCE = 0.5F;
    private static final double ATTACK_DAMAGE = 4.0;
    private static final double ATTACKER_SWITCHING_CHANCE = 0.3D;
    private static final double MIN_ATTACK_RANGE = 0;
    private static final double MAX_ATTACK_RANGE = 8.0;

    public DemonEntity(EntityType<? extends DemonEntity> p_i50190_1_, World p_i50190_2_) {
        super(p_i50190_1_, p_i50190_2_);
        this.moveController = new DemonEntity.MoveHelperController(this);
        this.experienceValue = 3;
    }

    public DemonEntity(World worldIn, double x, double y, double z) {
        this(ModEntityTypes.DEMON.get(), worldIn);
        this.setPosition(x, y, z);
    }

    public void move(MoverType typeIn, Vec3d pos) {
        super.move(typeIn, pos);
        this.doBlockCollisions();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        this.noClip = false;
        super.tick();
        this.noClip = false;
        this.setNoGravity(true);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(4, new DemonEntity.ChargeAttackGoal());
        this.goalSelector.addGoal(8, new DemonEntity.MoveRandomGoal());
        this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(MAX_HEALTH);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(KNOCKBACK_RESISTANCE);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(MOVEMENT_SPEED_FLYING);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(FOLLOW_RANGE);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(MOVEMENT_SPEED_FLYING);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(DEMON_FLAGS, (byte)0);
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

    private boolean getDEFlag(int mask) {
        int i = this.dataManager.get(DEMON_FLAGS);
        return (i & mask) != 0;
    }

    private void setDEFlag(int mask, boolean value) {
        int i = this.dataManager.get(DEMON_FLAGS);
        if (value) {
            i = i | mask;
        } else {
            i = i & ~mask;
        }

        this.dataManager.set(DEMON_FLAGS, (byte)(i & 255));
    }

    public boolean isCharging() {
        return this.getDEFlag(1);
    }

    public void setCharging(boolean charging) {
        this.setDEFlag(1, charging);
    }

    public void setOwner(MobEntity ownerIn) {
        this.owner = ownerIn;
    }

    public void setLimitedLife(int limitedLifeTicksIn) {
        this.limitedLifespan = false;
        this.limitedLifeTicks = limitedLifeTicksIn;
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
        return true;
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
            if (DemonEntity.this.getAttackTarget() != null && !DemonEntity.this.getMoveHelper().isUpdating() && DemonEntity.this.rand.nextInt(7) == 0) {
                return DemonEntity.this.getDistanceSq(DemonEntity.this.getAttackTarget()) > 4.0D;
            } else {
                return false;
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            return DemonEntity.this.getMoveHelper().isUpdating() && DemonEntity.this.isCharging() && DemonEntity.this.getAttackTarget() != null && DemonEntity.this.getAttackTarget().isAlive();
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            LivingEntity livingentity = DemonEntity.this.getAttackTarget();
            Vec3d vec3d = livingentity.getEyePosition(1.0F);
            DemonEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 2.0D);
            DemonEntity.this.setCharging(true);
            DemonEntity.this.playSound(SoundInit.DEMON_AMBIENT.get(), 1.0F, 1.0F);
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            DemonEntity.this.setCharging(false);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            LivingEntity livingentity = DemonEntity.this.getAttackTarget();
            if (DemonEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                DemonEntity.this.attackEntityAsMob(livingentity);
                DemonEntity.this.setCharging(false);
            } else {
                double d0 = DemonEntity.this.getDistanceSq(livingentity);
                if (d0 < 9.0D) {
                    Vec3d vec3d = livingentity.getEyePosition(1.0F);
                    DemonEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 2.0D);
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
            return DemonEntity.this.owner != null && DemonEntity.this.owner.getAttackTarget() != null && this.isSuitableTarget(DemonEntity.this.owner.getAttackTarget(), this.field_220803_b);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            DemonEntity.this.setAttackTarget(DemonEntity.this.owner.getAttackTarget());
            super.startExecuting();
        }
    }

    class MoveHelperController extends MovementController {
        public MoveHelperController(DemonEntity vex) {
            super(vex);
        }

        public void tick() {
            if (this.action == Action.MOVE_TO) {
                Vec3d vec3d = new Vec3d(this.posX - DemonEntity.this.getPosX(), this.posY - DemonEntity.this.getPosY(), this.posZ - DemonEntity.this.getPosZ());
                double d0 = vec3d.length();
                if (d0 < DemonEntity.this.getBoundingBox().getAverageEdgeLength()) {
                    this.action = Action.WAIT;
                    DemonEntity.this.setMotion(DemonEntity.this.getMotion().scale(0.5D));
                } else {
                    DemonEntity.this.setMotion(DemonEntity.this.getMotion().add(vec3d.scale(this.speed * 0.05D / d0)));
                    if (DemonEntity.this.getAttackTarget() == null) {
                        Vec3d vec3d1 = DemonEntity.this.getMotion();
                        DemonEntity.this.rotationYaw = -((float)MathHelper.atan2(vec3d1.x, vec3d1.z)) * (180F / (float)Math.PI);
                        DemonEntity.this.renderYawOffset = DemonEntity.this.rotationYaw;
                    } else {
                        double d2 = DemonEntity.this.getAttackTarget().getPosX() - DemonEntity.this.getPosX();
                        double d1 = DemonEntity.this.getAttackTarget().getPosZ() - DemonEntity.this.getPosZ();
                        DemonEntity.this.rotationYaw = -((float)MathHelper.atan2(d2, d1)) * (180F / (float)Math.PI);
                        DemonEntity.this.renderYawOffset = DemonEntity.this.rotationYaw;
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
            return !DemonEntity.this.getMoveHelper().isUpdating() && DemonEntity.this.rand.nextInt(7) == 0;
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
            BlockPos blockpos = DemonEntity.this.getBoundOrigin();
            if (blockpos == null) {
                blockpos = new BlockPos(DemonEntity.this);
            }
//
            for(int i = 0; i < 3; ++i) {
                BlockPos blockpos1 = blockpos.add(DemonEntity.this.rand.nextInt(15) - 7, DemonEntity.this.rand.nextInt(11) - 5, DemonEntity.this.rand.nextInt(15) - 7);
                if (DemonEntity.this.world.isAirBlock(blockpos1)) {
                    DemonEntity.this.moveController.setMoveTo((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 0.25D);
                    if (DemonEntity.this.getAttackTarget() == null) {
                        DemonEntity.this.getLookController().setLookPosition((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 180.0F, 20.0F);
                    }
                    break;
                }
            }

        }
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return SoundInit.DEMON_AMBIENT.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.DEMON_KILLED.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundInit.DEMON_HURT.get();
    }

}

