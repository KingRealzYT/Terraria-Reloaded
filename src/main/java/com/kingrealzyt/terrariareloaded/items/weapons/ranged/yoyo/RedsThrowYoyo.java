package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class RedsThrowYoyo extends AbstractYoyoItem{

    @Override
    public float getDamage() {
        return 70;
    }

    @Override
    public float getKnockback() {
        return 4.5F;
    }

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.REDS_THROW;
    }


    @Override
    public double getLength(ItemStack yoyoStack) {
        return 23;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 1200;
    }

}
