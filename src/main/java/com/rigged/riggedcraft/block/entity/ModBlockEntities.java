package com.rigged.riggedcraft.block.entity;

import com.rigged.riggedcraft.RiggedCraftMod;
import com.rigged.riggedcraft.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<DisenchanterBlockEntity> DISENCHANTER;

    public static void registerBlockEntities(){
        DISENCHANTER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(RiggedCraftMod.MOD_ID, "disenchanter"),
                FabricBlockEntityTypeBuilder.create(DisenchanterBlockEntity::new,
                        ModBlocks.DISENCHANTER).build(null));
    }
}
