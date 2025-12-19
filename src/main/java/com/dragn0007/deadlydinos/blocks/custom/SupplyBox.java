package com.dragn0007.deadlydinos.blocks.custom;

import com.dragn0007.deadlydinos.blocks.DecorRotator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class SupplyBox extends DecorRotator implements SimpleWaterloggedBlock {

    public SupplyBox() {
        super(NORTH, EAST, SOUTH, WEST, Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.STONE).noOcclusion().strength(0.2f, 0.2f));
    }

    public boolean isPathfindable(BlockState p_53306_, BlockGetter p_53307_, BlockPos p_53308_, PathComputationType p_53309_) {
        return false;
    }

    public static final VoxelShape NORTH = Stream.of(
            Block.box(0.6999999999999993, 0, 2.700000000000001, 15.3, 8, 13.299999999999999)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();

    public static final VoxelShape EAST = Stream.of(
            Block.box(2.700000000000001, 0, 0.6999999999999993, 13.299999999999999, 8, 15.3)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();

    public static final VoxelShape SOUTH = Stream.of(
            Block.box(0.6999999999999993, 0, 2.700000000000001, 15.3, 8, 13.299999999999999)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();

    public static final VoxelShape WEST = Stream.of(
            Block.box(2.700000000000001, 0, 0.6999999999999993, 13.299999999999999, 8, 15.3)
    ).reduce((v1, v2) -> Shapes.join(v1, v2,BooleanOp.OR)).get();

    @Override
    public boolean isCollisionShapeFullBlock(BlockState p_181242_, BlockGetter p_181243_, BlockPos p_181244_) {
        return false;
    }
}
