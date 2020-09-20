package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class MalaiseYoyo extends AbstractYoyoItem {

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.MALAISE;
    }


    @Override
    public double getLength(ItemStack yoyoStack) {
        return 14;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 140;
    }


    @Override
    public float getDamage() {
        return 16;
    }

    @Override
    public float getKnockback() {
        return 4.5F;
    }

}
