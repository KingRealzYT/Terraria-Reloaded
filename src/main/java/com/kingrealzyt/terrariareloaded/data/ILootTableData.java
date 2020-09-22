package com.kingrealzyt.terrariareloaded.data;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraft.world.storage.loot.functions.ILootFunction;

import java.util.List;
import java.util.Objects;

public interface ILootTableData {

    /**
     * @return a list of items, that should be droped
     */
    NonNullList<Item> getDrops();

    /**
     * Loot conditions can be found in the {@link LootTableDataHelper} class, or in the
     * {@link net.minecraft.world.storage.loot.conditions} package
     *
     * @return a list of loot conditions or null, if you want no conditions
     */
    List<ILootCondition.IBuilder> lootConditions();

    /**
     * Loot functions can be found in the {@link LootTableDataHelper} class, or in the
     * {@link net.minecraft.world.storage.loot.functions} package
     *
     * @return a list of loot functions or null, if you want no loot function
     */
    List<ILootFunction.IBuilder> lootFunctions();

    /**
     * You can use this method to create easier a {@link NonNullList} list
     *
     * @param drops the item drops
     * @return a list with the items who should be dropped
     */
    default NonNullList<Item> createList(Item... drops) {
        Objects.requireNonNull(drops, "Cannot create drops list, drops are null");
        NonNullList<Item> list = NonNullList.withSize(drops.length, ItemStack.EMPTY.getItem());
        for(int i = 0; i < drops.length; i++)
            list.set(i, drops[i]);
        return list;
    }

}
