package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class RallyYoyo extends AbstractYoyoItem {

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.RALLY;
    }


    @Override
    public double getLength(ItemStack yoyoStack) {
        return 10;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 100;
    }



    @Override
    public float getDamage() {
        return 14.0F;
    }

    @Override
    public float getKnockback() {
        return 3.5F;
    }

}
