package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class GradientYoyo extends AbstractYoyoItem{

    @Override
    public float getDamage() {
        return 44;
    }

    @Override
    public float getKnockback() {
        return 3.8F;
    }

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.GRADIENT;
    }


    @Override
    public double getLength(ItemStack yoyoStack) {
        return 15.5;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 200;
    }

}
