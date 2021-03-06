package com.kingrealzyt.terrariareloaded.items.weapons.melee.projectileSwords;

import com.kingrealzyt.terrariareloaded.entities.projectiles.IceboltProjectileEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class IceBladeItem extends SwordItem {
    public IceBladeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity player) {
        World world = player.getEntityWorld();
        IceboltProjectileEntity projectile = new IceboltProjectileEntity(world, player);
        projectile.shoot(player, player.rotationPitch, player.rotationYaw, projectile.OFFSET, projectile.VELOCITY, projectile.INACCURACY);
        world.addEntity(projectile);
        return false;
    }


}
