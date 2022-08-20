package com.rigged.riggedcraft.entity;

import com.rigged.riggedcraft.RiggedCraftMod;
import com.rigged.riggedcraft.entity.custom.CapybaraEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModEntities {
    public static final EntityType<CapybaraEntity> CAPYBARA = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(RiggedCraftMod.MOD_ID, "capybara"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CapybaraEntity::new)
                    .dimensions(EntityDimensions.fixed(.6f, 0.5f)).build());

}
