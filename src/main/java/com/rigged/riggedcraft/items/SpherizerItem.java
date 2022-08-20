package com.rigged.riggedcraft.items;

import com.rigged.riggedcraft.registry.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SpherizerItem extends Item {
    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = user.getWorld();

        if(entity.getType() == EntityType.ENDERMAN){
            if(!world.isClient){
                //If it is the server

                user.getMainHandStack().damage(1, user, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));

                //Destroy the entity
                entity.lookAt(EntityAnchorArgumentType.EntityAnchor.EYES, user.getPos());
                entity.kill();

                //Drop Item
                ItemEntity item = new ItemEntity(EntityType.ITEM, world);
                ItemStack _stack = new ItemStack(Items.ENDER_EYE);

                item.setStack(_stack);
                item.setPos(entity.getPos().x, entity.getPos().y, entity.getPos().z);

                world.spawnEntity(item);
            }else{
                //on the client

                //Spawn particles
                world.addParticle(ParticleTypes.ENCHANT, entity.getX(), entity.getY(), entity.getZ(), 0.3, 1.0, 0.3);

                //Play Sound
                user.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
            }
        }

        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block block = world.getBlockState(context.getBlockPos()).getBlock();

        if(block == Blocks.MELON){

            if(!world.isClient){
                // Destroy the block
                world.setBlockState(context.getBlockPos(), Blocks.AIR.getDefaultState());
                context.getPlayer().getStackInHand(context.getHand()).damage(1, context.getPlayer(), e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                //Drop Watermelon
                ItemEntity item = new ItemEntity(EntityType.ITEM, world);
                ItemStack stack = new ItemStack(ModItems.WATERMELON, 1);

                item.setStack(stack);
                item.setPos(context.getBlockPos().getX(), context.getBlockPos().getY(), context.getBlockPos().getZ());

                world.spawnEntity(item);
            }
            else{
                //Play sound
                context.getPlayer().playSound(SoundEvents.BLOCK_PUMPKIN_CARVE, 1.0f, 1.0f);
            }
        }



        return super.useOnBlock(context);
    }

    public SpherizerItem() {
        super(new FabricItemSettings().group(ItemGroup.MISC).fireproof().maxCount(1).maxDamage(10));
    }
}
