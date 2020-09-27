package com.kingrealzyt.terrariareloaded.items;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LifeFruitItem extends Item {

    public LifeFruitItem() {
        super(new Properties().group(TerrariaReloaded.MISC));
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        String path = stack.getItem().getRegistryName().getPath();
        if (path.equals("copper_coin") || path.equals("silver_coin") || path.equals("gold_coin"))
            return 100;
        if (path.equals("platinum_coin"))
            return 999;
        return super.getItemStackLimit(stack);
    }

}
