package com.rigged.riggedcraft.world.gen;

import com.rigged.riggedcraft.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;

public class ModEntitySpawn {
    public static void addEntitySpawn(){
        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(),
                SpawnGroup.CREATURE, ModEntities.CAPYBARA, 5, 2, 5);
    }
}
