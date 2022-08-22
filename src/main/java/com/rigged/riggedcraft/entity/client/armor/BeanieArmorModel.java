package com.rigged.riggedcraft.entity.client.armor;

import com.rigged.riggedcraft.RiggedCraftMod;
import com.rigged.riggedcraft.items.BeanieArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BeanieArmorModel extends AnimatedGeoModel<BeanieArmorItem> {
    @Override
    public Identifier getModelResource(BeanieArmorItem object) {
        return new Identifier(RiggedCraftMod.MOD_ID, "geo/beanie.geo.json");
    }

    @Override
    public Identifier getTextureResource(BeanieArmorItem object) {
        return new Identifier(RiggedCraftMod.MOD_ID, "textures/models/armor/beanie_texture.png");
    }

    @Override
    public Identifier getAnimationResource(BeanieArmorItem animatable) {
        return new Identifier(RiggedCraftMod.MOD_ID, "animations/beanie_animations.json");
    }
}
