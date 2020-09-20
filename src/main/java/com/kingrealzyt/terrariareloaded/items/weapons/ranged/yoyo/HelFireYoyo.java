package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class HelFireYoyo extends AbstractYoyoItem{

    @Override
    public float getDamage() {
        return 45;
    }

    @Override
    public float getKnockback() {
        return 4.5F;
    }

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.HEL_FIRE;
    }


    @Override
    public double getLength(ItemStack yoyoStack) {
        return 17;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 240;
    }

}
