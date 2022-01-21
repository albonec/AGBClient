package com.albonec.othercode.module.render;

import com.albonec.othercode.event.EventTarget;
import com.albonec.othercode.event.events.EventUpdate;
import com.albonec.othercode.module.Category;
import com.albonec.othercode.module.Module;
import com.albonec.othercode.ui.GuiFeaturesScreen;
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
        if(mc.gameSettings.doZoom) {
            mc.gameSettings.gammaSetting = 2.5F;
        }
    }

    @Override
    public void onDisable() {
        mc.gameSettings.gammaSetting = oldBrightness;

        super.onDisable();
    }

}