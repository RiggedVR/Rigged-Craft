package com.rigged.riggedcraft;

import com.rigged.riggedcraft.entity.ModEntities;
import com.rigged.riggedcraft.entity.client.CapybaraRenderer;
import com.rigged.riggedcraft.entity.custom.CapybaraEntity;
import com.rigged.riggedcraft.registry.ModItems;
import com.rigged.riggedcraft.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import software.bernie.geckolib3.GeckoLib;

public class RiggedCraftMod implements ModInitializer {

    public static final String MOD_ID = "rc";

    @Override
    public void onInitialize() {
        ModItems.registerItems();

        EntityRendererRegistry.register(ModEntities.CAPYBARA, CapybaraRenderer::new);
        registerAttributes();

        ModWorldGen.generateModWorldGen();

        GeckoLib.initialize();
    }

    private static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(ModEntities.CAPYBARA, CapybaraEntity.setAttributes());
    }
}
