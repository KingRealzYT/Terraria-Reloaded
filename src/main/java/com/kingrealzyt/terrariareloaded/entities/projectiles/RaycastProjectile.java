package com.kingrealzyt.terrariareloaded.entities.projectiles;

import com.kingrealzyt.terrariareloaded.init.ModEntityTypes;
import com.kingrealzyt.terrariareloaded.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class RaycastProjectile extends ProjectileItemEntity {
    public static final float  DAMAGE = 10.0f;
    public static final float  GRAVITY = 10.0f;
    public static final float  VELOCITY = 1.0f;
    public static final float  OFFSET = 0.0f;
    public static final float  INACCURACY = 0.0f;
    public static final boolean ISGLOWING = false; // toggle this to set if
    public static final boolean CANBERETRIVED = false; // toggle this to set if it can be retrived as an item after hitting a block
    public static final int DURATION = 1000; //toggle this to set the duration the projectile lasts in the world(seconds)
    public int tick = 0;

    public RaycastProjectile(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public RaycastProjectile(World worldIn, LivingEntity livingEntityIn) {
        super(ModEntityTypes.RAYCAST_PROJECTILE.get(), livingEntityIn, worldIn);
    } // change the throwing knife entity to your entity

    @Override
    protected Item getDefaultItem() {
        return ModItems.ICEBOLT_PROJECTILE.get();
    } // change the throwing knife item to whatever item you got

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult) result).getEntity();
            if (entity instanceof LivingEntity) {
                entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, null), DAMAGE);// set the damage type to whichever that fits
            }
        }
        else if (!this.world.isRemote) {
            //spawnItem();
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }
    }

    @Override
    public void tick() {
        super.tick();
        ++this.tick;

        ////////////////////////////////////
        // Debugging
        // LOGGER.debug("tick = " + this.tick);
        ////////////////////////////////////

        if (this.tick >= 20 * DURATION) {
            spawnItem();
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected float getGravityVelocity() {
        return GRAVITY;
    }

    private void spawnItem(){
        ItemEntity item = new ItemEntity(this.world,
                this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ(),
                new ItemStack(Items.AIR)); // change this to whatever item you got for this entity, if you don't wany it to spawn anything then use air
        this.world.addEntity(item);
    }

    @Override
    public boolean isGlowing() {
        return ISGLOWING;
    }
}
