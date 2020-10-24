package com.kingrealzyt.terrariareloaded.entities.projectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BaseProjectile extends SnowballEntity{
    public float  damage;
    public float  gravity;
    public float  velocity;
    public float  offset;
    public float  inaccuracy;

    public BaseProjectile(EntityType<? extends SnowballEntity> type, World world) {
        super(type, world);
    }

    public BaseProjectile(World worldIn, LivingEntity playerIn) {
        super(worldIn, playerIn);
    }

    public BaseProjectile(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }


    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult) result).getEntity();
            if (entity instanceof LivingEntity) {
                entity.attackEntityFrom(DamageSource.causePlayerDamage(null), damage);
            }
        }
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected float getGravityVelocity() {
        return gravity;
    }
}
