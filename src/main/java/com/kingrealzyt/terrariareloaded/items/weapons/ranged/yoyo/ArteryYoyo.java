package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class ArteryYoyo extends AbstractYoyoItem {

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.ARTERY;
    }

    @Override
    public double getLength(ItemStack yoyoStack) {
        return 12.5;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 120;
    }


    @Override
    public float getDamage() {
        return 17.0F;
    }

    @Override
    public float getKnockback() {
        return 4;
    }
}
