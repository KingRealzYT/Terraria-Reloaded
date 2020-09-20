package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class TerrarianYoyo extends AbstractYoyoItem{

    @Override
    public float getDamage() {
        return 190;
    }

    @Override
    public float getKnockback() {
        return 6.5F;
    }

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.TERRARIAN;
    }

    @Override
    public double getLength(ItemStack yoyoStack) {
        return 25;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 1200;
    }

}
