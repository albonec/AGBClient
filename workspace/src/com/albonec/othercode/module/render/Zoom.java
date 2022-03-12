package com.albonec.othercode.module.render;

import com.albonec.othercode.event.EventTarget;
import com.albonec.othercode.event.events.EventUpdate;
import com.albonec.othercode.module.Category;
import com.albonec.othercode.module.Module;
import com.albonec.othercode.multithreading.ZoomThread;
import com.albonec.othercode.ui.GuiFeaturesScreen;
import org.lwjgl.input.Keyboard;

public class Zoom extends Module {
    ZoomThread[] thread = new ZoomThread[1];

    private float oldBrightness;

    public Zoom() {
        super("Zoom", Keyboard.KEY_F, Category.RENDER);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        oldBrightness = mc.gameSettings.gammaSetting;
        thread[0] = new ZoomThread();
        thread[0].start();
    }

    @Override
    public void onDisable() {
        thread[0].interrupt();
        mc.gameSettings.gammaSetting = oldBrightness;
        super.onDisable();
    }

}