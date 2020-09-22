package com.kingrealzyt.terrariareloaded.entities.projectiles;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import com.kingrealzyt.terrariareloaded.init.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class TerrarianYoyoProjectile extends ProjectileItemEntity {

    public static final int DURATION = 100;

    private int tick;

    public TerrarianYoyoProjectile(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public TerrarianYoyoProjectile(World worldIn, LivingEntity livingEntityIn) {
        super(ModEntityTypes.TERRARIAN_PROJECTILE_ENTITY.get(), livingEntityIn, worldIn);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.APPLE;
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if(result.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult) result).getEntity();
            if(entity instanceof LivingEntity) {
                entity.attackEntityFrom(TerrariaReloaded.YOYO, YoyoType.TERRARIAN.getDamage());
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        this.tick++;

        if(this.tick > DURATION) {
            this.remove();
        }

    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected float getGravityVelocity() {
        return 0.0F;
    }
}
