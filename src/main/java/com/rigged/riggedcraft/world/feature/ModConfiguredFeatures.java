package com.rigged.riggedcraft.world.feature;

import com.rigged.riggedcraft.RiggedCraftMod;
import com.rigged.riggedcraft.block.ModBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_HAVENITE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.HAVENITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_HAVENITE_ORE.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> HAVENITE_ORE =
            ConfiguredFeatures.register("havenite_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_HAVENITE_ORES, 12));

    public static void registerConfiguredFeatures(){
        RiggedCraftMod.LOGGER.debug("Registering configured features for " + RiggedCraftMod.MOD_ID);
    }
}
