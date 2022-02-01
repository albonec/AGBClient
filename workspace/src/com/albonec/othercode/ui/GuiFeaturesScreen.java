package com.albonec.othercode.ui;

import java.io.IOException;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

public final class GuiFeaturesScreen
        extends GuiScreen {

    private final GuiScreen previousScreen;

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
                mc.gameSettings.doZoom = !mc.gameSettings.wasZoom ? true : false;
                System.out.println(mc.gameSettings.doZoom);
                mc.gameSettings.wasZoom = mc.gameSettings.doZoom;
                break;
            }
            case 102: {
                mc.gameSettings.doRenderKeystrokes = !mc.gameSettings.wasKeystrokes ? true : false;
                System.out.println(mc.gameSettings.doRenderKeystrokes);
                mc.gameSettings.wasKeystrokes = mc.gameSettings.doRenderKeystrokes;
                break;
            }
            case 103: {
                mc.gameSettings.doRenderCoordinates = !mc.gameSettings.wasRenderCoordinates ? true : false;
                System.out.println(mc.gameSettings.doRenderCoordinates);
                mc.gameSettings.wasRenderCoordinates = mc.gameSettings.doRenderCoordinates;
                break;
            }
            case 104: {
                mc.gameSettings.doRenderMemory = !mc.gameSettings.wasRenderMemory ? true : false;
                System.out.println(mc.gameSettings.doRenderMemory);
                mc.gameSettings.wasRenderMemory = mc.gameSettings.doRenderMemory;
                break;
            }
            case 105: {
                mc.gameSettings.doRenderArmor = !mc.gameSettings.wasRenderArmor ? true : false;
                System.out.println(mc.gameSettings.doRenderArmor);
                mc.gameSettings.wasRenderArmor = mc.gameSettings.doRenderArmor;
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
        this.buttonList.add(new GuiButton(102, width / 2 - 100, var3 + 72 - 12, "Keystrokes"));
        this.buttonList.add(new GuiButton(103, width / 2 - 100, var3 + 72 - 36, "Show Coordinates"));
        this.buttonList.add(new GuiButton(104, width / 2 - 100, var3 + 72 - 60, "Show Memory Usage"));
        this.buttonList.add(new GuiButton(105, width / 2 - 100, var3 + 72 - 85, "Render Armor"));

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

