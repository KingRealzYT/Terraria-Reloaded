package com.kingrealzyt.terrariareloaded.items;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.init.ModItems;
import com.kingrealzyt.terrariareloaded.init.SoundInit;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.EndDimension;
import net.minecraft.world.dimension.NetherDimension;
import net.minecraft.world.dimension.OverworldDimension;
import net.minecraftforge.client.event.sound.PlaySoundEvent;

import java.util.List;

public class MagicMirror extends Item {

    public MagicMirror() {
        super(new Item.Properties().group(TerrariaReloaded.MISC));
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("Gaze in the mirror to return home"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        worldIn.playSound(playerIn, playerIn.getPosition(), SoundInit.MAGICMIRRORUSE.get(), SoundCategory.BLOCKS, 1, 1);
        BlockPos cords =  playerIn.getBedLocation(playerIn.dimension);
        if(cords == null)
            cords = worldIn.getSpawnPoint();
        if(worldIn.dimension instanceof NetherDimension || worldIn.dimension instanceof EndDimension){}
        else
        {
            playerIn.setPositionAndUpdate(cords.getX(), cords.getY(), cords.getZ());
        }
        playerIn.getCooldownTracker().setCooldown(this, 200);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
