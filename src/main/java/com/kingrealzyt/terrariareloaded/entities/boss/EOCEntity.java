package com.kingrealzyt.terrariareloaded.entities.boss;

import javax.annotation.Nullable;

import com.kingrealzyt.terrariareloaded.init.ModEntityTypes;
import com.kingrealzyt.terrariareloaded.init.SoundInit;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.BossInfo;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

@SuppressWarnings("all")
public class EOCEntity extends MonsterEntity {
    protected static final DataParameter<Byte> EOC_FLAGS = EntityDataManager.createKey(EOCEntity.class, DataSerializers.BYTE);
    private MobEntity owner;
    @Nullable
    private BlockPos boundOrigin;
    private boolean limitedLifespan;
    private int limitedLifeTicks;
    
    public static int phase;
    public int damage = 18;
    public float rx;
    public float ry;
    public float rz;
    public boolean collision;
    public boolean bounce;
    public double velX;
    public double velY;
    public double velZ;
    public double oldVelX;
    public double oldVelY;
    public double oldVelZ;
    public double speed = 2.0D;
    public double acc = 0.01D;
    public boolean spawnEyes = true;
    public int dashed = 0;
    public int eyes = 0;
    public int eyesNeeded = 0;
    public int maxHealth;
    public float bosshealth;
    public double transformedRotation = 0.0D;
    public int defense = 0;
    public static boolean isEyeAlive = false;
    public static boolean isEyeAlive2 = false;
    public boolean ALREADY_SPAWNED = false;
    public boolean REMOVED = false;
    public BlockPos lastTarget;
    public boolean transformed = false;

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

    public EOCEntity(EntityType<? extends EOCEntity> p_i50190_1_, World p_i50190_2_) {
        super(p_i50190_1_, p_i50190_2_);
        this.experienceValue = 3;
        this.setHealth(2800);
        this.maxHealth = 2800;
        isEyeAlive = true;
        phase = 1;
        System.out.println(phase);
        if (!world.isRemote()) {
        	this.world.getServer().getPlayerList().sendMessage((new StringTextComponent("The Eye of Cthulhu has awoken!")).applyTextStyles(new TextFormatting[]{TextFormatting.DARK_PURPLE, TextFormatting.BOLD}));
        }
    }

    public EOCEntity(World worldIn, double x, double y, double z) {
        this(ModEntityTypes.EOC.get(), worldIn);
        this.setPosition(x, y, z);
        phase = 1;
        
    }
    
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
       this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)(2800));
       this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1000.0D);
       this.setHealth(2800);
       this.maxHealth = 2800;
       phase = 1;
       return spawnDataIn;
    }
    
    public void onCollideWithPlayer(PlayerEntity player) {
        this.tryDamagePlayer(player);
     }

     public void tryDamagePlayer(PlayerEntity player) {
        if (this.transformedRotation <= 0.0D || this.transformedRotation >= 1790.0D) {
           if (player != null && (double)player.getDistance(this) <= 1.5D) {
              if (phase == 1) {
                 player.attackEntityFrom(DamageSource.causeMobDamage(this), 5.0F);
              } else {
                 player.attackEntityFrom(DamageSource.causeMobDamage(this), 10.0F);
              }
           }

        }
     }
     
     public void dropLoot(DamageSource source, boolean b) { 
    	 if (!world.isRemote()) {
    		 this.world.getServer().getPlayerList().sendMessage((new StringTextComponent("The Eye of Cthulhu has been defeated!")).applyTextStyles(new TextFormatting[]{TextFormatting.DARK_PURPLE, TextFormatting.BOLD}));
    	 }
    	 isEyeAlive = false;
     }
    
    public void tick() {
        isEyeAlive2 = isEyeAlive;
        this.ALREADY_SPAWNED = true;

        super.tick();
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(9999.0D);
        this.setNoGravity(true);
        this.noClip = true;
        double motionY = this.getMotion().y;
        double motionX = this.getMotion().x;
        double motionZ = this.getMotion().z;
        if (phase == 1) {
           this.defense = 12;
        } else {
           this.defense = 0;
        }

        if (!this.world.isRemote) {
           motionY = 0.0D;
           this.rotationPitch = 0.0F;
           this.rotationYaw = 0.0F;
           this.rotationYawHead = 0.0F;
           PlayerEntity target = null;
           double distance = 1000.0D;

           for(int i = 0; i < this.world.getPlayers().size(); ++i) {
              double dist = ((PlayerEntity)this.world.getPlayers().get(i)).getPositionVector().distanceTo(this.getPositionVector());
              if (dist < distance) {
                 distance = dist;
                 target = (PlayerEntity)this.world.getPlayers().get(i);
              }
           }
           
           if (this.world.getDayTime() % 24000L < 15000L || this.world.getDayTime() % 24000L > 22500L) {
              this.velY = 10.0D;
           }

           if (phase == 0) {
              phase = 1;
           }

           if (phase == 1 || phase == 2) {

                 if (target != null) {
              	   
              	   if (!target.isAlive()) {
              		   isEyeAlive = false;
              	   }
              	   
                    if (this.velX > -4.0D && this.getPosX() > target.getPosX() + (double)target.getWidth()) {
                       this.velX -= 0.08D;
                       if (this.velX > 4.0D) {
                          this.velX -= 0.04D;
                       } else if (this.velX > 0.0D) {
                          this.velX -= 0.2D;
                       }

                       if (this.velX < -4.0D) {
                          this.velX = -4.0D;
                       }
                    } else if (this.velX < 4.0D && this.getPosX() + 1.0D < target.getPosX()) {
                       this.velX += 0.08D;
                       if (this.velX < -4.0D) {
                          this.velX += 0.04D;
                       } else if (this.velX < 0.0D) {
                          this.velX += 0.2D;
                       }

                       if (this.velX > 4.0D) {
                          this.velX = 4.0D;
                       }
                    }

                    if (this.velZ > -4.0D && this.getPosZ() > target.getPosZ() + (double)target.getWidth()) {
                       this.velZ -= 0.08D;
                       if (this.velZ > 4.0D) {
                          this.velZ -= 0.04D;
                       } else if (this.velZ > 0.0D) {
                          this.velZ -= 0.2D;
                       }

                       if (this.velZ < -4.0D) {
                          this.velZ = -4.0D;
                       }
                    } else if (this.velZ < 4.0D && this.getPosZ() + 1.0D < target.getPosZ()) {
                       this.velZ += 0.07999999821186066D;
                       if (this.velZ < -4.0D) {
                          this.velZ += 0.04D;
                       } else if (this.velZ < 0.0D) {
                          this.velZ += 0.2D;
                       }

                       if (this.velZ > 4.0D) {
                          this.velZ = 4.0D;
                       }
                    }

                    if (this.velY > -2.5D && this.getPosY() > target.getPosY() + (double)target.getHeight() + 5.0D) {
                       this.velY -= 0.30000001192092896D;
                       if (this.velY > 2.5D) {
                          this.velY -= 0.05D;
                       } else if (this.velY > 0.0D) {
                          this.velY -= 0.15D;
                       }

                       if (this.velY < -2.5D) {
                          this.velY = -2.5D;
                       }
                    } else if (this.velY < 2.5D && this.getPosY() + 1.0D < target.getPosY() + 5.0D) {
                       this.velY += 0.30000001192092896D;
                       if (this.velY < -2.5D) {
                          this.velY += 0.05D;
                       } else if (this.velY < 0.0D) {
                          this.velY += 0.15D;
                       }

                       if (this.velY > 2.5D) {
                          this.velY = 2.5D;
                       }
                    }
                 }
              } else {
                 this.velX *= 0.949999988079071D;
                 this.velY *= 0.949999988079071D;
                 this.velZ *= 0.949999988079071D;
                 float speed = 2.0F;
                 if (phase == 2) {
                    speed = 2.0F;
                 }

                 if (this.getHealth() <= (float)this.maxHealth * 0.4F) {
                    speed = 2.0F;
                 }

                 boolean fast = false;
                 Vec3d motion = new Vec3d(this.velX, this.velY, this.velZ);
                 if (target != null && (motion.length() <= 1.0D || this.getHealth() <= (float)this.maxHealth * 0.4F && this.getHealth() >= (float)this.maxHealth * 0.25F && this.dashed >= 3 && motion.length() <= 2.5D || this.getHealth() <= (float)this.maxHealth * 0.25F && motion.length() < 2.5D)) {
                    if (this.getHealth() > (float)this.maxHealth * 0.4F) {
                       if (this.dashed < 3) {
                          ++this.dashed;
                       } else {
                          this.eyesNeeded = 0;
                          this.spawnEyes = true;
                          this.eyes = 0;
                       }
                    } else if (this.getHealth() < (float)this.maxHealth * 0.25F) {
                       speed = 4.0F;
                       fast = true;
                       if (this.lastTarget == null) {
                          this.lastTarget = target.getPosition();
                       }

                       if (this.dashed < 5) {
                          ++this.dashed;
                       } else {
                          this.dashed = 0;
                          speed = 1.0F;
                          this.lastTarget = null;
                       }
                    } else {
                       if (this.lastTarget == null) {
                          this.lastTarget = target.getPosition();
                       }

                       if (this.dashed < 6) {
                          ++this.dashed;
                       } else {
                          this.dashed = 0;
                          this.lastTarget = null;
                       }

                       if (this.dashed < 3) {
                          speed = 2.0F;
                       } else {
                          speed = 4.0F;
                          fast = true;
                       }
                    }

                    if (target != null) {
                       Vec3d direction = new Vec3d(target.lastTickPosX - target.getMotion().x - this.getPosX(), target.lastTickPosY - target.getMotion().y - this.getPosY(), target.lastTickPosZ - target.getMotion().z - this.getPosZ());
                       direction = (new Vec3d(direction.x * 100.0D, direction.y * 100.0D, direction.z * 100.0D)).normalize();
                       direction = new Vec3d(direction.x * (double)speed, direction.y * (double)speed, direction.z * (double)speed);
                       this.velX = direction.x * 2.0D;
                       this.velY = direction.y * 2.0D;
                       this.velZ = direction.z * 2.0D;
                    }
                 }
              }

           if (this.getHealth() <= 1400 && transformed == false) {
          	transformed = true;
          	world.playSound((PlayerEntity)null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundInit.ROAR, SoundCategory.PLAYERS, 100, 1);
              phase = 2;
           }

           this.bounce = false;
           this.oldVelX = this.velX + 0.0D;
           this.oldVelY = this.velY + 0.0D;
           this.oldVelZ = this.velZ + 0.0D;
           motionX = this.velX * 0.25D;
           motionY = this.velY * 0.25D;
           motionZ = this.velZ * 0.25D;

           if (target != null) {
              this.rx = (float)Math.toDegrees(Math.atan2(this.getPosY() - target.getPosY(), this.getPosX() - target.getPosX()));
              this.rz = (float)Math.toDegrees(Math.atan2(this.getPosY() - target.getPosY(), this.getPosZ() - target.getPosZ()));
           }
        }

        this.setMotion(motionX, motionY, motionZ);

        this.maxHurtTime = 0;
        this.hurtResistantTime = 0;
     }

   
}

