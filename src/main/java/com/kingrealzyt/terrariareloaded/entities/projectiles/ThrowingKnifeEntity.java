package com.kingrealzyt.terrariareloaded.entities.projectiles;

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
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.kingrealzyt.terrariareloaded.init.ModEntityTypes;
import com.kingrealzyt.terrariareloaded.init.ModItems;

public class ThrowingKnifeEntity extends ProjectileItemEntity {
    private static final Logger LOGGER   = LogManager.getLogger();
    private static final float  DAMAGE   = 5.0F;
    private static final float  DURATION = 30.0F/*in second*/;

    private int tick = 0;

    public ThrowingKnifeEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public ThrowingKnifeEntity(World worldIn, LivingEntity livingEntityIn) {
        super(ModEntityTypes.THROWING_KNIFE_ENTITY.get(), livingEntityIn, worldIn);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.THROWING_KNIFE_ITEM.get();
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult) result).getEntity();
            if (entity instanceof LivingEntity) {
                entity.attackEntityFrom(DamageSource.causeThrownDamage(this, null), DAMAGE);
            }
        }
        else if (!this.world.isRemote) {
            spawnItem();
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
        return 0.0F;
    }

    private void spawnItem(){
        ItemEntity item = new ItemEntity(this.world,
                this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ(),
                new ItemStack(ModItems.THROWING_KNIFE_ITEM.get()));
        this.world.addEntity(item);
    }

}

