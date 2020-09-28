package com.kingrealzyt.terrariareloaded.util.enums;

import com.kingrealzyt.terrariareloaded.init.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    COPPER(2, 0, 4.0F, 3.0F, 5, () -> { return Ingredient.fromItems(ModItems.COPPER_INGOT.get()); }),
    SILVER(2, 0, 4.0F, 3.0F, 5, () -> { return Ingredient.fromItems(ModItems.SILVER_INGOT.get()); }),
    PLATINUM(2, 0, 4.0F, 3.0F, 5, () -> { return Ingredient.fromItems(ModItems.PLATINUM_INGOT.get()); }),
    DEMONITE(2, 0, 4.0F, 3.0F, 5, () -> { return Ingredient.fromItems(ModItems.DEMONITE_INGOT.get()); }),
    CRIMTANE(2, 0, 4.0F, 3.0F, 5, () -> { return Ingredient.fromItems(ModItems.CRIMTANE_INGOT.get()); }),
    HELLSTONE(2, 0, 4.0F, 3.0F, 5, () -> { return Ingredient.fromItems(ModItems.SILVER_INGOT.get()); }),
    METEOR(2, 0, 4.0F, 3.0F, 5, () -> { return Ingredient.fromItems(ModItems.SILVER_INGOT.get()); }),
    COBALT(2, 0, 4.0F, 3.0F, 5, () -> { return Ingredient.fromItems(ModItems.COBALT_INGOT.get()); }),
    HALLOWED(3, 0, 8.0F, 3.0F, 10, () -> { return Ingredient.fromItems(ModItems.PICKAXE_AXE.get()); }),
    PICKSAW(3, 0, 8.0F, 3.0F, 10, () -> { return Ingredient.fromItems(ModItems.PICKSAW.get()); });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}
