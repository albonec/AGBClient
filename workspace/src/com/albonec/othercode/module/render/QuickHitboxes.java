package com.albonec.othercode.module.render;

import com.albonec.othercode.event.EventTarget;
import com.albonec.othercode.event.events.EventUpdate;
import com.albonec.othercode.module.Category;
import net.minecraft.client.renderer.entity.RenderManager;
import org.lwjgl.input.Keyboard;
import com.albonec.othercode.module.Module;

public class QuickHitboxes extends Module {
    
    private boolean oldSetting;

    public QuickHitboxes() {super("Quick Hitboxes", Keyboard.KEY_R, Category.RENDER);}

    @Override
    public void onEnable() {
        super.onEnable();
        oldSetting = mc.gameSettings.debugBoundingBox;
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        mc.gameSettings.debugBoundingBox = true;
    }

    @Override
    public void onDisable() {
        mc.gameSettings.debugBoundingBox = oldSetting;
        super.onDisable();
    }

}
