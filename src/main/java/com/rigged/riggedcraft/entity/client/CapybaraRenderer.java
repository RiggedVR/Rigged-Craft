package com.rigged.riggedcraft.entity.client;

import com.rigged.riggedcraft.RiggedCraftMod;
import com.rigged.riggedcraft.entity.custom.CapybaraEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.command.argument.serialize.StringArgumentSerializer;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CapybaraRenderer extends GeoEntityRenderer<CapybaraEntity> {
    public CapybaraRenderer(EntityRendererFactory.Context ctx){
        super(ctx, new CapybaraModel());
    }

    public float xf = 1.5f;
    public float yf = 1.5f;
    public float zf = 1.5f;
    public float t = 1.5f;

    @Override
    public Identifier getTextureResource(CapybaraEntity object) {
        return new Identifier(RiggedCraftMod.MOD_ID, "textures/entity/capybara/capybara.png");
    }

}
