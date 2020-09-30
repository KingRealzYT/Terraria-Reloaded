package com.kingrealzyt.terrariareloaded.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class CrystalHeart extends Block implements IWaterLoggable {


    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    //WATERLOG
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    //WATERLOG
    public FluidState getFluidState(BlockState state) {
        return (FluidState) (state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state));
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(14, 8, 7.5, 15, 13, 8.5),
            Block.makeCuboidShape(6, 1, 6.5, 10, 12, 9.5),
            Block.makeCuboidShape(10, 2, 7, 11, 13, 9),
            Block.makeCuboidShape(5, 2, 7, 6, 13, 9),
            Block.makeCuboidShape(4, 4, 7, 5, 13, 9),
            Block.makeCuboidShape(11, 4, 7, 12, 13, 9),
            Block.makeCuboidShape(12, 7, 7, 14, 13, 9),
            Block.makeCuboidShape(2, 7, 7, 4, 13, 9),
            Block.makeCuboidShape(11, 3, 7.5, 12, 4, 8.5),
            Block.makeCuboidShape(4, 3, 7.5, 5, 4, 8.5),
            Block.makeCuboidShape(2, 6, 7.5, 3, 7, 8.5),
            Block.makeCuboidShape(6, 12, 7.5, 7, 13, 8.5),
            Block.makeCuboidShape(9, 12, 7.5, 10, 13, 8.5),
            Block.makeCuboidShape(13, 6, 7.5, 14, 7, 8.5),
            Block.makeCuboidShape(10, 13, 7.5, 14, 14, 8.5),
            Block.makeCuboidShape(2, 13, 7.5, 6, 14, 8.5),
            Block.makeCuboidShape(12, 4, 7.5, 13, 7, 8.5),
            Block.makeCuboidShape(3, 4, 7.5, 4, 7, 8.5),
            Block.makeCuboidShape(1, 8, 7.5, 2, 13, 8.5),
            Block.makeCuboidShape(7, 0, 7, 9, 1, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(7.5, 8, 14, 8.5, 13, 15),
            Block.makeCuboidShape(6.5, 1, 6, 9.5, 12, 10),
            Block.makeCuboidShape(7, 2, 10, 9, 13, 11),
            Block.makeCuboidShape(7, 2, 5, 9, 13, 6),
            Block.makeCuboidShape(7, 4, 4, 9, 13, 5),
            Block.makeCuboidShape(7, 4, 11, 9, 13, 12),
            Block.makeCuboidShape(7, 7, 12, 9, 13, 14),
            Block.makeCuboidShape(7, 7, 2, 9, 13, 4),
            Block.makeCuboidShape(7.5, 3, 11, 8.5, 4, 12),
            Block.makeCuboidShape(7.5, 3, 4, 8.5, 4, 5),
            Block.makeCuboidShape(7.5, 6, 2, 8.5, 7, 3),
            Block.makeCuboidShape(7.5, 12, 6, 8.5, 13, 7),
            Block.makeCuboidShape(7.5, 12, 9, 8.5, 13, 10),
            Block.makeCuboidShape(7.5, 6, 13, 8.5, 7, 14),
            Block.makeCuboidShape(7.5, 13, 10, 8.5, 14, 14),
            Block.makeCuboidShape(7.5, 13, 2, 8.5, 14, 6),
            Block.makeCuboidShape(7.5, 4, 12, 8.5, 7, 13),
            Block.makeCuboidShape(7.5, 4, 3, 8.5, 7, 4),
            Block.makeCuboidShape(7.5, 8, 1, 8.5, 13, 2),
            Block.makeCuboidShape(7, 0, 7, 9, 1, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(14, 8, 7.5, 15, 13, 8.5),
            Block.makeCuboidShape(6, 1, 6.5, 10, 12, 9.5),
            Block.makeCuboidShape(10, 2, 7, 11, 13, 9),
            Block.makeCuboidShape(5, 2, 7, 6, 13, 9),
            Block.makeCuboidShape(4, 4, 7, 5, 13, 9),
            Block.makeCuboidShape(11, 4, 7, 12, 13, 9),
            Block.makeCuboidShape(12, 7, 7, 14, 13, 9),
            Block.makeCuboidShape(2, 7, 7, 4, 13, 9),
            Block.makeCuboidShape(11, 3, 7.5, 12, 4, 8.5),
            Block.makeCuboidShape(4, 3, 7.5, 5, 4, 8.5),
            Block.makeCuboidShape(2, 6, 7.5, 3, 7, 8.5),
            Block.makeCuboidShape(6, 12, 7.5, 7, 13, 8.5),
            Block.makeCuboidShape(9, 12, 7.5, 10, 13, 8.5),
            Block.makeCuboidShape(13, 6, 7.5, 14, 7, 8.5),
            Block.makeCuboidShape(10, 13, 7.5, 14, 14, 8.5),
            Block.makeCuboidShape(2, 13, 7.5, 6, 14, 8.5),
            Block.makeCuboidShape(12, 4, 7.5, 13, 7, 8.5),
            Block.makeCuboidShape(3, 4, 7.5, 4, 7, 8.5),
            Block.makeCuboidShape(1, 8, 7.5, 2, 13, 8.5),
            Block.makeCuboidShape(7, 0, 7, 9, 1, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(7.5, 8, 14, 8.5, 13, 15),
            Block.makeCuboidShape(6.5, 1, 6, 9.5, 12, 10),
            Block.makeCuboidShape(7, 2, 10, 9, 13, 11),
            Block.makeCuboidShape(7, 2, 5, 9, 13, 6),
            Block.makeCuboidShape(7, 4, 4, 9, 13, 5),
            Block.makeCuboidShape(7, 4, 11, 9, 13, 12),
            Block.makeCuboidShape(7, 7, 12, 9, 13, 14),
            Block.makeCuboidShape(7, 7, 2, 9, 13, 4),
            Block.makeCuboidShape(7.5, 3, 11, 8.5, 4, 12),
            Block.makeCuboidShape(7.5, 3, 4, 8.5, 4, 5),
            Block.makeCuboidShape(7.5, 6, 2, 8.5, 7, 3),
            Block.makeCuboidShape(7.5, 12, 6, 8.5, 13, 7),
            Block.makeCuboidShape(7.5, 12, 9, 8.5, 13, 10),
            Block.makeCuboidShape(7.5, 6, 13, 8.5, 7, 14),
            Block.makeCuboidShape(7.5, 13, 10, 8.5, 14, 14),
            Block.makeCuboidShape(7.5, 13, 2, 8.5, 14, 6),
            Block.makeCuboidShape(7.5, 4, 12, 8.5, 7, 13),
            Block.makeCuboidShape(7.5, 4, 3, 8.5, 7, 4),
            Block.makeCuboidShape(7.5, 8, 1, 8.5, 13, 2),
            Block.makeCuboidShape(7, 0, 7, 9, 1, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public CrystalHeart() {
        super(Properties.create(Material.ROCK)
        .hardnessAndResistance(3.5f, 4.0f)
        .sound(SoundType.STONE)
        .harvestLevel(1)
        .harvestTool(ToolType.PICKAXE)
        );
    }


    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    //WATERLOG
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        FluidState fluidstate = (FluidState) context.getWorld().getFluidState(context.getPos());
        return this.getDefaultState()
                .with(FACING, context.getPlacementHorizontalFacing().getOpposite())
                .with(WATERLOGGED, Boolean.valueOf(fluidstate.getFluid() == Fluids.WATER));
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    //WATERLOG
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6f;
    }
}

