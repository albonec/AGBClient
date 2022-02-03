package com.albonec.othercode.ui;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Keyboard;

public final class GuiFeaturesScreen
        extends GuiScreen {

    private final GuiScreen previousScreen;
    Minecraft mc = Minecraft.getMinecraft();
    ScaledResolution sr = new ScaledResolution(mc);

    GuiButton zoomButton = new GuiButton(100, sr.getScaledWidth() / 2 - 100, sr.getScaledHeight() - 60, mc.gameSettings.wasZoom ? "Zoom: On" : "Zoom: Off");
    GuiButton keystrokesButton = new GuiButton(102, sr.getScaledWidth() / 2 - 100, sr.getScaledHeight() - 90, mc.gameSettings.wasKeystrokes ? "Keystrokes: On" : "Keystrokes: Off");
    GuiButton renderCoordsButton = new GuiButton(103, sr.getScaledWidth() / 2 - 100, sr.getScaledHeight() - 120, mc.gameSettings.wasRenderCoordinates ? "Render Coordinates: On" : "Render Coordinates: Off");
    GuiButton memUsageButton =  new GuiButton(104, sr.getScaledWidth() / 2 - 100, sr.getScaledHeight() - 150, mc.gameSettings.wasRenderMemory ? "Render Memory Usage: On" : "Render Memory Usage: Off");
    GuiButton renderArmorButton = new GuiButton(105, sr.getScaledWidth() / 2 - 100, sr.getScaledHeight() - 180, mc.gameSettings.wasRenderArmor ? "Render Armor Equipped: On" : "Render Armor Equipped: Off");

    public GuiFeaturesScreen(GuiScreen previousScreen) {
        this.previousScreen = previousScreen;
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        ScaledResolution sr = new ScaledResolution(mc);
        switch (button.id) {
            case 1: {
                this.mc.displayGuiScreen(this.previousScreen);
                break;
            }
            case 100: {
                this.buttonList.remove(zoomButton);
                mc.gameSettings.doZoom = !mc.gameSettings.wasZoom ? true : false;
                System.out.println(mc.gameSettings.doZoom);
                mc.gameSettings.wasZoom = mc.gameSettings.doZoom;
                zoomButton = new GuiButton(100, sr.getScaledWidth() / 2 - 100, sr.getScaledHeight() - 60, mc.gameSettings.wasZoom ? "Zoom: On" : "Zoom: Off");
                this.buttonList.add(zoomButton);
                break;
            }
            case 102: {
                this.buttonList.remove(keystrokesButton);
                mc.gameSettings.doRenderKeystrokes = !mc.gameSettings.wasKeystrokes ? true : false;
                System.out.println(mc.gameSettings.doRenderKeystrokes);
                mc.gameSettings.wasKeystrokes = mc.gameSettings.doRenderKeystrokes;
                keystrokesButton = new GuiButton(102, sr.getScaledWidth() / 2 - 100, sr.getScaledHeight() - 90, mc.gameSettings.wasKeystrokes ? "Keystrokes: On" : "Keystrokes: Off");
                this.buttonList.add(keystrokesButton);
                break;
            }
            case 103: {
                this.buttonList.remove(renderCoordsButton);
                mc.gameSettings.doRenderCoordinates = !mc.gameSettings.wasRenderCoordinates ? true : false;
                System.out.println(mc.gameSettings.doRenderCoordinates);
                mc.gameSettings.wasRenderCoordinates = mc.gameSettings.doRenderCoordinates;
                renderCoordsButton = new GuiButton(103, sr.getScaledWidth() / 2 - 100, sr.getScaledHeight() - 120, mc.gameSettings.wasRenderCoordinates ? "Render Coordinates: On" : "Render Coordinates: Off");
                this.buttonList.add(renderCoordsButton);
                break;
            }
            case 104: {
                this.buttonList.remove(memUsageButton);
                mc.gameSettings.doRenderMemory = !mc.gameSettings.wasRenderMemory ? true : false;
                System.out.println(mc.gameSettings.doRenderMemory);
                mc.gameSettings.wasRenderMemory = mc.gameSettings.doRenderMemory;
                memUsageButton = new GuiButton(104, sr.getScaledWidth() / 2 - 100, sr.getScaledHeight() - 150, mc.gameSettings.wasRenderMemory ? "Render Memory Usage: On" : "Render Memory Usage: Off");
                this.buttonList.add(memUsageButton);
                break;
            }
            case 105: {
                this.buttonList.remove(renderArmorButton);
                mc.gameSettings.doRenderArmor = !mc.gameSettings.wasRenderArmor ? true : false;
                System.out.println(mc.gameSettings.doRenderArmor);
                mc.gameSettings.wasRenderArmor = mc.gameSettings.doRenderArmor;
                renderArmorButton = new GuiButton(105, sr.getScaledWidth() / 2 - 100, sr.getScaledHeight() - 180, mc.gameSettings.wasRenderArmor ? "Render Armor Equipped: On" : "Render Armor Equipped: Off");
                this.buttonList.add(renderArmorButton);
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
        this.buttonList.add(zoomButton);
        this.buttonList.add(keystrokesButton);
        this.buttonList.add(renderCoordsButton);
        this.buttonList.add(memUsageButton);
        this.buttonList.add(renderArmorButton);

        this.buttonList.add(new GuiButton(1, width / 2 - 100, sr.getScaledHeight() - 25, "Back"));
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

