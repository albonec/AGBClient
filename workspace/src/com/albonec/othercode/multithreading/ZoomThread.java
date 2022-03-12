package com.albonec.othercode.multithreading;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class ZoomThread extends Thread {
    private Minecraft mc = Minecraft.getMinecraft();

    @Override
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
        while (!this.isInterrupted()) {
            try {
                if (Keyboard.isKeyDown(Keyboard.KEY_UP) && mc.gameSettings.gammaSetting >= 0.0F) {
                    mc.gameSettings.gammaSetting -= Math.sqrt(mc.gameSettings.gammaSetting + PressedZoomKey.UP.increase);
                    Thread.sleep(50);
                }
                if (Keyboard.isKeyDown(Keyboard.KEY_DOWN) && mc.gameSettings.gammaSetting <= 75.0F) {
                    mc.gameSettings.gammaSetting += Math.sqrt(mc.gameSettings.gammaSetting + PressedZoomKey.DOWN.increase);
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    enum PressedZoomKey {
        UP(-0.25F),
        DOWN(0.25F);

        public final float increase;

        PressedZoomKey(float increase) {this.increase = increase;}
    }

}
