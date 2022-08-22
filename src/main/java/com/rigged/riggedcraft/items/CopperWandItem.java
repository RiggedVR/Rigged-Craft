package com.rigged.riggedcraft.items;

import com.rigged.riggedcraft.effect.AgeEffect;
import com.rigged.riggedcraft.effect.ModEffects;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.TadpoleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
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
            else if(block == Blocks.FROGSPAWN){
                context.getPlayer().getStackInHand(context.getHand()).damage(1, context.getPlayer(), e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));

                TadpoleEntity tadpole = new TadpoleEntity(EntityType.TADPOLE, world);
                tadpole.setPosition(context.getBlockPos().getX(), context.getBlockPos().getY(), context.getBlockPos().getZ());

                world.setBlockState(context.getBlockPos(), Blocks.AIR.getDefaultState());
                world.spawnEntity(tadpole);
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

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        if(entity.isLiving()){
            if(!user.getWorld().isClient()){
                user.getStackInHand(hand).damage(1, user, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));

                entity.addStatusEffect(new StatusEffectInstance(ModEffects.AGE, 600, 1));
            }
        }

        return super.useOnEntity(stack, user, entity, hand);
    }

    private static void PlayEffects(ItemUsageContext context, World world, Block block){
        context.getPlayer().playSound(SoundEvents.BLOCK_COPPER_PLACE, 1.0f, 1.0f);
    }

    public CopperWandItem() {
        super(new FabricItemSettings().group(ModItemsGroup.RIGGEDCRAFT).fireproof().maxCount(1).maxDamage(128));
    }
}
