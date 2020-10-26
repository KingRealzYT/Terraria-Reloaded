package com.kingrealzyt.terrariareloaded.entities.projectiles;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EnchantedSwordProjectileEntity extends BaseProjectile{

    public EnchantedSwordProjectileEntity(EntityType<? extends DamagingProjectileEntity> type, World world) {
        super(type, world);
        this.damage = 10.0f;
        this.glowing = true;
        this.setNoGravity(true);
    }


}
