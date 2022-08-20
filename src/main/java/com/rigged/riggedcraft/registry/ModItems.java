package com.rigged.riggedcraft.registry;

import com.rigged.riggedcraft.RiggedCraftMod;
import com.rigged.riggedcraft.components.FoodComponents;
import com.rigged.riggedcraft.entity.ModEntities;
import com.rigged.riggedcraft.items.ModItemsGroup;
import com.rigged.riggedcraft.items.SpherizerItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems {

    //Items
    public static final Item WATERMELON = registerItem("watermelon",
            new Item(new Item.Settings().group(ModItemsGroup.RIGGEDCRAFT).maxCount(1).food(FoodComponents.WATERMELON)));
    public static final Item SPHERIZER = registerItem("spherizer", new SpherizerItem());
    public static final Item CAPYBARA_SPAWN_EGG = registerItem("capybara_spawn_egg", new SpawnEggItem(ModEntities.CAPYBARA, 5386520,6899224, new Item.Settings().group(ModItemsGroup.RIGGEDCRAFT)));

    public static final Item HAVENITE = registerItem("havenite", new Item(new Item.Settings().group(ModItemsGroup.RIGGEDCRAFT)));

    //Helper method
    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(RiggedCraftMod.MOD_ID, name), item);
    }

    public static void registerItems(){
        RiggedCraftMod.LOGGER.debug("Registering Mod Items for " + RiggedCraftMod.MOD_ID);
    }
}
