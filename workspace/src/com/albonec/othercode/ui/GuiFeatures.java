package com.albonec.othercode.ui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ServerSelectionList;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraft.client.network.LanServerDetector;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;

public class GuiFeatures extends GuiScreen {
    private GuiScreen parentScreen;
    private boolean initialized;

    public GuiFeatures(GuiScreen parentScreen) {
        this.parentScreen = parentScreen;
    }

    public void initGui()
    {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();

        if (!this.initialized)
        {
            this.initialized = true;
            this.drawDefaultBackground();
        }
        else
        {
        }
        this.createButtons();
    }

    public void createButtons() {
        this.buttonList.add(new GuiButton(15,this.width / 2 - 154, this.height - 28, 70, 20, I18n.format("Zoom", new Object[0])));
    }

}
