package com.albonec.othercode.module.render;

import com.albonec.othercode.event.EventTarget;
import com.albonec.othercode.module.Category;
import org.lwjgl.input.Keyboard;
import com.albonec.othercode.module.Module;

public class QuickHitboxes extends Module {

    private boolean oldSetting;

    public QuickHitboxes() {super("Quick Hitboxes", Keyboard.KEY_B, Category.RENDER);}

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @EventTarget
    public void onUpdate() {
        //mc.gameSettings
    }
}
