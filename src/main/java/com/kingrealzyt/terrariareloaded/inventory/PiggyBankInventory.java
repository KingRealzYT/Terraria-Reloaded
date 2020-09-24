package com.kingrealzyt.terrariareloaded.inventory;

import com.kingrealzyt.terrariareloaded.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;

public class PiggyBankInventory extends Inventory {

    private int copperAmount = 0;
    private int silverAmount = 0;
    private int goldAmount = 0;
    private int platinumAmount = 0;

    public PiggyBankInventory() {
        super(27);
    }

    @Override
    public int getInventoryStackLimit() {
        return 999;
    }

    public int getCopperAmount() {
        return copperAmount;
    }

    public int getSilverAmount() {
        return silverAmount;
    }

    public int getGoldAmount() {
        return goldAmount;
    }

    public int getPlatinumAmount() {
        return platinumAmount;
    }

    @Override
    public ItemStack addItem(ItemStack stack) {
        this.increaseAmount(stack);
        return super.addItem(stack);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        this.decreaseAmount(this.getStackInSlot(index));
        return super.decrStackSize(index, count);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        super.setInventorySlotContents(index, stack);
        this.increaseAmount(stack);
    }

    private void decreaseAmount(ItemStack itemstack) {
        if(itemstack.getItem() == ModItems.COPPER_COIN.get())
            this.copperAmount -= itemstack.getCount();
        if(itemstack.getItem() == ModItems.SILVER_COIN.get())
            this.silverAmount -= itemstack.getCount();
        if(itemstack.getItem() == ModItems.GOLD_COIN.get())
            this.goldAmount -= itemstack.getCount();
        if(itemstack.getItem() == ModItems.PLATINUM_COIN.get())
            this.platinumAmount -= itemstack.getCount();
    }

    private void increaseAmount(ItemStack itemstack) {
        if(itemstack.getItem() == ModItems.COPPER_COIN.get())
            this.copperAmount += itemstack.getCount();
        if(itemstack.getItem() == ModItems.SILVER_COIN.get())
            this.silverAmount += itemstack.getCount();
        if(itemstack.getItem() == ModItems.GOLD_COIN.get())
            this.goldAmount += itemstack.getCount();
        if(itemstack.getItem() == ModItems.PLATINUM_COIN.get())
            this.platinumAmount += itemstack.getCount();
    }

    public ListNBT write() {
        ListNBT list = new ListNBT();
        for (int i = 0; i < this.getSizeInventory(); i++) {
            ItemStack itemstack = this.getStackInSlot(i);
            if (!itemstack.isEmpty()) {
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
            if (!(inbt instanceof CompoundNBT))
                throw new IllegalStateException("Can not read piggy bank inventory, list has a invalid object");
            CompoundNBT nbt = (CompoundNBT) inbt;
            int slot = nbt.getInt("Slot");
            ItemStack itemstack = ItemStack.read(nbt.getCompound("Item"));
            this.increaseAmount(itemstack);
            this.setInventorySlotContents(slot, itemstack);
        }
    }

}
