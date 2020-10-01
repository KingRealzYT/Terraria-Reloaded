package com.kingrealzyt.terrariareloaded.items.weapons.ranged.repeaters;

import com.kingrealzyt.terrariareloaded.init.SoundInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import java.util.function.Predicate;

@SuppressWarnings("all")
public class ChlorophyteRepeaterItem extends ShootableItem {

    public ChlorophyteRepeaterItem(Properties properties) {
        super(properties);
    }

    @Override
    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return ARROWS;
    }

    @Override
    public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        super.onUse(worldIn, livingEntityIn, stack, count);
    }
    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (!playerIn.findAmmo(itemstack).isEmpty() || playerIn.abilities.isCreativeMode) {
            worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.REPEATERSHOOT.get(), SoundCategory.BLOCKS, 1, 1);
        }
        if(!worldIn.isRemote) {
            if (!playerIn.findAmmo(itemstack).isEmpty() || playerIn.abilities.isCreativeMode) {
                if (!playerIn.abilities.isCreativeMode) {
                    playerIn.findAmmo(itemstack).shrink(1);
                }
                ArrowEntity arrow = new ArrowEntity(worldIn, playerIn);
                arrow.setDamage(41.0f);
                arrow.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 5.0F, 0.12F);
                worldIn.addEntity(arrow);
            }
        }
        return ActionResult.resultConsume(itemstack);
    }
}
