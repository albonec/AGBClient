package com.albonec.othercode.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class CPS {

    Minecraft mc = Minecraft.getMinecraft();
    FontRenderer fonts = mc.fontRendererObj;
    private List<Long> clicks = new ArrayList<Long>();
    private boolean wasPressed;
    private long lastPressed;

    public void render(int x, int y, int color) {
        final boolean pressed = Mouse.isButtonDown(0);
        if(pressed != this.wasPressed) {
            this.lastPressed = System.currentTimeMillis();
            this.wasPressed = pressed;
            if(pressed) {
                this.clicks.add(this.lastPressed);
            }
        }
        fonts.drawString("CPS: " + getCPS(), x, y, color);
    }

    public int getCPS() {
        final long time = System.currentTimeMillis();
        this.clicks.removeIf(aLong -> aLong + 1000 <= time);
        return this.clicks.size();
    }

}
