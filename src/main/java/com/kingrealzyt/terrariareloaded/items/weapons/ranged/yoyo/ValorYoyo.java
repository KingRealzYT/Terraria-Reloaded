package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class ValorYoyo extends AbstractYoyoItem{

    @Override
    public float getDamage() {
        return 22;
    }

    @Override
    public float getKnockback() {
        return 3.85F;
    }

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.VALOR;
    }


    @Override
    public double getLength(ItemStack yoyoStack) {
        return 14;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 220;
    }

}
