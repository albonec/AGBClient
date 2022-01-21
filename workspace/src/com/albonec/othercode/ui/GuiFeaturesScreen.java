package com.albonec.othercode.ui;

import java.io.IOException;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

public final class GuiFeaturesScreen
        extends GuiScreen {

    private final GuiScreen previousScreen;
    public boolean wasKeystrokes;
    public boolean wasZoom;
    public boolean wasCheats;
    public boolean wasRenderCoordinates;
    public boolean wasRenderMemory;

    public GuiFeaturesScreen(GuiScreen previousScreen) {
        this.previousScreen = previousScreen;
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 1: {
                this.mc.displayGuiScreen(this.previousScreen);
                break;
            }
            case 100: {
                mc.gameSettings.doZoom = !wasZoom ? true : false;
                System.out.println(mc.gameSettings.doZoom);
                wasZoom = mc.gameSettings.doZoom;
                break;
            }
            case 101: {
                mc.gameSettings.doCheats = !wasCheats ? true : false;
                System.out.println(mc.gameSettings.doCheats);
                wasCheats = mc.gameSettings.doCheats;
                break;
            }
            case 102: {
                mc.gameSettings.doRenderKeystrokes = !wasKeystrokes ? true : false;
                System.out.println(mc.gameSettings.doRenderKeystrokes);
                wasKeystrokes = mc.gameSettings.doRenderKeystrokes;
                break;
            }
            case 103: {
                mc.gameSettings.doRenderCoordinates = !wasRenderCoordinates ? true : false;
                System.out.println(mc.gameSettings.doRenderCoordinates);
                wasRenderCoordinates = mc.gameSettings.doRenderCoordinates;
                break;
            }
            case 104: {
                mc.gameSettings.doRenderMemory = !wasRenderMemory ? true : false;
                System.out.println(mc.gameSettings.doRenderMemory);
                wasRenderMemory = mc.gameSettings.doRenderMemory;
                break;
            }
        }
    }

    @Override
    public void drawScreen(int x2, int y2, float z2) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.mc.fontRendererObj, "Feature Settings", width / 2, 20, -1);
        super.drawScreen(x2, y2, z2);
    }

    @Override
    public void initGui() {
        int var3 = height / 4 + 24;
        this.buttonList.add(new GuiButton(100, width / 2 - 100, var3 + 72 + 12, "Zoom"));
        this.buttonList.add(new GuiButton(101, width / 2 - 100, var3 + 72 - 12, "Cheats"));
        this.buttonList.add(new GuiButton(102, width / 2 - 100, var3 + 72 - 36, "Keystrokes"));
        this.buttonList.add(new GuiButton(103, width / 2 - 100, var3 + 72 - 60, "Show Coordinates"));
        this.buttonList.add(new GuiButton(104, width / 2 - 100, var3 + 72 - 85, "Show Memory Usage"));

        this.buttonList.add(new GuiButton(1, width / 2 - 100, var3 + 72 + 12 + 36, "Back"));
        Keyboard.enableRepeatEvents(true);
    }

    @Override
    protected void mouseClicked(int x2, int y2, int button) {
        try {
            super.mouseClicked(x2, y2, button);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void updateScreen() {
    }
}

