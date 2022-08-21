package com.rigged.riggedcraft;

import com.rigged.riggedcraft.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class RiggedCraftClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FIRER, RenderLayer.getTranslucent());
    }
}
