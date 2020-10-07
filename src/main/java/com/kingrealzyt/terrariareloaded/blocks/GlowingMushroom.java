package com.kingrealzyt.terrariareloaded.blocks;

import com.kingrealzyt.terrariareloaded.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class GlowingMushroom extends MushroomBlock implements IPlantable {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
    public GlowingMushroom() {
        super(Properties.create(Material.PLANTS)
                .hardnessAndResistance(0.0f, 0.0f)
                .sound(SoundType.PLANT)
                .harvestLevel(0)
                .notSolid()
                .doesNotBlockMovement()
                .lightValue(12)
        );
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        BlockState blockstate = worldIn.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block == ModBlocks.MUSHROOM_GRASS_BLOCK.get()) {
            return true;
        } else {
            return false;
        }
    }
}
