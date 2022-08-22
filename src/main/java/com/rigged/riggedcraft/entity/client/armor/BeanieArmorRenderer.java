package com.rigged.riggedcraft.entity.client.armor;

import com.rigged.riggedcraft.items.BeanieArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class BeanieArmorRenderer extends GeoArmorRenderer<BeanieArmorItem> {
    public BeanieArmorRenderer() {
        super(new BeanieArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}
