package com.kingrealzyt.terrariareloaded.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class ShadewoodSapling extends Block {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0F, 12.0D, 14.0D);
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
    public ShadewoodSapling() {
        super(Properties.create(Material.PLANTS)
            .hardnessAndResistance(1.0F, 1.0F)
            .sound(SoundType.PLANT)
            .notSolid()
            .doesNotBlockMovement()
            .harvestLevel(0));
    }

}
