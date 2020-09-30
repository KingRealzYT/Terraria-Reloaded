package com.kingrealzyt.terrariareloaded.items.weapons.throwing;

import com.kingrealzyt.terrariareloaded.init.SoundInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import com.kingrealzyt.terrariareloaded.entities.projectiles.ThrowingKnifeEntity;

public class ThrowingKnifeItem extends Item {

    public ThrowingKnifeItem(Properties properties) {
        super(properties);
    }

    @Override
    public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        super.onUse(worldIn, livingEntityIn, stack, count);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.ITEMTHROW.get(), SoundCategory.PLAYERS, 1, 1);
        if (!worldIn.isRemote){
            if (!playerIn.abilities.isCreativeMode) {
                playerIn.getHeldItem(handIn).shrink(1);
            }
            ThrowingKnifeEntity thrownKnife = new ThrowingKnifeEntity(worldIn, playerIn);
            thrownKnife.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw,  0.0F, 1.25F, 0.12F);
            worldIn.addEntity(thrownKnife);
        }
        return ActionResult.resultConsume(playerIn.getHeldItem(handIn));
    }


}
