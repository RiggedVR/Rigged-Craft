package com.rigged.riggedcraft.items;

import com.rigged.riggedcraft.RiggedCraftMod;
import com.rigged.riggedcraft.registry.ModItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemsGroup {
    public static final ItemGroup RIGGEDCRAFT = FabricItemGroupBuilder.build(new Identifier(RiggedCraftMod.MOD_ID, "riggedcraft"), () -> new ItemStack(ModItems.WATERMELON));
}
