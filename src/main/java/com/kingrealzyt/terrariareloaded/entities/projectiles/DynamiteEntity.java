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
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DynamiteEntity extends ProjectileItemEntity {
    private static final Logger LOGGER   = LogManager.getLogger();
    private static final float  DAMAGE   = 5.0F;
    private static final float  DURATION = 30.0F/*in second*/;

    private static int Fuse = 160;

    private int tick = 0;

    public DynamiteEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public DynamiteEntity(World worldIn, LivingEntity livingEntityIn) {
        super(ModEntityTypes.DYNAMITE_ENTITY.get(), livingEntityIn, worldIn);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.DYNAMITE_ITEM.get();
    }

    @Override
    protected void onImpact(RayTraceResult result) {
    }

    @Override
    public void tick() {
        super.tick();
        ++this.tick;

        ////////////////////////////////////
        ////////////////////////////////////
        // Debugging
        // LOGGER.debug("tick = " + this.tick);
        ////////////////////////////////////

        if (this.tick >= 20 * DURATION) {
            spawnItem();
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }
        --this.Fuse;
        if (this.Fuse <= 0) {
            if (!this.world.isRemote) {
                this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 4.0F, Explosion.Mode.BREAK);
                this.Fuse = 160;
                this.world.setEntityState(this, (byte)3);
                this.remove();
            }
        }
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected float getGravityVelocity() {
        return 0.1F;
    }

    private void spawnItem(){
        ItemEntity item = new ItemEntity(this.world,
                this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ(),
                new ItemStack(ModItems.DYNAMITE_ITEM.get()));
        this.world.addEntity(item);
    }

}

