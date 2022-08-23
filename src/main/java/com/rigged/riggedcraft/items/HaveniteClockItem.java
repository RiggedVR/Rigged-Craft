package com.rigged.riggedcraft.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HaveniteClockItem extends Item {

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if(context.getPlayer().isSneaking()){
            ItemStack stack = context.getPlayer().getStackInHand(context.getHand());
            NbtCompound storedLocationNBT = new NbtCompound();

            storedLocationNBT.putInt("posX", context.getBlockPos().getX());
            storedLocationNBT.putInt("posY", context.getBlockPos().getY());
            storedLocationNBT.putInt("posZ", context.getBlockPos().getZ());

            stack.setNbt(storedLocationNBT);
            return ActionResult.SUCCESS;
        }

        return super.useOnBlock(context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient && user.getStackInHand(hand).getNbt().contains("posX") && user.getStackInHand(hand).getNbt().contains("posX") && user.getStackInHand(hand).getNbt().contains("posX")){
            user.setPos(user.getStackInHand(hand).getNbt().getInt("posX"),
                    user.getStackInHand(hand).getNbt().getInt("posY"),
                    user.getStackInHand(hand).getNbt().getInt("posZ"));
        }

        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(stack.hasNbt()){
            String savedPos = (stack.getNbt().getInt("posX") + "," + stack.getNbt().getInt("posY") + "," + stack.getNbt().getInt("posZ"));
            tooltip.add(Text.literal(savedPos));
        }
    }

    public HaveniteClockItem(Settings settings) {
        super(settings);
    }
}
