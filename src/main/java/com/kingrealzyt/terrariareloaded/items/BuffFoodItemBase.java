package com.kingrealzyt.terrariareloaded.items;

import io.netty.util.internal.SuppressJava6Requirement;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class BuffFoodItemBase extends Item {

    private final Supplier<List<ITextComponent>> description;

    public BuffFoodItemBase(int hunger, float saturation, Effect effect, int duration, int amplifier, int probability, Supplier<List<ITextComponent>> description) {
        super(new Item.Properties().food(new Food.Builder().hunger(hunger).saturation(saturation).effect(new EffectInstance(effect, duration, amplifier), probability).build()));
        this.description = description;
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        if(this.description == null || this.description.get() == null)
            return;
        tooltip.addAll(this.description.get());
    }
}
