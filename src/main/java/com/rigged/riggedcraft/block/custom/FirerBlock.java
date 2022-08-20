package com.rigged.riggedcraft.block.custom;

import com.rigged.riggedcraft.registry.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FirerBlock extends Block {


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if(!world.isClient() && hand == Hand.MAIN_HAND){
            if(player.getStackInHand(hand).getItem() == ModItems.HAVENITE){
                player.getStackInHand(hand).decrement(1);
                player.giveItemStack(new ItemStack(ModItems.HAVENITE));
            }
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if(entity instanceof ItemEntity itemEntity){
            if(itemEntity.getStack().getItem() == ModItems.HAVENITE){
                itemEntity.setStack(new ItemStack(ModItems.HAVENITE));
            }
        }

        super.onLandedUpon(world, state, pos, entity, fallDistance);
    }

    public FirerBlock(Settings settings) {
        super(settings);
    }
}
