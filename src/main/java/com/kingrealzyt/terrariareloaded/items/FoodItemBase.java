package com.kingrealzyt.terrariareloaded.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import java.util.List;

public class FoodItemBase extends Item {
    public FoodItemBase(int hunger, float saturation) {
        super(new Item.Properties().food(new Food.Builder().hunger(hunger).saturation(saturation).build()));
    }
}
