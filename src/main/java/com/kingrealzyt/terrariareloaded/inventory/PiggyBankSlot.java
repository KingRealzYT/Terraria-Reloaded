package com.kingrealzyt.terrariareloaded.inventory;

import com.kingrealzyt.terrariareloaded.init.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class PiggyBankSlot extends Slot {

    public PiggyBankSlot(IInventory inventory, int index, int xPosition, int yPosition) {
        super(inventory, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() == ModItems.COPPER_COIN.get() || stack.getItem() == ModItems.SILVER_COIN.get()
                || stack.getItem() == ModItems.GOLD_COIN.get() || stack.getItem() == ModItems.PLATINUM_COIN.get();
    }

}
