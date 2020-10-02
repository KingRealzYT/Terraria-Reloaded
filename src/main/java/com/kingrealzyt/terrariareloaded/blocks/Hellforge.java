package com.kingrealzyt.terrariareloaded.blocks;


import com.kingrealzyt.terrariareloaded.init.ModTileEntityTypes;
import com.kingrealzyt.terrariareloaded.tileentities.HellforgeTileEntity;
import com.kingrealzyt.terrariareloaded.util.HellforgeItemHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.stream.Stream;

public class Hellforge extends Block implements IWaterLoggable {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0.5, 4, 9.5, 15.5, 15, 15.5),
            Block.makeCuboidShape(0, 0, 1, 16, 1, 16),
            Block.makeCuboidShape(0.5, 1, 2.5, 15.5, 5, 15.5),
            Block.makeCuboidShape(0, 5, 0.5, 3, 8, 9.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(0.5, 4, 0.5, 6.5, 15, 15.5),
            Block.makeCuboidShape(0, 0, 0, 15, 1, 16),
            Block.makeCuboidShape(0.5, 1, 0.5, 13.5, 5, 15.5),
            Block.makeCuboidShape(6.5, 5, 0, 15.5, 8, 3)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0.5, 4, 0.5, 15.5, 15, 6.5),
            Block.makeCuboidShape(0, 0, 0, 16, 1, 15),
            Block.makeCuboidShape(0.5, 1, 0.5, 15.5, 5, 13.5),
            Block.makeCuboidShape(13, 5, 6.5, 16, 8, 15.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
        }).get();
    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(9.5, 4, 0.5, 15.5, 15, 15.5),
            Block.makeCuboidShape(1, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(2.5, 1, 0.5, 15.5, 5, 15.5),
            Block.makeCuboidShape(0.5, 5, 13, 9.5, 8, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
        }).get();


    public Hellforge(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }


    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
                                             Hand handIn, BlockRayTraceResult hit) {
        System.out.println("you go");
        if (worldIn != null && !worldIn.isRemote) {
            System.out.print("to hell");
            TileEntity tile = worldIn.getTileEntity(pos);
            if (tile instanceof HellforgeTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tile, pos);
                System.out.print("before you die");
            }
        }
        return ActionResultType.SUCCESS;
    }


    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        TileEntity tile = worldIn.getTileEntity(pos);
        if (tile instanceof HellforgeTileEntity && state.getBlock() != newState.getBlock()) {
            HellforgeTileEntity furnace = (HellforgeTileEntity) tile;
            ((HellforgeItemHandler) furnace.getInventory()).toNonNullList().forEach(item -> {
                ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), item);
                worldIn.addEntity(itemEntity);
            });
        }

        if (state.hasTileEntity() && state.getBlock() != newState.getBlock()) {
            worldIn.removeTileEntity(pos);
        }
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
        return this.getDefaultState()
                .with(FACING, context.getPlacementHorizontalFacing().getOpposite());
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
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6f;
    }

    @Override
    public boolean hasTileEntity() {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.HELLFORGE.get().create();
    }

    @Override
    public int getLightValue(BlockState state) {
        return 11;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        System.out.println("ok you placed it");
        if(stack.hasDisplayName()) {
            System.out.println("has display name");
            TileEntity tile = worldIn.getTileEntity(pos);
            if(tile instanceof HellforgeTileEntity) {
                System.out.println("is hellforge tile entity    ");
                ((HellforgeTileEntity) tile).setCustomName(stack.getDisplayName());
            }

        }

    }


    @Override
    public boolean hasComparatorInputOverride(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
        return Container.calcRedstone(worldIn.getTileEntity(pos));
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {

        double d0 = (double) pos.getX() + 0.5D;
        double d1 = (double) pos.getY();
        double d2 = (double) pos.getZ() + 0.5D;
        if (rand.nextDouble() < 0.1D) {
            worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F,
                    false);
        }

        Direction direction = stateIn.get(FACING);
        Direction.Axis direction$axis = direction.getAxis();
        double d4 = rand.nextDouble() * 0.6D - 0.3D;
        double d5 = direction$axis == Direction.Axis.X ? (double) direction.getXOffset() * 0.52D : d4;
        double d6 = rand.nextDouble() * 6.0D / 16.0D;
        double d7 = direction$axis == Direction.Axis.Z ? (double) direction.getZOffset() * 0.52D : d4;
        worldIn.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);

    }


}

