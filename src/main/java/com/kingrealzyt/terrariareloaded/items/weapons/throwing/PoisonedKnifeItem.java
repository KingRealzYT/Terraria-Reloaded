package com.kingrealzyt.terrariareloaded.items.weapons.throwing;

import com.kingrealzyt.terrariareloaded.entities.projectiles.PoisonedKnifeEntity;
import com.kingrealzyt.terrariareloaded.entities.projectiles.ThrowingKnifeEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class PoisonedKnifeItem extends Item {

    public PoisonedKnifeItem(Properties properties) {
        super(properties);
    }

    @Override
    public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        super.onUse(worldIn, livingEntityIn, stack, count);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote){
            if (!playerIn.abilities.isCreativeMode) {
                playerIn.getHeldItem(handIn).shrink(1);
            }
            PoisonedKnifeEntity thrownKnife = new PoisonedKnifeEntity(worldIn, playerIn);
            thrownKnife.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw,  0.0F, 1.25F, 0.12F);
            worldIn.addEntity(thrownKnife);
        }
        return ActionResult.resultConsume(playerIn.getHeldItem(handIn));
    }


}
