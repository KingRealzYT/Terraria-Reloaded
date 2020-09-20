package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class KrakenYoyo extends AbstractYoyoItem{

    @Override
    public float getDamage() {
        return 95;
    }

    @Override
    public float getKnockback() {
        return 4.3F;
    }

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.KRAKEN;
    }


    @Override
    public double getLength(ItemStack yoyoStack) {
        return 21;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 1200;
    }

}
