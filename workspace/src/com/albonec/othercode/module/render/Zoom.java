package com.albonec.othercode.module.render;

import com.albonec.othercode.event.EventTarget;
import com.albonec.othercode.event.events.EventUpdate;
import com.albonec.othercode.module.Category;
import com.albonec.othercode.module.Module;
import org.lwjgl.input.Keyboard;

public class Zoom extends Module {

    private float oldBrightness;

    public Zoom() {
        super("Zoom", Keyboard.KEY_F, Category.RENDER);
    }

    @Override
    public void onEnable() {
        super.onEnable();

        oldBrightness = mc.gameSettings.gammaSetting;
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        mc.gameSettings.gammaSetting = 10F;
    }

    @Override
    public void onDisable() {
        mc.gameSettings.gammaSetting = oldBrightness;

        super.onDisable();
    }

}