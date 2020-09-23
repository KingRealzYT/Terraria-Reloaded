package com.kingrealzyt.terrariareloaded.items;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MiscItemBase extends Item {

    public MiscItemBase() {
        super(new Item.Properties().group(TerrariaReloaded.MISC));
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        String path = stack.getItem().getRegistryName().getPath();
        if (path.equals("copper_coin") || path.equals("silver_coin") || path.equals("gold_coin") || path.equals("platinum_coin"))
            return 100;
        return super.getItemStackLimit(stack);
    }

}
