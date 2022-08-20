package com.rigged.riggedcraft.block.custom;

import com.rigged.riggedcraft.registry.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FirerBlock extends HorizontalFacingBlock {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    private static VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 7, 16);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if(entity instanceof ItemEntity itemEntity){
            if(itemEntity.getStack().getItem() == ModItems.HAVENITE){

                if(!world.isClient()){
                    ItemStack firedStack = new ItemStack(ModItems.FIRED_HAVENITE);
                    firedStack.setCount(itemEntity.getStack().getCount());

                    itemEntity.kill();

                    ItemEntity firedStackEntity = new ItemEntity(EntityType.ITEM, world);
                    firedStackEntity.setStack(firedStack);
                    firedStackEntity.setPos(itemEntity.getX(), itemEntity.getY(), itemEntity.getZ());

                    world.spawnEntity(firedStackEntity);
                }
                else{
                    entity.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH, 0.3f, 1.0f);
                }
            }
        }

        super.onLandedUpon(world, state, pos, entity, fallDistance);
    }

    public FirerBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
