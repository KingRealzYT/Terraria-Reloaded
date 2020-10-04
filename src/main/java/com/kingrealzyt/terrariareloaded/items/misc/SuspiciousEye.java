package com.kingrealzyt.terrariareloaded.items.misc;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import com.kingrealzyt.terrariareloaded.entities.projectiles.DynamiteEntity;
import com.kingrealzyt.terrariareloaded.entities.projectiles.ThrowingKnifeEntity;
import com.kingrealzyt.terrariareloaded.init.ModEntityTypes;
import com.kingrealzyt.terrariareloaded.init.SoundInit;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.DrownedEntity;
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
        return 16;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(worldIn.isRemote) {
            EOCEntity eoc = new EOCEntity(worldIn, playerIn.getPosXRandom(5), playerIn.getPosY() + 7.5, playerIn.getPosZRandom(5));
            worldIn.addEntity(eoc);
            playerIn.getHeldItem(handIn).shrink(1);
            playerIn.playSound(SoundInit.ENTITYBOSSROAR.get(), 1, 1);
        }
        return ActionResult.resultConsume(playerIn.getHeldItem(handIn));
    }
}
