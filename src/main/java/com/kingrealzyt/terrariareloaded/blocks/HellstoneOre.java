package com.kingrealzyt.terrariareloaded.blocks;

import com.google.common.collect.Lists;
import com.kingrealzyt.terrariareloaded.data.ILootTableData;
import com.kingrealzyt.terrariareloaded.data.LootTableDataHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraft.world.storage.loot.conditions.SurvivesExplosion;
import net.minecraft.world.storage.loot.functions.ILootFunction;
import net.minecraftforge.common.ToolType;

import java.util.List;

public class HellstoneOre extends OreBlock implements ILootTableData {

    public HellstoneOre() {
        super(Properties.create(Material.IRON)
            .hardnessAndResistance(6.0F, 100.0F)
            .sound(SoundType.METAL)
            .harvestLevel(3)
            .harvestTool(ToolType.PICKAXE));
    }

    @Override
    public NonNullList<Item> getDrops() {
        return null;
    }

    @Override
    public List<ILootCondition.IBuilder> lootConditions() {
        return Lists.newArrayList(SurvivesExplosion.builder());
    }

    @Override
    public List<ILootFunction.IBuilder> lootFunctions() {
        return Lists.newArrayList(LootTableDataHelper.APPLY_BONUS, LootTableDataHelper.EXPLOSION_DECAY);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        super.onEntityCollision(state, worldIn, pos, entityIn);
        entityIn.setFire(1);
    }

    @Override
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        super.onPlayerDestroy(worldIn, pos, state);
        worldIn.setBlockState(pos, Blocks.LAVA.getDefaultState(), 1);
    }
}
