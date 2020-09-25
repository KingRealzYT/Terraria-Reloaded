package com.kingrealzyt.terrariareloaded.entities.boss;

import com.kingrealzyt.terrariareloaded.entities.boss.ai.eoc.EOCFlyingAttackGoal;
import com.kingrealzyt.terrariareloaded.entities.boss.ai.eoc.EOCLookAroundGoal;
import com.kingrealzyt.terrariareloaded.entities.boss.ai.eoc.EOCMovementHelperController;
import com.kingrealzyt.terrariareloaded.entities.boss.ai.eoc.EOCRandomFlyGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

public class EOCEntity extends FlyingEntity implements IMob {

    private static final DataParameter<Boolean> DATA_ATTACKING = EntityDataManager.createKey(EOCEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> FLYING_ATTACK = EntityDataManager.createKey(EOCEntity.class, DataSerializers.BOOLEAN);

    private static final double ALTITUDE_FLYING_THRESHOLD = 2;
    private static final double MAX_HEALTH = 400.0D;
    private static final double MOVEMENT_SPEED_FLYING = 0.7D;
    private static final double FOLLOW_RANGE = 100.0D;
    private static final double KNOCKBACK_RESISTANCE = 0.9F;
    private static final double ATTACK_DAMAGE = 0.5; //TODO change it later
    //If more players fighting against the eoc, then is this the chance, when the eoc switching the attacker
    private static final double ATTACKER_SWITCHING_CHANCE = 0.3D;
    private static final double MIN_ATTACK_RANGE = 0;
    private static final double MAX_ATTACK_RANGE = 4096.0 * 2.0;

    private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

    private final float meleeAttackMultiplier = 0.8F;

    public EOCEntity(EntityType<? extends EOCEntity> type, World worldIn) {
        super(type, worldIn);
        this.moveController = new EOCMovementHelperController(this);
    }


    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(DATA_ATTACKING, false);
        this.dataManager.register(FLYING_ATTACK, false);
    }

    @Override
    protected void registerGoals() {
        //this.goalSelector.addGoal(1, new EOCMeleeAttackGoal(this, MOVEMENT_SPEED_FLYING, false));
        this.goalSelector.addGoal(5, new EOCRandomFlyGoal(this));
        this.goalSelector.addGoal(7, new EOCLookAroundGoal(this));
        //this.targetSelector.addGoal(1, new EOCSearchAttackerGoal(this, FOLLOW_RANGE, FOLLOW_RANGE, FOLLOW_RANGE, 0));
        this.targetSelector.addGoal(1, new EOCFlyingAttackGoal(this));
        //this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, null));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        /*
        his.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
      this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
         */
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(MOVEMENT_SPEED_FLYING);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(MAX_HEALTH);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(FOLLOW_RANGE);
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(KNOCKBACK_RESISTANCE);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(ATTACK_DAMAGE);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(MOVEMENT_SPEED_FLYING);
    }


    public boolean isAttacking() {
        return this.dataManager.get(DATA_ATTACKING);
    }

    public void setAttacking(boolean attacking) {
        this.dataManager.set(DATA_ATTACKING, attacking);
    }

    public boolean isCurrentlyFlyingAttack() {
        return this.dataManager.get(FLYING_ATTACK);
    }

    public void setFlyingAttack(boolean attack) {
        this.dataManager.set(FLYING_ATTACK, attack);
    }

    public void addTrackingPlayer(ServerPlayerEntity player) {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void removeTrackingPlayer(ServerPlayerEntity player) {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    @Override
    public void livingTick() {
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());

        if(this.isCurrentlyFlyingAttack() && this.getAttackTarget() != null) {
            PlayerEntity playerEntity = (PlayerEntity) this.getAttackTarget();
            Vec3d eocPos = this.getPositionVec();
            Vec3d dir = this.getLookVec().subtract(playerEntity.getPositionVec()).normalize();
            this.move(MoverType.SELF, dir);
        }

        super.livingTick();
    }

    public boolean isNonBoss() {
        return false;
    }

}

