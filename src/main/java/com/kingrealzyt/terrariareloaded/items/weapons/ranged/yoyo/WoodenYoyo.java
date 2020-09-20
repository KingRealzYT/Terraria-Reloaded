package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class WoodenYoyo extends AbstractYoyoItem {

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.WOODEN;
    }

    @Override
    public double getLength(ItemStack yoyoStack) {
        return 9;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 80;
    }


    @Override
    public float getDamage() {
        return 9.0F;
    }

    @Override
    public float getKnockback() {
        return 2.5F;
    }

}
