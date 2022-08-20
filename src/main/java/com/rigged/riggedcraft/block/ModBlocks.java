package com.rigged.riggedcraft.block;

import com.rigged.riggedcraft.RiggedCraftMod;
import com.rigged.riggedcraft.items.ModItemsGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModBlocks {

    public static final Block HAVENIUM_BLOCK = registerBlock("havenium_block",
            new Block(FabricBlockSettings.of(Material.METAL).slipperiness(.989f).strength(4f).requiresTool()), ModItemsGroup.RIGGEDCRAFT);

    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(RiggedCraftMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(RiggedCraftMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks(){
        RiggedCraftMod.LOGGER.debug("Registering ModBlocks for " + RiggedCraftMod.MOD_ID);
    }
}
