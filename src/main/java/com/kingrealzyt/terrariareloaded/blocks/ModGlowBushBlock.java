package com.kingrealzyt.terrariareloaded.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;

public class ModGlowBushBlock extends BushBlock implements IPlantable {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0F, 12.0D, 14.0D);

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
    public ModGlowBushBlock() {
        super(Properties.create(Material.PLANTS)
                .hardnessAndResistance(0.0f, 0.0f)
                .sound(SoundType.PLANT)
                .harvestLevel(0)
                .notSolid()
                .doesNotBlockMovement()
                .lightValue(11)
        );
    }
}
