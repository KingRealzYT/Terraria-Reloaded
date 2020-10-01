package com.kingrealzyt.terrariareloaded.world.feature;

import com.kingrealzyt.terrariareloaded.init.ModBlocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class EbonwoodTree extends Tree {

    public static final TreeFeatureConfig EBONWOOD_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(ModBlocks.EBONWOOD_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(ModBlocks.EBONWOOD_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(2, 0))).baseHeight(9).heightRandA(4).foliageHeight(3).ignoreVines()
            .setSapling((IPlantable) ModBlocks.EBONWOOD_SAPLING.get()).build();

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(EBONWOOD_TREE_CONFIG);
    }
}