package com.kingrealzyt.terrariareloaded.items;

import com.kingrealzyt.terrariareloaded.init.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class MagicMirror extends Item {

    public MagicMirror() {
        super(new Item.Properties().group(ItemGroup.MISC));
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("Gaze in the mirror to return home"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        BlockPos cords =  playerIn.getBedLocation(playerIn.dimension);
        if(cords == null)
            cords = worldIn.getSpawnPoint();
        playerIn.setPositionAndUpdate(cords.getX(), cords.getY(), cords.getZ());
        playerIn.getCooldownTracker().setCooldown(this, 200);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
