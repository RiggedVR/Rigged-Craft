package com.rigged.riggedcraft.block.custom;

import com.rigged.riggedcraft.items.ModItemsGroup;
import com.rigged.riggedcraft.registry.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
                FireStack(world, state, pos, entity, fallDistance, ModItems.FIRED_HAVENITE);
            }
            else if(itemEntity.getStack().getItem() == ModItems.FIRED_HAVENITE){
                FireStack(world, state, pos, entity, fallDistance, ModItems.HAVENITE_INGOT);
            }
            else if(itemEntity.getStack().getItem() == Items.RAW_IRON){
                FireStack(world, state, pos, entity, fallDistance, Items.IRON_INGOT);
            }
            else if(itemEntity.getStack().getItem() == Items.RAW_COPPER){
                FireStack(world, state, pos, entity, fallDistance, Items.COPPER_INGOT);
            }
            else if(itemEntity.getStack().getItem() == Items.RAW_GOLD){
                FireStack(world, state, pos, entity, fallDistance, Items.GOLD_INGOT);
            }
            else if(itemEntity.getStack().getItem() == Items.RAW_IRON_BLOCK){
                FireStack(world, state, pos, entity, fallDistance, Items.IRON_BLOCK);
            }
            else if(itemEntity.getStack().getItem() == Items.RAW_GOLD_BLOCK){
                FireStack(world, state, pos, entity, fallDistance, Items.GOLD_BLOCK);
            }
            else if(itemEntity.getStack().getItem() == Items.RAW_COPPER_BLOCK){
                FireStack(world, state, pos, entity, fallDistance, Items.COPPER_BLOCK);
            }
            else if(itemEntity.getStack().getItem() == Items.POTATO){
                FireStack(world, state, pos, entity, fallDistance, Items.BAKED_POTATO);
            }
            else if(itemEntity.getStack().getItem() == Items.BEEF){
                FireStack(world, state, pos, entity, fallDistance, Items.COOKED_BEEF);
            }
            else if(itemEntity.getStack().getItem() == Items.PORKCHOP){
                FireStack(world, state, pos, entity, fallDistance, Items.COOKED_PORKCHOP);
            }
            else if(itemEntity.getStack().getItem() == Items.CHICKEN){
                FireStack(world, state, pos, entity, fallDistance, Items.COOKED_CHICKEN);
            }
            else if(itemEntity.getStack().getItem() == Items.MUTTON){
                FireStack(world, state, pos, entity, fallDistance, Items.COOKED_MUTTON);
            }
            else if(itemEntity.getStack().getItem() == Items.SALMON){
                FireStack(world, state, pos, entity, fallDistance, Items.COOKED_SALMON);
            }
            else if(itemEntity.getStack().getItem() == Items.COD){
                FireStack(world, state, pos, entity, fallDistance, Items.COOKED_COD);
            }
            else if(itemEntity.getStack().getItem() == Items.RABBIT){
                FireStack(world, state, pos, entity, fallDistance, Items.COOKED_RABBIT);
            }
            else if(itemEntity.getStack().getItem() == Items.COBBLESTONE){
                FireStack(world, state, pos, entity, fallDistance, Items.STONE);
            }
            else if(itemEntity.getStack().getItem() == Items.STONE){
                FireStack(world, state, pos, entity, fallDistance, Items.SMOOTH_STONE);
            }
            else if(itemEntity.getStack().getItem() == Items.SAND){
                FireStack(world, state, pos, entity, fallDistance, Items.GLASS);
            }
            else if(itemEntity.getStack().getItem() == Items.GRAVEL){
                FireStack(world, state, pos, entity, fallDistance, Items.FLINT);
            }
            else if(itemEntity.getStack().getItem() == Items.COBBLESTONE_STAIRS){
                FireStack(world, state, pos, entity, fallDistance, Items.STONE_STAIRS);
            }
            else if(itemEntity.getStack().getItem() == Items.COBBLESTONE_SLAB){
                FireStack(world, state, pos, entity, fallDistance, Items.STONE_SLAB);
            }
            else if(itemEntity.getStack().getItem() == Items.COBBLESTONE_WALL){
                FireStack(world, state, pos, entity, fallDistance, Items.STONE_BRICK_WALL);
            }
            else if(itemEntity.getStack().getItem() == Items.COBBLED_DEEPSLATE){
                FireStack(world, state, pos, entity, fallDistance, Items.DEEPSLATE);
            }
        }

        super.onLandedUpon(world, state, pos, entity, fallDistance);
    }

    public void FireStack(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, Item firedItem){

        if(entity instanceof ItemEntity itemEntity){
            if(!world.isClient()){
                ItemStack firedStack = new ItemStack(firedItem);
                firedStack.setCount(itemEntity.getStack().getCount());

                itemEntity.kill();

                ItemEntity firedStackEntity = new ItemEntity(EntityType.ITEM, world);
                firedStackEntity.setStack(firedStack);
                firedStackEntity.setPos(itemEntity.getX(), itemEntity.getY(), itemEntity.getZ());

                world.spawnEntity(firedStackEntity);
                firedStackEntity.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH, 1.0f, 1.0f);
            }
        }


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
