package com.kingrealzyt.terrariareloaded.inventory;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;

public class PiggyBankInventory extends Inventory {

    public PiggyBankInventory() {
        super(27);
    }

    @Override
    public int getInventoryStackLimit() {
        return 100;
    }

    public ListNBT write() {
        ListNBT list = new ListNBT();
        for(int i = 0; i < this.getSizeInventory(); i++) {
            ItemStack itemstack = this.getStackInSlot(i);
            if(!itemstack.isEmpty()) {
                CompoundNBT nbt = new CompoundNBT();
                nbt.putInt("Slot", i);
                nbt.put("Item", itemstack.write(new CompoundNBT()));
                list.add(nbt);
            }
        }
        return list;
    }

    public void read(ListNBT list) {
        for (INBT inbt : list) {
            if(!(inbt instanceof CompoundNBT))
                throw new IllegalStateException("Can not read piggy bank inventory, list has a invalid object");
            CompoundNBT nbt = (CompoundNBT) inbt;
            int slot = nbt.getInt("Slot");
            ItemStack itemstack = ItemStack.read(nbt.getCompound("Item"));
            this.setInventorySlotContents(slot, itemstack);
        }
    }

}
