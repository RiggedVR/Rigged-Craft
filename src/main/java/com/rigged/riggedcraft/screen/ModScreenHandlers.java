package com.rigged.riggedcraft.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<DisenchanterScreenHandler> DISENCHANTER_SCREEN_HANDLER;

    public static void registerAllScreenHandlers(){
        DISENCHANTER_SCREEN_HANDLER = new ScreenHandlerType<>(DisenchanterScreenHandler::new);
    }
}
