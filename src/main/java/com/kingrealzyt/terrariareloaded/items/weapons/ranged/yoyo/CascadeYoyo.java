package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class CascadeYoyo extends AbstractYoyoItem{

    @Override
    public float getDamage() {
        return 27;
    }

    @Override
    public float getKnockback() {
        return 4.3F;
    }

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.CASCADE;
    }


    @Override
    public double getLength(ItemStack yoyoStack) {
        return 15.5;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 320;
    }

}
