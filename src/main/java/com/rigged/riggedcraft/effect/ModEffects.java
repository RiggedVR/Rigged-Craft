package com.rigged.riggedcraft.effect;

import com.rigged.riggedcraft.RiggedCraftMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModEffects {
    public static StatusEffect AGE;

    public static StatusEffect registerStatusEffect(String name){
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(RiggedCraftMod.MOD_ID, name),
                new AgeEffect(StatusEffectCategory.HARMFUL, 11549987));
    }

    public static void registerEffects(){
        AGE = registerStatusEffect("age");
    }
}
