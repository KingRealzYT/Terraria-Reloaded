package com.kingrealzyt.terrariareloaded.blocks;

import com.google.common.collect.Lists;
import com.kingrealzyt.terrariareloaded.container.PiggyBankContainer;
import com.kingrealzyt.terrariareloaded.world.capability.CapabilityAccessor;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraft.world.storage.loot.conditions.SurvivesExplosion;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.List;
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
    }).get();;
    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0.5, 4, 0.5, 15.5, 15, 6.5),
            Block.makeCuboidShape(0, 0, 0, 16, 1, 15),
            Block.makeCuboidShape(0.5, 1, 0.5, 15.5, 5, 13.5),
            Block.makeCuboidShape(13, 5, 6.5, 16, 8, 15.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
        }).get();;
    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(9.5, 4, 0.5, 15.5, 15, 15.5),
            Block.makeCuboidShape(1, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(2.5, 1, 0.5, 15.5, 5, 15.5),
            Block.makeCuboidShape(0.5, 5, 13, 9.5, 8, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
        }).get();;


    public Hellforge() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(3.5f, 1.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
        );
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            NetworkHooks.openGui((ServerPlayerEntity) player, new SimpleNamedContainerProvider((id, inventory, playerEntity) ->
                    new PiggyBankContainer(id, inventory, CapabilityAccessor.getPlayerCoinCapability(playerEntity).getPiggyBankInventory()), new StringTextComponent("Piggy Bank")));
            return ActionResultType.SUCCESS;
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
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
}

