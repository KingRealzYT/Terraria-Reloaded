package com.kingrealzyt.terrariareloaded.shop;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class Offer {

    private Price price;
    private Item output;

    public Offer(Price price, Item output) {
        this.price = price;
        this.output = output;
    }

    public Item getOutput() {
        return output;
    }

    public Price getPrice() {
        return price;
    }

    public CompoundNBT getNbtTag() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.put("Output", output.getDefaultInstance().write(new CompoundNBT()));
        nbt.put("Price", price.getNbtTag());
        return nbt;
    }

    public static Offer read(CompoundNBT tag) {
        ItemStack output = ItemStack.read(tag.getCompound("Output"));
        return new Offer(Price.read(tag.getCompound("Price")), output.getItem());
    }
}
