package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class ChickYoyo extends AbstractYoyoItem{

    @Override
    public float getDamage() {
        return 38;
    }

    @Override
    public float getKnockback() {
        return 3.3F;
    }

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.CHICK;
    }

    @Override
    public double getLength(ItemStack yoyoStack) {
        return 17;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 320;
    }


}
