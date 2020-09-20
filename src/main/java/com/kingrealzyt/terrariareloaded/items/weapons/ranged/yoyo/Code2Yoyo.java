package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class Code2Yoyo extends AbstractYoyoItem {

    @Override
    public float getDamage() {
        return 54;
    }

    @Override
    public float getKnockback() {
        return 3.8F;
    }

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.CODE_2;
    }


    @Override
    public double getLength(ItemStack yoyoStack) {
        return 18;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 1200; //If it is unlimited, then a minute
    }

}
