package com.kingrealzyt.terrariareloaded.items.misc;

import net.minecraft.advancements.criterion.MobEffectsPredicate;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class ItemBand extends Item {

    public ItemBand() {
        super(new Properties().group(ItemGroup.MISC));
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("Slowly regenerates life"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }


    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        LivingEntity entity = ((LivingEntity) entityIn);
        if(entity.getHealth() < entity.getMaxHealth())
            entity.addPotionEffect(new EffectInstance(Effects.REGENERATION, 20, 0));
    }

}
