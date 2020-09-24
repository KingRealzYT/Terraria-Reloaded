package com.kingrealzyt.terrariareloaded.blocks;

import com.google.common.collect.Lists;
import com.kingrealzyt.terrariareloaded.data.ILootTableData;
import com.kingrealzyt.terrariareloaded.data.LootTableDataHelper;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraft.world.storage.loot.conditions.SurvivesExplosion;
import net.minecraft.world.storage.loot.functions.ILootFunction;
import net.minecraftforge.common.ToolType;

import java.util.List;

public class HiveBlock extends Block {

    public HiveBlock() {
        super(Properties.create(Material.CORAL)
            .hardnessAndResistance(1.0F, 1.0F)
            .sound(SoundType.CORAL)
            .harvestLevel(1)
            .harvestTool(ToolType.PICKAXE));
    }
}
