package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class AmazonYoyo extends AbstractYoyoItem {


    @Override
    public YoyoType getYoyoType() {
        return YoyoType.AMAZON;
    }


    @Override
    public double getLength(ItemStack yoyoStack) {
        return 13.0;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 160;
    }


    @Override
    public float getDamage() {
        return 18.0F;
    }

    @Override
    public float getKnockback() {
        return 3.75F;
    }
}
