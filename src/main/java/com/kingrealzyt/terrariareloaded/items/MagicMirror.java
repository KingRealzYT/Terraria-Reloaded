package com.kingrealzyt.terrariareloaded.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagicMirror extends Item {

    public MagicMirror() {
        super(new Item.Properties().group(ItemGroup.MISC));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        BlockPos cords =  playerIn.getBedLocation(playerIn.dimension);
        if(cords == null)
            cords = worldIn.getSpawnPoint();
        playerIn.setPositionAndUpdate(cords.getX(), cords.getY(), cords.getZ());
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
