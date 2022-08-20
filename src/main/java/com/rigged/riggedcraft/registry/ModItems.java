package com.rigged.riggedcraft.registry;

import com.rigged.riggedcraft.RiggedCraftMod;
import com.rigged.riggedcraft.components.FoodComponents;
import com.rigged.riggedcraft.entity.ModEntities;
import com.rigged.riggedcraft.items.SpherizerItem;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems {

    //Items
    public static final Item WATERMELON = new Item(new Item.Settings().group(ItemGroup.FOOD).maxCount(1).food(FoodComponents.WATERMELON));
    public static final SpherizerItem SPHERIZER = new SpherizerItem();
    public static final Item CAPYBARA_SPAWN_EGG = new SpawnEggItem(ModEntities.CAPYBARA, 5386520,6899224, new Item.Settings().group(ItemGroup.MISC));

    //modid:itemName
    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(RiggedCraftMod.MOD_ID, "watermelon"), WATERMELON);
        Registry.register(Registry.ITEM, new Identifier(RiggedCraftMod.MOD_ID, "spherizer"), SPHERIZER);
        Registry.register(Registry.ITEM, new Identifier(RiggedCraftMod.MOD_ID, "capybara_spawn_egg"), CAPYBARA_SPAWN_EGG);
    }
}
