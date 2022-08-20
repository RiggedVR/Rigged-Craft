package com.rigged.riggedcraft.entity.client;

import com.rigged.riggedcraft.RiggedCraftMod;
import com.rigged.riggedcraft.entity.custom.CapybaraEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CapybaraRenderer extends GeoEntityRenderer<CapybaraEntity> {
    public CapybaraRenderer(EntityRendererFactory.Context ctx){
        super(ctx, new CapybaraModel());
    }

    @Override
    public Identifier getTextureResource(CapybaraEntity object) {
        return new Identifier(RiggedCraftMod.MOD_ID, "textures/entity/capybara/capybara.png");
    }
}
