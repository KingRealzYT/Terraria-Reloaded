package com.kingrealzyt.terrariareloaded.data;

import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraft.world.storage.loot.conditions.MatchTool;
import net.minecraft.world.storage.loot.functions.ApplyBonus;
import net.minecraft.world.storage.loot.functions.ExplosionDecay;
import net.minecraft.world.storage.loot.functions.ILootFunction;

public class LootTableDataHelper {

    public static ILootCondition.IBuilder matchTool(Item tool) {
        return MatchTool.builder(ItemPredicate.Builder.create().item(tool));
    }

    public static ILootCondition.IBuilder matchToolWithSilkTouch() {
        return MatchTool.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.exactly(1))));
    }

    //ORE
    public static final ILootFunction.IBuilder APPLY_BONUS = ApplyBonus.oreDrops(Enchantments.FORTUNE);
    public static final ILootFunction.IBuilder EXPLOSION_DECAY = ExplosionDecay.builder();

}
