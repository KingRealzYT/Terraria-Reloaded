package com.kingrealzyt.terrariareloaded.items;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Supplier;

public class FoodItemBase extends Item {

    private final Supplier<List<ITextComponent>> description;

    public FoodItemBase(int hunger, float saturation, Supplier<List<ITextComponent>> description) {

        super(new Item.Properties()
                .group(TerrariaReloaded.FOOD)
                .food(new Food.Builder()
                        .hunger(hunger)
                        .saturation(saturation)
                        .build())



        );
        this.description = description;

    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(this.description != null && this.description.get() != null)
            tooltip.addAll(this.description.get());
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
