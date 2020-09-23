package com.kingrealzyt.terrariareloaded.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class PiggyBankSlot extends Slot {

    public PiggyBankSlot(IInventory inventory, int index, int xPosition, int yPosition) {
        super(inventory, index, xPosition, yPosition);
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 100;
    }
}
