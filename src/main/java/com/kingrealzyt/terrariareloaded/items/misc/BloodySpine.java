package com.kingrealzyt.terrariareloaded.items.misc;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class BloodySpine extends Item {

    public BloodySpine() {
        super(new Properties().group(TerrariaReloaded.BOSS));
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("Summons the Brain of Cthulhu"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }


}
