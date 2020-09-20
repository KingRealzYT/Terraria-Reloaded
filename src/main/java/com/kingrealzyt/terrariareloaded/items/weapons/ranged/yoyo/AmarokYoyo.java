package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class AmarokYoyo extends AbstractYoyoItem{

    @Override
    public float getDamage() {
        return 47;
    }

    @Override
    public float getKnockback() {
        return 2.8F;
    }

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.AMAROK;
    }


    @Override
    public double getLength(ItemStack yoyoStack) {
        return 16.5;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 300;
    }

}
