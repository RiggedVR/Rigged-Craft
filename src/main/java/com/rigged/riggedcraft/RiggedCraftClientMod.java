package com.rigged.riggedcraft;

import com.rigged.riggedcraft.block.ModBlocks;
import com.rigged.riggedcraft.entity.client.armor.BeanieArmorRenderer;
import com.rigged.riggedcraft.registry.ModItems;
import com.rigged.riggedcraft.screen.DisenchanterScreen;
import com.rigged.riggedcraft.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class RiggedCraftClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.DISENCHANTER_SCREEN_HANDLER, DisenchanterScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FIRER, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CELERY_CROP, RenderLayer.getCutout());

        GeoArmorRenderer.registerArmorRenderer(new BeanieArmorRenderer(), ModItems.BEANIE);
    }
}
