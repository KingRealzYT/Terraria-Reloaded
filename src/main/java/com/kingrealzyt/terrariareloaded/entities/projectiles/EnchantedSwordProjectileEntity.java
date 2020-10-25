package com.kingrealzyt.terrariareloaded.entities.projectiles;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EnchantedSwordProjectileEntity extends BaseProjectile{
    public EnchantedSwordProjectileEntity(EntityType<? extends SnowballEntity> type, World world) {
        super(type, world);
        this.damage = 10.0f;
        this.gravity = 0.0f;
        this.offset = 0.0f;
        this.inaccuracy = 0.0f;
    }

    public EnchantedSwordProjectileEntity(World worldIn, LivingEntity playerIn) {
        super(worldIn, playerIn);
    }

    @Override
    public boolean isGlowing() {
        return true;
    }
}
