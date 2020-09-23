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

public class PiggyBank extends Block implements IWaterLoggable {


    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    //WATERLOG
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    //WATERLOG
    public FluidState getFluidState(BlockState state) {
        return (FluidState) (state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state));
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(10.25, 5.5, 3, 11.25, 6.5, 4),
            Block.makeCuboidShape(5, 1.5, 3.5, 11, 7.5, 13.5),
            Block.makeCuboidShape(6, 2.5, 2, 10, 5.5, 4),
            Block.makeCuboidShape(5.5, 0, 4.5, 7.5, 2, 6.5),
            Block.makeCuboidShape(8.25, 0, 4.5, 10.25, 2, 6.5),
            Block.makeCuboidShape(8.25, 0, 10.5, 10.25, 2, 12.5),
            Block.makeCuboidShape(5.5, 0, 10.5, 7.5, 2, 12.5),
            Block.makeCuboidShape(7.5, 4, 13.5, 8.5, 6, 14.5),
            Block.makeCuboidShape(4.75, 5.5, 3, 5.75, 6.5, 4)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    public static final VoxelShape SHAPE_E = SHAPE_N;

    public static final VoxelShape SHAPE_S = SHAPE_N;

    public static final VoxelShape SHAPE_W = SHAPE_N;


    public PiggyBank() {
        super(Properties.create(Material.ANVIL)
        .hardnessAndResistance(1.5f, 1.0f)
        .sound(SoundType.ANVIL)
        .harvestLevel(0)
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

