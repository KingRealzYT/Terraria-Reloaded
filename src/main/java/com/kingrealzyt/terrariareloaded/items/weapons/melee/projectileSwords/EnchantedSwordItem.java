package com.kingrealzyt.terrariareloaded.items.weapons.melee.projectileSwords;

import com.kingrealzyt.terrariareloaded.entities.projectiles.EnchantedSwordProjectile;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class EnchantedSwordItem extends SwordItem {
    public EnchantedSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity player) {
        World world = player.getEntityWorld();
        EnchantedSwordProjectile projectile = new EnchantedSwordProjectile(world, player);
        projectile.shoot(player, player.rotationPitch, player.rotationYaw, projectile.offset, projectile.velocity, projectile.inaccuracy);
        world.addEntity(projectile);

        return false;
    }
}