package com.kingrealzyt.terrariareloaded.entities.yoyo;

import com.google.common.collect.Maps;
import com.google.common.collect.Streams;
import com.kingrealzyt.terrariareloaded.init.ModEntityTypes;
import com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo.IYoyo;
import com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo.YoyoItem;
import com.kingrealzyt.terrariareloaded.util.MathUtil;
import com.kingrealzyt.terrariareloaded.util.Pair;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.*;
import java.util.stream.Collectors;

public class YoyoEntity extends MobEntity implements IEntityAdditionalSpawnData {

    public static final Map<UUID, YoyoEntity> CASTERS = Maps.newHashMap();

    public static final int MAX_RETRACT_TIME = 40;

    protected PlayerEntity thrower;
    protected IYoyo yoyo;

    public static final IDataSerializer<YoyoType> YOYO_TYPE_SERIALIZER = new IDataSerializer<YoyoType>() {
        @Override
        public void write(PacketBuffer buf, YoyoType value) {
            buf.writeEnumValue(value);
        }

        @Override
        public YoyoType read(PacketBuffer buf) {
            return buf.readEnumValue(YoyoType.class);
        }

        @Override
        public YoyoType copyValue(YoyoType value) {
            return value;
        }
    };

    static {
        DataSerializers.registerSerializer(YOYO_TYPE_SERIALIZER);
    }

    public static final DataParameter<ItemStack> YOYO_STACK = EntityDataManager.createKey(YoyoEntity.class, DataSerializers.ITEMSTACK);
    public static final DataParameter<Byte> HAND = EntityDataManager.createKey(YoyoEntity.class, DataSerializers.BYTE);
    public static final DataParameter<Integer> MAX_TIME = EntityDataManager.createKey(YoyoEntity.class, DataSerializers.VARINT);
    public static final DataParameter<Integer> REMAINGING_TIME = EntityDataManager.createKey(YoyoEntity.class, DataSerializers.VARINT);
    public static final DataParameter<Float> WEIGHT = EntityDataManager.createKey(YoyoEntity.class, DataSerializers.FLOAT);
    public static final DataParameter<Float> CURRENT_LENGTH = EntityDataManager.createKey(YoyoEntity.class, DataSerializers.FLOAT);
    public static final DataParameter<Float> MAX_LENGTH = EntityDataManager.createKey(YoyoEntity.class, DataSerializers.FLOAT);
    public static final DataParameter<Boolean> RETRACTING = EntityDataManager.createKey(YoyoEntity.class, DataSerializers.BOOLEAN);
    public static final DataParameter<YoyoType> YOYO_TYPE = EntityDataManager.createKey(YoyoEntity.class, YOYO_TYPE_SERIALIZER);

    protected float attackCool = 0.0F;
    protected float attackInterval = 0.0F;
    protected boolean shouldResetCool = false;
    protected boolean doesBlockInteraction = true;
    protected int lastSlot = -1;
    protected ItemStack yoyoStackLastTick = ItemStack.EMPTY;
    protected boolean shouldGetStats = true;
    protected int retractionTimeOut = 0;
    protected boolean canCancelRetract = true;

    public YoyoEntity(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        this.setNoGravity(true);
    }

    public YoyoEntity(World world, PlayerEntity playerEntity, Hand hand, YoyoType yoyoType) {
        super(ModEntityTypes.YOYO_ENTITY.get(), world);
        CASTERS.put(playerEntity.getUniqueID(), this);
        this.setHand(hand);
        thrower = playerEntity;
        setYoyoType(yoyoType);

        Vec3d handPos = getPlayerHandPos(1.0F);
        setPosition(handPos.x, handPos.y, handPos.z);

        if (!world.hasNoCollisions(this))
            setPosition(playerEntity.getPosX(),
                    playerEntity.getPosY() + playerEntity.getStandingEyeHeight(playerEntity.getPose(), playerEntity.getSize(playerEntity.getPose())), playerEntity.getPosZ());
    }


    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        Objects.requireNonNull(getAttributes().getAttributeInstance(SharedMonsterAttributes.MAX_HEALTH)).setBaseValue(Double.MAX_VALUE);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(YOYO_STACK, ItemStack.EMPTY);
        this.dataManager.register(HAND, (byte) Hand.MAIN_HAND.ordinal());
        this.dataManager.register(MAX_TIME, -1);
        this.dataManager.register(REMAINGING_TIME, -1);
        this.dataManager.register(WEIGHT, 1.0F);
        this.dataManager.register(CURRENT_LENGTH, 1.0F);
        this.dataManager.register(MAX_LENGTH, 1.0F);
        this.dataManager.register(RETRACTING, false);
        this.dataManager.register(YOYO_TYPE, YoyoType.WOODEN);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void writeSpawnData(PacketBuffer buffer) {
        buffer.writeInt(thrower.getEntityId());
    }

    @Override
    public void readSpawnData(PacketBuffer additionalData) {
        Entity entity = world.getEntityByID(additionalData.readInt());
        if (entity instanceof PlayerEntity) {
            thrower = (PlayerEntity) entity;
            CASTERS.put(thrower.getUniqueID(), this);
        }
    }

    public Vec3d getPlayerHandPos(float partialTicks) {
        if (this.thrower == null) return new Vec3d(getPosX(), getPosY(), getPosZ());

        float yaw = thrower.rotationYaw;
        float pitch = thrower.rotationPitch;

        double posX = thrower.getPosX();
        double posY = thrower.getPosY();
        double posZ = thrower.getPosZ();

        if (partialTicks != 1F) {
            yaw = (float) interpolateValue(thrower.prevRotationYaw, yaw, partialTicks);
            pitch = (float) interpolateValue(thrower.prevRotationPitch, pitch, partialTicks);

            posX = interpolateValue(thrower.prevPosX, posX, partialTicks);
            posY = interpolateValue(thrower.prevPosY, posY, partialTicks);
            posZ = interpolateValue(thrower.prevPosZ, posZ, partialTicks);
        }
        double throwerLookOffsetX = Math.cos(yaw * 0.01745329238474369);
        double throwerLookOffsetZ = Math.sin(yaw * 0.01745329238474369);
        double throwerLookOffsetY = Math.sin(pitch * 0.01745329238474369);
        double throwerLookWidth = Math.cos(pitch * 0.01745329238474369);

        float throwerEyeHeight = thrower.getStandingEyeHeight(thrower.getPose(), thrower.getSize(thrower.getPose()));

        float side = (thrower.getPrimaryHand() == HandSide.RIGHT && getHand() == Hand.MAIN_HAND) ? 1F : -1F;
        return new Vec3d(posX - throwerLookOffsetX * (double) side * 0.4 - throwerLookOffsetZ * 0.5 * throwerLookWidth,
                posY + throwerEyeHeight - throwerLookOffsetY * 0.5 - 0.25, posZ - throwerLookOffsetZ * side * 0.4 * throwerLookOffsetX * 0.5 * throwerLookWidth);
    }

    public float getRotation(int age, float partialTicks) {
        int maxTime = getMaxTime();
        float ageInTicks;

        if (maxTime < 0)
            ageInTicks = age + partialTicks;
        else
            ageInTicks = maxTime - getRemainingTime() + partialTicks;

        float multiplier = 35F;

        if (maxTime > 0)
            multiplier *= 2 - ageInTicks / maxTime;

        return ageInTicks * multiplier;
    }

    public int decrementRemainingTime() {
        int out = getRemainingTime() - 1;
        setRemaingingTime(out);
        return out;
    }


    @Override
    public void tick() {
        super.tick();
        this.lastTickPosX = getPosX();
        this.lastTickPosY = getPosY();
        this.lastTickPosZ = getPosZ();

        if (thrower != null) {
            yoyo = this.checkYoyoAndGet();
            if (yoyo == null)
                return;

            if (getMaxTime() >= 0 && decrementRemainingTime() < 0) {
                forceRetract();
            }

            updateMotion();
            moveAndCollide();

            yoyo.onUpdate(getYoyoStack(), this);

            if (!world.isRemote && doesBlockInteraction) {
                this.worldInteraction();
            }

            handlePlayerPulling();
            resetOrIncrementAttackCooldown();
        } else {
            remove();
        }
    }

    public void resetOrIncrementAttackCooldown() {
        if (shouldResetCool) {
            attackCool = 0;
            shouldResetCool = false;
        } else {
            attackCool++;
        }
    }


    public void worldInteraction() {
        BlockPos pos = getPosition();

        AxisAlignedBB entityBox = getBoundingBox().grow(0.1);

        Streams.stream(BlockPos.getAllInBoxMutable(pos.add(-1, -1, -1), pos.add(1, 1, 1)))
                .map(it -> new Pair<>(it.toImmutable(), world.getBlockState(it)))
                .filter(it -> !it.value.isAir(world, it.key))
                .filter(it -> it.value.getShape(world, it.key)
                        .toBoundingBoxList().stream().anyMatch(bb -> bb.offset(it.key).intersects(entityBox)))
                .forEach(it -> yoyo.blockInteraction(getYoyoStack(), thrower, world, it.key, it.value, it.value.getBlock(), null));

    }

    @Override
    protected void damageEntity(DamageSource damageSrc, float damageAmount) {
        //We dont want to damage the yoyo entity
    }

    public void forceRetract() {
        setRetracting(true);
        canCancelRetract = false;
    }

    protected IYoyo checkYoyoAndGet() {
        Hand hand = getHand();
        ItemStack yoyoStack = thrower.getHeldItem(hand);
        setYoyoStack(yoyoStack);

        int currentSlot = hand == Hand.MAIN_HAND ? thrower.inventory.currentItem : -2;
        ItemStack otherHand = thrower.getHeldItem(hand == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND);

        if (!CASTERS.containsKey(thrower.getUniqueID()) || !(yoyoStack.getItem() instanceof YoyoItem) || ticksExisted > 1 && (lastSlot != -1 && lastSlot != currentSlot || otherHand == yoyoStackLastTick)) {
            this.remove();
            return null;
        }

        this.yoyoStackLastTick = yoyoStack;
        if (yoyoStack.getMaxDamage() < yoyoStack.getDamage() && !(yoyoStack.getItem() instanceof YoyoItem)) {
            this.remove();
            return null;
        }

        if (!world.isRemote && CASTERS.get(thrower.getUniqueID()) != this) {
            if (!CASTERS.containsKey(thrower.getUniqueID()))
                CASTERS.put(thrower.getUniqueID(), this);
            else
                CASTERS.replace(thrower.getUniqueID(), this);
        }

        IYoyo yoyo = (IYoyo) yoyoStack.getItem();

        if (!world.isRemote && shouldGetStats) {
            attackInterval = yoyo.getAttackInterval(yoyoStack);
            int duration = yoyo.getDuration(yoyoStack);
            setMaxTime(duration);
            setRemaingingTime(duration);

            double maxLength = yoyo.getLength(yoyoStack);
            setCurrentLength((float) maxLength);
            setMaxLength((float) maxLength);
            setWeight((float) yoyo.getWeight(yoyoStack));

            shouldGetStats = false;
        }
        lastSlot = currentSlot;
        return yoyo;
    }

    @Override
    public void remove() {
        super.remove();
        if (thrower != null) {
            CASTERS.remove(thrower.getUniqueID());
        }
    }

    public void updateMotion() {
        Vec3d motion = getTarget().subtract(getPosX(), getPosY() + getHeight() / 2, getPosZ()).scale(0.15 + 0.85 * Math.pow(1.1, -(getWeight() * getWeight())));

        if (inWater) {
            motion = motion.scale(yoyo.getWaterMovementModifier(getYoyoStack()));
        }
        setMotion(motion);
        onGround = true;
    }

    public void handlePlayerPulling() {
        double dx = getPosX() - thrower.getPosX();
        double eyeHeight = thrower.getStandingEyeHeight(thrower.getPose(), thrower.getSize(thrower.getPose()));

        double dy = getPosY() + getHeight() * 0.5 - (thrower.getPosY() + eyeHeight);
        if (dy < 0 && getCurrentLength() < eyeHeight)
            dy += eyeHeight * 1.2;

        double dz = getPosZ() - thrower.getPosZ();
        double distanceSqr = dx * dx + dy * dy + dz * dz;

        if (distanceSqr > getCurrentLength() * getCurrentLength()) {
            double stretch = Math.sqrt(distanceSqr) - getCurrentLength();
            double scale = Math.min(0.04 * stretch * stretch, 0.4);
            thrower.addVelocity(dx * scale, dy * scale, dz * scale);
            thrower.fallDistance = 0f;
            if (isRetracting())
                remove();
        }

    }

    public void moveAndCollide() {
        AxisAlignedBB yoyoBoundingBox = getBoundingBox();
        AxisAlignedBB targetBoundingBox = yoyoBoundingBox.offset(getMotion());

        if (noClip) {
            Vec3d pos = targetBoundingBox.getCenter();
            setPosition(pos.x, targetBoundingBox.minY, pos.z);
            return;
        }

        AxisAlignedBB union = targetBoundingBox.union(yoyoBoundingBox);
        List<AxisAlignedBB> colliderBoxes = world.getCollisionShapes(null, union).flatMap(it -> it.toBoundingBoxList().stream()).collect(Collectors.toList());
        List<Entity> entities = world.getEntitiesWithinAABBExcludingEntity(this, union);
        int steps = 50;

        for (int i = 0; i < steps; i++) {
            Vec3d motion = getMotion();
            double dx = motion.x / steps;
            double dy = motion.y / steps;
            double dz = motion.z / steps;

            for (AxisAlignedBB box : colliderBoxes) {
                dx = MathUtil.calculateXOffset(box, yoyoBoundingBox, dx);
                dy = MathUtil.calculateXOffset(box, yoyoBoundingBox, dy);
                dz = MathUtil.calculateXOffset(box, yoyoBoundingBox, dz);
            }

            yoyoBoundingBox = yoyoBoundingBox.offset(dx, dy, dz);

            for (AxisAlignedBB box : colliderBoxes) {
                if (box.intersects(yoyoBoundingBox)) {
                    dx = MathUtil.calculateXOffset(box, yoyoBoundingBox, dx);
                    dy = MathUtil.calculateYOffset(box, yoyoBoundingBox, dy);
                    dz = MathUtil.calculateZOffset(box, yoyoBoundingBox, dz);

                    yoyoBoundingBox = yoyoBoundingBox.offset(-dx, -dy, -dz);
                }
            }
            if (!world.isRemote) {
                Iterator<Entity> iterator = entities.iterator();

                while (iterator.hasNext()) {
                    Entity entity = iterator.next();
                    if (entity == thrower) {
                        iterator.remove();
                        continue;
                    }

                    if (entity.getBoundingBox().intersects(yoyoBoundingBox)) {
                        interactWithEntity(entity);
                        iterator.remove();
                    }
                }
            }
        }

        Vec3d pos = yoyoBoundingBox.getCenter();
        setPosition(pos.x, yoyoBoundingBox.minY, pos.z);

    }

    @Override
    protected void collideWithEntity(Entity entityIn) {
        if (entityIn instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) entityIn;
            if (playerEntity.getUniqueID().equals(thrower.getUniqueID()))
                return;
        }
        entityIn.applyEntityCollision(this);
    }

    public void interactWithEntity(Entity entity) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) entity;
            if (playerEntity == thrower)
                return;
        }
        yoyo.entityInteraction(getYoyoStack(), thrower, getHand(), this, entity);
    }

    public Vec3d getTarget() {
        if (isRetracting()) {
            Vec3d handPos = getPlayerHandPos(1.0F);
            double dX = getPosX() - handPos.x;
            double dY = getPosY() - handPos.y;
            double dZ = getPosZ() - handPos.z;
            if (dX * dX + dY * dY + dZ * dZ < 0.0 || retractionTimeOut++ >= MAX_RETRACT_TIME)
                this.remove();

            return handPos;
        } else {
            Vec3d eyePos = new Vec3d(thrower.getPosX(), thrower.getPosY() + thrower.getStandingEyeHeight(thrower.getPose(), thrower.getSize(thrower.getPose())), thrower.getPosZ());
            Vec3d lookVec = thrower.getLook(1.0F);

            double cordLength = getCurrentLength();

            Vec3d target = new Vec3d(eyePos.x + lookVec.x * cordLength, eyePos.y + lookVec.y * cordLength, eyePos.z + lookVec.z * cordLength);
            retractionTimeOut = 0;
            RayTraceResult rayTraceResult = getTargetLook(eyePos, target);
            if (rayTraceResult != null)
                target = rayTraceResult.getHitVec();

            return target;
        }
    }


    public RayTraceResult getTargetLook(Vec3d from, Vec3d to) {
        double distance = from.distanceTo(to);
        RayTraceResult objectMouseOver = world.rayTraceBlocks(new RayTraceContext(from, to, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, thrower));
        boolean flag = false;
        double d1 = objectMouseOver.getHitVec().distanceTo(from);

        if (distance > 3.0)
            flag = true;

        Vec3d vec3d1 = thrower.getLook(1F);
        Entity pointedEntity = null;
        Vec3d vec3d3 = null;
        AxisAlignedBB expanded = thrower.getBoundingBox().expand(vec3d1.x * distance, vec3d1.y * distance, vec3d1.z * distance).expand(1.0, 1.0, 1.0);

        List<Entity> list = world.getEntitiesInAABBexcluding(null, expanded, entity -> !(entity instanceof PlayerEntity) || !entity.isSpectator() && entity.canBeCollidedWith());
        double d2 = d1;
        for (Entity entity : list) {
            if (entity == this || entity == thrower) continue;

            AxisAlignedBB box = entity.getBoundingBox().grow(entity.getCollisionBorderSize());
            Optional<Vec3d> rayTraceResult = box.rayTrace(from, to);

            if (box.contains(from)) {
                if (d2 >= 0.0) {
                    pointedEntity = entity;
                    vec3d3 = rayTraceResult.orElse(from);
                    d2 = 0.0;
                }
            } else if (rayTraceResult.isPresent()) {
                double d3 = from.distanceTo(rayTraceResult.get());

                if (d3 < d2 || d2 == 0.0) {
                    if (entity.getLowestRidingEntity() == thrower.getLowestRidingEntity() && !thrower.canRiderInteract()) {
                        if (d2 == 0.0) {
                            pointedEntity = entity;
                            vec3d3 = rayTraceResult.get();
                        }
                    } else {
                        pointedEntity = entity;
                        vec3d3 = rayTraceResult.get();
                        d2 = d3;
                    }
                }
            }
        }
        if (vec3d3 != null) {
            if (flag) {
                objectMouseOver = BlockRayTraceResult.createMiss(vec3d3, Direction.UP, new BlockPos(vec3d3));
            }
        }
        return objectMouseOver;
    }

    //GETTER AND SETTER METHODS
    public void setYoyoType(YoyoType type) {
        this.dataManager.set(YOYO_TYPE, type);
    }

    public YoyoType getYoyoType() {
        return this.dataManager.get(YOYO_TYPE);
    }

    public boolean hasYoyo() {
        return this.yoyo != null;
    }

    public IYoyo getYoyo() {
        return yoyo;
    }

    public PlayerEntity getThrower() {
        return thrower;
    }

    public void setRetracting(boolean retracting) {
        if (canCancelRetract || !isRetracting())
            this.dataManager.set(RETRACTING, retracting);
    }

    public boolean isRetracting() {
        return this.dataManager.get(RETRACTING);
    }

    public boolean isDoesBlockInteraction() {
        return doesBlockInteraction;
    }

    public void setDoesBlockInteraction(boolean doesBlockInteraction) {
        this.doesBlockInteraction = doesBlockInteraction;
    }

    public boolean canAttack() {
        return attackCool >= attackInterval;
    }

    public void resetAttackCool() {
        shouldResetCool = true;
    }

    public void setWeight(float weight) {
        this.dataManager.set(WEIGHT, weight);
    }

    public float getWeight() {
        return this.dataManager.get(WEIGHT);
    }

    public void setCurrentLength(float length) {
        this.dataManager.set(CURRENT_LENGTH, length);
    }

    public float getCurrentLength() {
        return this.dataManager.get(CURRENT_LENGTH);
    }

    public void setMaxLength(float length) {
        this.dataManager.set(MAX_LENGTH, length);
    }

    public float getMaxLength() {
        return this.dataManager.get(MAX_LENGTH);
    }

    public void setYoyoStack(ItemStack stack) {
        this.dataManager.set(YOYO_STACK, stack);
    }

    public ItemStack getYoyoStack() {
        return this.dataManager.get(YOYO_STACK);
    }

    public void setHand(Hand hand) {
        this.dataManager.set(HAND, (byte) hand.ordinal());
    }

    public Hand getHand() {
        return Hand.values()[this.dataManager.get(HAND)];
    }

    public void setMaxTime(int time) {
        this.dataManager.set(MAX_TIME, time);
    }

    public int getMaxTime() {
        return this.dataManager.get(MAX_TIME);
    }

    public void setRemaingingTime(int time) {
        this.dataManager.set(REMAINGING_TIME, time);
    }

    public int getRemainingTime() {
        return this.dataManager.get(REMAINGING_TIME);
    }

    protected double interpolateValue(double start, double end, double pct) {
        return start + (end - start) * pct;
    }

}
