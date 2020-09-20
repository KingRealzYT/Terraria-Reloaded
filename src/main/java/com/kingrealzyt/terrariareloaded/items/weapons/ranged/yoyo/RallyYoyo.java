package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.item.ItemStack;

public class RallyYoyo extends AbstractYoyoItem {

    @Override
    public YoyoType getYoyoType() {
        return YoyoType.RALLY;
    }

    @Override
    public double getWeight(ItemStack yoyoStack) {
        return 1.0;
    }

    @Override
    public double getLength(ItemStack yoyoStack) {
        return 5.0;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        return 200;
    }

    @Override
    public int getAttackInterval(ItemStack yoyoStack) {
        return 20;
    }


    @Override
    public float getDamage() {
        return 10.0F;
    }

}
