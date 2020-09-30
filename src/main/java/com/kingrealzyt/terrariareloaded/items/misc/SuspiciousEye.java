package com.kingrealzyt.terrariareloaded.items.misc;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.entities.projectiles.DynamiteEntity;
import com.kingrealzyt.terrariareloaded.entities.projectiles.ThrowingKnifeEntity;
import com.kingrealzyt.terrariareloaded.init.SoundInit;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class SuspiciousEye extends Item {

    public SuspiciousEye() {
        super(new Properties().group(TerrariaReloaded.BOSS));
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("Summons the Eye of Cthulhu"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.ENTITYBOSSROAR.get(), SoundCategory.HOSTILE, 3, 1);
        if(worldIn.isRemote) {
            worldIn.addEntity(new ThrowingKnifeEntity(worldIn, playerIn));
            playerIn.getHeldItem(handIn).shrink(1);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
