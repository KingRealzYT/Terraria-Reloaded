package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class FormatCYoyo extends AbstractYoyoItem{

    @Override
    public float getDamage() {
        return 35;
    }

    @Override
    public float getKnockback() {
        return 3.25F;
    }

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.FORMAT_C;
    }


    @Override
    public double getLength(ItemStack yoyoStack) {
        return 16;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 160;
    }

}
