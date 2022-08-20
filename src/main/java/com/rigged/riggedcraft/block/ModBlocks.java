package com.rigged.riggedcraft.block;

import com.rigged.riggedcraft.RiggedCraftMod;
import com.rigged.riggedcraft.block.custom.FirerBlock;
import com.rigged.riggedcraft.items.ModItemsGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;


public class ModBlocks {

    public static final Block HAVENITE_BLOCK = registerBlock("havenite_block",
            new Block(FabricBlockSettings.of(Material.METAL).slipperiness(.989f).strength(4f).requiresTool()), ModItemsGroup.RIGGEDCRAFT);

    public static final Block HAVENITE_ORE = registerBlock("havenite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemsGroup.RIGGEDCRAFT);

    public static final Block DEEPSLATE_HAVENITE_ORE = registerBlock("deepslate_havenite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemsGroup.RIGGEDCRAFT);

    public static final Block FIRER = registerBlock("firer",
            new FirerBlock(FabricBlockSettings.of(Material.GLASS).nonOpaque()), ModItemsGroup.RIGGEDCRAFT);

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
