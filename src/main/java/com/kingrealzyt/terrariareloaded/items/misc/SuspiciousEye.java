package com.kingrealzyt.terrariareloaded.items.misc;

import java.util.List;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import com.kingrealzyt.terrariareloaded.init.ModEntityTypes;
import com.kingrealzyt.terrariareloaded.init.SoundInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

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
    	ItemStack itemstack = playerIn.getHeldItem(handIn);
    	playerIn.getCooldownTracker().setCooldown(this, 20);
    	
    	List<EOCEntity> eocs = worldIn.getEntitiesWithinAABB(EOCEntity.class, new AxisAlignedBB(new BlockPos(playerIn.getPosX() - 150, playerIn.getPosY() - 150, playerIn.getPosZ() - 150), new BlockPos(playerIn.getPosX() + 150, playerIn.getPosY() + 150, playerIn.getPosZ() + 150)));
		if (eocs.size() > 0) {
			return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
		}
		
		float posX = 0, posY = worldIn.rand.nextInt(20) - 10, posZ = 0;
	    	
		if (worldIn.getDayTime() % 24000L > 15000 && worldIn.getDayTime() % 24000L < 22000) {
			playerIn.playSound(SoundInit.ENTITYBOSSROAR.get(), 1, 1);
			EOCEntity eoc = ModEntityTypes.EOC.create(worldIn, null, null, null, playerIn.getPosition(), SpawnReason.EVENT, false, false);
			eoc.setPosition(playerIn.getPosition().getX() + posX, playerIn.getPosition().getY() + posY, playerIn.getPosition().getZ() + posZ);
			worldIn.addEntity(eoc);
			playerIn.getHeldItem(handIn).shrink(1);
		}
		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
    }
}
