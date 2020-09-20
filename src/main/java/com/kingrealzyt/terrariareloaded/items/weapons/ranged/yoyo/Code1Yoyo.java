package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class Code1Yoyo extends AbstractYoyoItem{

    @Override
    public float getDamage() {
        return 21;
    }

    @Override
    public float getKnockback() {
        return 3.25F;
    }

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.CODE_1;
    }


    @Override
    public double getLength(ItemStack yoyoStack) {
        return 13.5;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 180;
    }

}
