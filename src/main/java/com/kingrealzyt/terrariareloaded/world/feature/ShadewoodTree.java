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


public class ShadewoodTree extends Tree {

    public static final TreeFeatureConfig SHADEWOOD_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(ModBlocks.SHADEWOOD_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(ModBlocks.SHADEWOOD_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(40, 1))).baseHeight(9).heightRandA(5).foliageHeight(10).ignoreVines()
            .setSapling((IPlantable) ModBlocks.SHADEWOOD_SAPLING.get()).build();

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(SHADEWOOD_TREE_CONFIG);
    }
}