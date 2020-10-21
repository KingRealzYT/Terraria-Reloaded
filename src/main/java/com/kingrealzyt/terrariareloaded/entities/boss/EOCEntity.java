package com.kingrealzyt.terrariareloaded.entities.boss;

import com.kingrealzyt.terrariareloaded.entities.enemy.DemonEyeEntity;
import com.kingrealzyt.terrariareloaded.init.ModEntityTypes;
import com.kingrealzyt.terrariareloaded.init.SoundInit;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.AbstractRaiderEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

import javax.annotation.Nullable;
import java.util.EnumSet;

@SuppressWarnings("all")
public class EOCEntity extends FlyingEntity implements IEntityAdditionalSpawnData, IHostile {
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
    public static int phase = 1;
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

    private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

    public EOCEntity(EntityType<EOCEntity> type, World worldIn) {
        super(type, worldIn);
        this.init();
        if (!worldIn.isRemote()) {
            this.world.getServer().getPlayerList().sendMessage((new StringTextComponent("The Eye of Cthulhu has awoken!")).applyTextStyles(new TextFormatting[]{TextFormatting.BLUE, TextFormatting.BOLD}));
        }

        this.maxHealth = 2800 + 500 * (worldIn.getPlayers().size() - 1);
        this.bosshealth = (float)this.maxHealth;
        this.setHealth((float)this.maxHealth);
        phase = 0;
        isEyeAlive = true;
    }

    public EOCEntity(World world) {
        super(ModEntityTypes.EOC.get(), world);
        this.init();
    }

    public void init() {
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)(600));
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1000.0D);
        this.maxHealth = 600;
        this.bosshealth = (float)this.maxHealth;
        this.setHealth((float)this.maxHealth);
        return spawnDataIn;
    }


    public void onCollideWithPlayer(PlayerEntity player) {
        this.tryDamagePlayer(player);
    }

    public void tryDamagePlayer(PlayerEntity player) {
        if (this.transformedRotation <= 0.0D || this.transformedRotation >= 1790.0D) {
            if (player != null && (double)player.getDistance(this) <= 1.5D) {
                if (phase == 1) {
                    player.attackEntityFrom(DamageSource.causeMobDamage(this), 15.0F);
                } else {
                    player.attackEntityFrom(DamageSource.causeMobDamage(this), 23.0F);
                }
            }

        }
    }

    public float getHealth() {
        return this.bosshealth;
    }

    public boolean canRenderOnFire() {
        return false;
    }

    public void setFire(int seconds) {
    }

    public void tick() {
        isEyeAlive2 = isEyeAlive;
        this.ALREADY_SPAWNED = true;
        boolean despawn = true;

        for(int i = 0; i < this.world.getPlayers().size(); ++i) {
            if (((PlayerEntity)this.world.getPlayers().get(i)).getHealth() > 0.0F) {
                despawn = false;
                break;
            }
        }

        if (despawn) {
            this.REMOVED = true;
            isEyeAlive = false;
            this.remove();
        }

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
                if (this.spawnEyes) {
                    if (this.eyesNeeded == 0) {
                        this.eyesNeeded = this.rand.nextInt(2) + 2;
                        if (this.getHealth() <= (float)this.maxHealth * 0.25F) {
                            this.eyesNeeded = 1;
                        }
                    } else if (this.ticksExisted % 35 == 0 && this.rand.nextBoolean()) {
                        if (this.eyes < this.eyesNeeded) {
                            ++this.eyes;
                            if (phase == 1 && this.world.getEntitiesWithinAABB(DemonEyeEntity.class, this.getBoundingBox().expand(15.0D, 15.0D, 15.0D)).size() <= 8) {
                                DemonEyeEntity eye = new DemonEyeEntity.create(this.world, (CompoundNBT)null, (ITextComponent)null, (PlayerEntity)null, this.getPosition(), SpawnReason.EVENT, false, false);
                                eye.setPosition(this.getPosX(), this.getPosY(), this.getPosZ());
                                eye.setHealth(8.0F);
                                eye.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(12.0D);
                                this.world.addEntity(eye);
                                eye.noClip = true;
                            }
                        } else {
                            this.spawnEyes = false;
                            this.dashed = 0;
                        }
                    }

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
                            Vec3d direction = new Vec3d(target.lastTickPosX - target.getMotion().x - this.getPosX(), target.lastTickPosY - target.getMotion().y - this.posY, target.lastTickPosZ - target.getMotion().z - this.posZ);
                            direction = (new Vec3d(direction.x * 100.0D, direction.y * 100.0D, direction.z * 100.0D)).normalize();
                            direction = new Vec3d(direction.x * (double)speed, direction.y * (double)speed, direction.z * (double)speed);
                            this.velX = direction.x * 2.0D;
                            this.velY = direction.y * 2.0D;
                            this.velZ = direction.z * 2.0D;
                        }
                    }
                }
            }
            if (this.getHealth() <= (float)this.maxHealth * 0.65F && transformed == false) {
                transformed = true;
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
                this.lookAt(EntityAnchorArgument.Type.EYES, target.getPositionVec());
            }

            if (target != null) {
                this.rx = (float)Math.toDegrees(Math.atan2(this.getPosY() - target.getPosY(), this.getPosX() - target.getPosX()));
                this.rz = (float)Math.toDegrees(Math.atan2(this.getPosY() - target.getPosY(), this.getPosZ() - target.getPosZ()));
            }
        }

        this.setMotion(motionX, motionY, motionZ);
        this.dataManager.set(phase_data, phase);
        if (!this.world.isRemote) {
            this.setHealth(this.bosshealth);
        }

        this.maxHurtTime = 0;
        this.hurtResistantTime = 0;
        if ((Integer)this.getDataManager().get(phase_data) != 1 && this.transformedRotation < 1790.0D) {
            if (this.ticksExisted % 10 == 0 && this.world.getEntitiesWithinAABB(DemonEyeEntity.class, this.getBoundingBox().expand(15.0D, 15.0D, 15.0D)).size() <= 8) {
                DemonEyeEntity eye = (DemonEyeEntity)ModEntityTypes.DEMON_EYE.create(this.world, (CompoundNBT)null, (ITextComponent)null, (PlayerEntity)null, this.getPosition(), SpawnReason.EVENT, false, false);
                eye.setPosition(this.getPosX(), this.getPosY(), this.getPosZ());
                eye.setHealth(8.0F);
                eye.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(12.0D);
                this.world.addEntity(eye);
                eye.noClip = true;
                eye.setCustomName(new StringTextComponent("Servant of Cthulhu"));
            }

            this.transformedRotation += (1800.0D - this.transformedRotation) * 0.07999999821186066D;
            this.ry = (float)this.transformedRotation;
            this.rx = 0.0F;
            this.rz = 0.0F;
            this.velX = 0.0D;
            this.velY = 0.0D;
            this.velZ = 0.0D;
            motionX = 0.0D;
            motionY = 0.0D;
            motionZ = 0.0D;
            this.rotationYaw = this.ry;
        }

    }



}

