package com.rigged.riggedcraft.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class CopperWandItem extends Item {

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block block = world.getBlockState(context.getBlockPos()).getBlock();

        if(!world.isClient()){
            if(block == Blocks.COPPER_BLOCK){
                context.getPlayer().getStackInHand(context.getHand()).damage(1, context.getPlayer(), e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));

                world.setBlockState(context.getBlockPos(), Blocks.EXPOSED_COPPER.getDefaultState());
            }
            else if(block == Blocks.EXPOSED_COPPER){
                context.getPlayer().getStackInHand(context.getHand()).damage(1, context.getPlayer(), e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));

                world.setBlockState(context.getBlockPos(), Blocks.WEATHERED_COPPER.getDefaultState());
            }
            else if(block == Blocks.WEATHERED_COPPER){
                context.getPlayer().getStackInHand(context.getHand()).damage(1, context.getPlayer(), e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));

                world.setBlockState(context.getBlockPos(), Blocks.OXIDIZED_COPPER.getDefaultState());
            }
        }
        else{
            if(block == Blocks.COPPER_BLOCK){
                PlayEffects(context, world, block);
            }
            else if(block == Blocks.EXPOSED_COPPER){
                PlayEffects(context, world, block);
            }
            else if(block == Blocks.WEATHERED_COPPER){
                PlayEffects(context, world, block);
            }
        }


        return super.useOnBlock(context);
    }

    private static void PlayEffects(ItemUsageContext context, World world, Block block){
        context.getPlayer().playSound(SoundEvents.BLOCK_COPPER_PLACE, 1.0f, 1.0f);
    }

    public CopperWandItem() {
        super(new FabricItemSettings().group(ModItemsGroup.RIGGEDCRAFT).fireproof().maxCount(1).maxDamage(128));
    }
}
