package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class YeletsYoyo extends AbstractYoyoItem{

    @Override
    public float getDamage() {
        return 60;
    }

    @Override
    public float getKnockback() {
        return 3.1F;
    }

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.YELETS;
    }


    @Override
    public double getLength(ItemStack yoyoStack) {
        return 18;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 280;
    }


}
