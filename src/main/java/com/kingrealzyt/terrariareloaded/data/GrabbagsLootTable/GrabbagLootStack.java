package com.kingrealzyt.terrariareloaded.data.GrabbagsLootTable;


import net.minecraft.item.Item;

import java.util.Random;

public class GrabbagLootStack {
    public Item loot;
    public int min;
    public int max;
    public Item secondLoot;
    public int secondValue;

    public GrabbagLootStack(Item loot, int min, int max) {
        this.loot = loot;
        this.min = min;
        this.max = max;
    }

    public GrabbagLootStack(Item loot, int min, int max, Item secondLoot, int secondValue) {
        this.loot = loot;
        this.min = min;
        this.max = max;
        this.secondLoot = secondLoot;
        this.secondValue = secondValue;
    }

    public int getAmount(Random rand) {
        return (rand.nextInt(max - min) + min);
    }

}
