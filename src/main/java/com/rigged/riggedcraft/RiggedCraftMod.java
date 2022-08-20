package com.rigged.riggedcraft;

import com.rigged.riggedcraft.block.ModBlocks;
import com.rigged.riggedcraft.entity.ModEntities;
import com.rigged.riggedcraft.entity.client.CapybaraRenderer;
import com.rigged.riggedcraft.entity.custom.CapybaraEntity;
import com.rigged.riggedcraft.registry.ModItems;
import com.rigged.riggedcraft.world.feature.ModConfiguredFeatures;
import com.rigged.riggedcraft.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class RiggedCraftMod implements ModInitializer {
    public static final String MOD_ID = "rc";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        ModConfiguredFeatures.registerConfiguredFeatures();

        ModItems.registerItems();
        ModBlocks.registerModBlocks();

        EntityRendererRegistry.register(ModEntities.CAPYBARA, CapybaraRenderer::new);
        registerAttributes();

        ModWorldGen.generateModWorldGen();

        GeckoLib.initialize();
    }

    private static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(ModEntities.CAPYBARA, CapybaraEntity.setAttributes());
    }
}
