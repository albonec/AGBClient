package com.albonec.othercode.module.player;

import com.albonec.othercode.event.EventTarget;
import com.albonec.othercode.event.events.EventUpdate;
import com.albonec.othercode.module.Category;
import com.albonec.othercode.module.Module;
import net.minecraft.potion.Potion;
import org.lwjgl.input.Keyboard;

public class AntiBlind extends Module {

    public AntiBlind() {
        super("Anti Blind", Keyboard.KEY_B, Category.PLAYER);
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if(mc.thePlayer.isPotionActive(Potion.blindness)) {
            mc.thePlayer.removePotionEffectClient(15);
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
