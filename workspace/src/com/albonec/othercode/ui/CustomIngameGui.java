package com.albonec.othercode.ui;

import com.albonec.othercode.misc.CPSLeft;
import com.albonec.othercode.misc.CPSRight;
import com.albonec.othercode.module.Module;
import com.albonec.othercode.start;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CustomIngameGui extends GuiIngame {
    private Minecraft mc = Minecraft.getMinecraft();
    private FontRenderer fonts = mc.fontRendererObj;
    Runtime runtime = Runtime.getRuntime();
    CPSLeft cpsLeft = new CPSLeft();
    CPSRight cpsRight = new CPSRight();

    public CustomIngameGui(Minecraft mcIn) {
        super(mcIn);
    }

    @Override
    public void renderGameOverlay(float partialTicks) {
        super.renderGameOverlay(partialTicks);
        if (!mc.gameSettings.showDebugProfilerChart) {
            renderCoords();
            renderMemory();
            renderModules();
            renderKeyStrokes();
            renderCPS();
        }
    }

    private void renderCoords() {
        if (mc.gameSettings.doRenderCoordinates) {
            DecimalFormat df = new DecimalFormat("0.0000");
            fonts.drawString("Coordinates", 2, 20, 0xffffff);
            fonts.drawString(ChatFormatting.RED + "X: " + ChatFormatting.WHITE + String.valueOf(df.format(mc.thePlayer.posX)), 2, 30, 0xffffff);
            fonts.drawString(ChatFormatting.RED + "Y: " + ChatFormatting.WHITE + String.valueOf(df.format(mc.thePlayer.posY)), 2, 40, 0xffffff);
            fonts.drawString(ChatFormatting.RED + "Z: " + ChatFormatting.WHITE + String.valueOf(df.format(mc.thePlayer.posZ)), 2, 50, 0xffffff);
        }
    }

    private void renderMemory() {
        if (mc.gameSettings.doRenderMemory) {
                ScaledResolution sr = new ScaledResolution(mc);
                String mem = ("RAM: " + String.valueOf((runtime.totalMemory() - runtime.freeMemory()) / 1000000) + "/" + String.valueOf(runtime.totalMemory() / 1000000) + " MB");
                fonts.drawString(mem, sr.getScaledWidth() - fonts.getStringWidth(mem) - 2, 2, 0xffffff);
            }
            //System.out.println(("RAM: " + String.valueOf((runtime.totalMemory() - runtime.freeMemory()) / 1000000) + "/" + String.valueOf(runtime.totalMemory() / 1000000) + " MB").length());
        }

    private void renderModules() {
            fonts.drawString("Enabled Features", 2, 80, 0xffffff);

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
        if (mc.gameSettings.doRenderKeystrokes) {
            ScaledResolution sr = new ScaledResolution(mc);

            int[] WColor = Keyboard.isKeyDown(Keyboard.KEY_W) ? new int[]{255, 255, 255} : new int[]{0, 0, 0};
            int[] AColor = Keyboard.isKeyDown(Keyboard.KEY_A) ? new int[]{255, 255, 255} : new int[]{0, 0, 0};
            int[] SColor = Keyboard.isKeyDown(Keyboard.KEY_S) ? new int[]{255, 255, 255} : new int[]{0, 0, 0};
            int[] DColor = Keyboard.isKeyDown(Keyboard.KEY_D) ? new int[]{255, 255, 255} : new int[]{0, 0, 0};
            int[] LMBColor = Mouse.isButtonDown(0) ? new int[]{255, 255, 255} : new int[]{0, 0, 0};
            int[] RMBColor = Mouse.isButtonDown(1) ? new int[]{255, 255, 255} : new int[]{0, 0, 0};
            int[] CtrlColor = Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) ? new int[]{255, 255, 255} : new int[]{0, 0, 0};

            Gui.drawRect(sr.getScaledWidth() - 29 - 29, sr.getScaledHeight() - 4 - 25 - 29 - 30 - 30, sr.getScaledWidth() - 4 - 29, sr.getScaledHeight() - 4 - 29 - 30 - 30, new Color(WColor[0], WColor[1], WColor[2], 100).getRGB());
            Gui.drawRect(sr.getScaledWidth() - 29 - 29 - 29, sr.getScaledHeight() - 4 - 25 - 30 - 30, sr.getScaledWidth() - 4 - 29 - 29, sr.getScaledHeight() - 4 - 30 - 30, new Color(AColor[0], AColor[1], AColor[2], 100).getRGB());
            Gui.drawRect(sr.getScaledWidth() - 29 - 29, sr.getScaledHeight() - 4 - 25 - 30 - 30, sr.getScaledWidth() - 4 - 29, sr.getScaledHeight() - 4 - 30 - 30, new Color(SColor[0], SColor[1], SColor[2], 100).getRGB());
            Gui.drawRect(sr.getScaledWidth() - 29, sr.getScaledHeight() - 4 - 25 - 30 - 30, sr.getScaledWidth() - 4, sr.getScaledHeight() - 4 - 30 - 30, new Color(DColor[0], DColor[1], DColor[2], 100).getRGB());
            Gui.drawRect(sr.getScaledWidth() - 29 - 29 - 29, sr.getScaledHeight() - 4 - 25 - 30, sr.getScaledWidth() - 4 - 44, sr.getScaledHeight() - 4 - 30, new Color(LMBColor[0], LMBColor[1], LMBColor[2], 100).getRGB());
            Gui.drawRect(sr.getScaledWidth() - 4 - 39, sr.getScaledHeight() - 4 - 25 - 30, sr.getScaledWidth() - 4, sr.getScaledHeight() - 4 - 30, new Color(RMBColor[0], RMBColor[1], RMBColor[2], 100).getRGB());
            Gui.drawRect(sr.getScaledWidth() - 29 - 29 - 29, sr.getScaledHeight() - 4 - 25, sr.getScaledWidth() - 4 - 44, sr.getScaledHeight() - 4, new Color(CtrlColor[0], CtrlColor[1], CtrlColor[2], 100).getRGB());

            fonts.drawString("W", sr.getScaledWidth() - 48, sr.getScaledHeight() - 49 - 30 - 30, WColor[0] == 0 ? 0xffffff : 0x000000);
            fonts.drawString("A", sr.getScaledWidth() - 77, sr.getScaledHeight() - 20 - 30 - 30, AColor[0] == 0 ? 0xffffff : 0x000000);
            fonts.drawString("S", sr.getScaledWidth() - 48, sr.getScaledHeight() - 20 - 30 - 30, SColor[0] == 0 ? 0xffffff : 0x000000);
            fonts.drawString("D", sr.getScaledWidth() - 19, sr.getScaledHeight() - 20 - 30 - 30, DColor[0] == 0 ? 0xffffff : 0x000000);
            fonts.drawString("RMB", sr.getScaledWidth() - 32, sr.getScaledHeight() - 20 - 30, RMBColor[0] == 0 ? 0xffffff : 0x000000);
            fonts.drawString("LMB", sr.getScaledWidth() - 77, sr.getScaledHeight() - 20 - 30, LMBColor[0] == 0 ? 0xffffff : 0x000000);
            fonts.drawString("CTRL", sr.getScaledWidth() - 78, sr.getScaledHeight() - 4 - 12 - 3, CtrlColor[0] == 0 ? 0xffffff : 0x000000);
        }
    }

    public void renderCPS() {
        ScaledResolution sr = new ScaledResolution(mc);
        final int Hoffset = 12;
        final int Voffset = 15;
        fonts.drawString("CPS", sr.getScaledWidth() - fonts.getStringWidth("CPS") - (25/10) - Hoffset, sr.getScaledHeight() - 10 - Voffset, 0xffffff);
        cpsLeft.render(sr.getScaledWidth() - fonts.getStringWidth(cpsRight.getCPS() + " | " + cpsLeft.getCPS()) - Hoffset, sr.getScaledHeight() - Voffset, 0xffffff);
        cpsRight.render(sr.getScaledWidth() - fonts.getStringWidth(String.valueOf(cpsRight.getCPS())) - Hoffset, sr.getScaledHeight() - Voffset, 0xffffff);
        fonts.drawString(" | ",sr.getScaledWidth() - fonts.getStringWidth(cpsRight.getCPS() + " | ") - Hoffset, sr.getScaledHeight() - Voffset, 0xffffff);
    }

}
