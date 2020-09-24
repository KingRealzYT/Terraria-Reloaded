package com.kingrealzyt.terrariareloaded.items;

import io.netty.util.internal.SuppressJava6Requirement;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

@SuppressWarnings("deprecation")
public class BuffFoodItemBase extends Item{
    public BuffFoodItemBase(int hunger, float saturation, Effect effect, int duration, int amplifier, int probability) {
        super(new Item.Properties().food(new Food.Builder().hunger(hunger).saturation(saturation).effect(new EffectInstance(effect, duration, amplifier), probability).build()));
    }
}
