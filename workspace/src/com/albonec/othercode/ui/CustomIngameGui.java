package com.albonec.othercode.ui;

import com.albonec.othercode.module.Module;
import com.albonec.othercode.start;
import com.mojang.realmsclient.dto.PlayerInfo;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.optifine.util.MemoryMonitor;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.awt.*;
import java.util.ArrayList;

public class CustomIngameGui extends GuiIngame {
    private Minecraft mc = Minecraft.getMinecraft();
    private FontRenderer fonts = mc.fontRendererObj;
    Runtime runtime = Runtime.getRuntime();

    public CustomIngameGui(Minecraft mcIn) {
        super(mcIn);
    }

    @Override
    public void renderGameOverlay(float partialTicks) {
        super.renderGameOverlay(partialTicks);
        if(!mc.gameSettings.showDebugProfilerChart) {
            renderInfo();
            renderModules();
        }
        renderKeyStrokes();
    }

    private void renderInfo() {
        ScaledResolution sr = new ScaledResolution(mc);
        fonts.drawString("Coordinates", 2, 20, 0xffffff);
        fonts.drawString(ChatFormatting.RED +"X: " + ChatFormatting.WHITE + String.valueOf(mc.thePlayer.posX), 2, 30, 0xffffff);
        fonts.drawString(ChatFormatting.RED +"Y: " + ChatFormatting.WHITE + String.valueOf(mc.thePlayer.posY), 2, 40, 0xffffff);
        fonts.drawString(ChatFormatting.RED +"Z: " + ChatFormatting.WHITE + String.valueOf(mc.thePlayer.posZ), 2, 50, 0xffffff);
        //fonts.drawString(ChatFormatting.BLUE +"Since Last Packet: "+ "ms", sr.getScaledWidth() - 140, 2, 0xffffff);
        if((runtime.totalMemory() - runtime.freeMemory()) / 1000000 >= 1000) {
            fonts.drawString("RAM: " + String.valueOf((runtime.totalMemory() - runtime.freeMemory()) / 1000000) + "/" + String.valueOf(runtime.totalMemory() / 1000000) + " MB", sr.getScaledWidth() - 95, 2, 0xffffff);
        } else {
            fonts.drawString("RAM: " + String.valueOf((runtime.totalMemory() - runtime.freeMemory()) / 1000000) + "/" + String.valueOf(runtime.totalMemory() / 1000000) + " MB", sr.getScaledWidth() - 90, 2, 0xffffff);
        }

    }

    private void renderModules() {
        ScaledResolution sr = new ScaledResolution(mc);
        fonts.drawString("Enabled Modules", 2, 80, 0xffffff);

        ArrayList<Module> enabledModules = new ArrayList<Module>();
        for (Module m : start.instance.moduleManager.getModules())
            if (m.isToggled())
                enabledModules.add(m);

        enabledModules.sort((m1, m2) -> fonts.getStringWidth(m2.getDisplayName()) - fonts.getStringWidth(m1.getDisplayName()));

        int y = 95;
        for (Module m : enabledModules) {
            fonts.drawString(ChatFormatting.AQUA + m.getDisplayName(), 2, y, 0xffffff);
            y += 10;
        }
    }

    private void renderKeyStrokes() {
        ScaledResolution sr = new ScaledResolution(mc);

        int WAlpha = (Keyboard.isKeyDown(Keyboard.KEY_W) ? 250 : 50);
        int AAlpha = (Keyboard.isKeyDown(Keyboard.KEY_A) ? 250 : 50);
        int SAlpha = (Keyboard.isKeyDown(Keyboard.KEY_S) ? 250 : 50);
        int DAlpha = (Keyboard.isKeyDown(Keyboard.KEY_D) ? 250 : 50);
        int RMBAlpha = (Mouse.isButtonDown(1) ? 250 : 50);
        int LMBAlpha = (Mouse.isButtonDown(0) ? 250 : 50);

        Gui.drawRect(sr.getScaledWidth() - 29 - 29, sr.getScaledHeight() - 4 - 25 - 29 - 30, sr.getScaledWidth() - 4 - 29, sr.getScaledHeight() - 4 - 29 - 30, new Color(0,0,0,WAlpha).getRGB());
        Gui.drawRect(sr.getScaledWidth() - 29 - 29 - 29, sr.getScaledHeight() - 4 - 25 - 30, sr.getScaledWidth() - 4 - 29 - 29, sr.getScaledHeight() - 4 - 30, new Color(0,0,0,AAlpha).getRGB());
        Gui.drawRect(sr.getScaledWidth() - 29 - 29, sr.getScaledHeight() - 4 - 25 - 30, sr.getScaledWidth() - 4 - 29, sr.getScaledHeight() - 4 - 30, new Color(0,0,0,SAlpha).getRGB());
        Gui.drawRect(sr.getScaledWidth() - 29, sr.getScaledHeight() - 4 - 25 - 30, sr.getScaledWidth() - 4, sr.getScaledHeight() - 4 - 30, new Color(0,0,0,DAlpha).getRGB());
        Gui.drawRect(sr.getScaledWidth() - 29 - 29 - 29, sr.getScaledHeight() - 4 - 25, sr.getScaledWidth() - 4 - 44, sr.getScaledHeight() - 4, new Color(0,0,0,LMBAlpha).getRGB());
        Gui.drawRect(sr.getScaledWidth() - 4 - 39, sr.getScaledHeight() - 4 - 25, sr.getScaledWidth() - 4, sr.getScaledHeight() - 4, new Color(0,0,0,RMBAlpha).getRGB());

        fonts.drawString("W", sr.getScaledWidth() - 48, sr.getScaledHeight() - 49 - 30, 0xffffff);
        fonts.drawString("A", sr.getScaledWidth() - 77, sr.getScaledHeight() - 20 - 30, 0xffffff);
        fonts.drawString("S", sr.getScaledWidth() - 48, sr.getScaledHeight() - 20 - 30, 0xffffff);
        fonts.drawString("D", sr.getScaledWidth() - 19, sr.getScaledHeight() - 20 - 30, 0xffffff);
        fonts.drawString("RMB", sr.getScaledWidth() - 32, sr.getScaledHeight() - 20, 0xffffff);
        fonts.drawString("LMB", sr.getScaledWidth() - 77, sr.getScaledHeight() - 20, 0xffffff);
    }

}
