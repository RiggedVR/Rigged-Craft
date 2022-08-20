package com.rigged.riggedcraft.entity.client;

import com.rigged.riggedcraft.RiggedCraftMod;
import com.rigged.riggedcraft.entity.custom.CapybaraEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class CapybaraModel extends AnimatedGeoModel<CapybaraEntity> {
    @Override
    public Identifier getModelResource(CapybaraEntity object) {
        return new Identifier(RiggedCraftMod.MOD_ID, "geo/capybara.geo.json");
    }

    @Override
    public Identifier getTextureResource(CapybaraEntity object) {
        return new Identifier(RiggedCraftMod.MOD_ID, "textures/entity/capybara/capybara.png");
    }

    @Override
    public Identifier getAnimationResource(CapybaraEntity animatable) {
        return new Identifier(RiggedCraftMod.MOD_ID, "animations/capybara.animation.json");
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void setLivingAnimations(CapybaraEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if(head != null){
            head.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));
        }
    }
}
