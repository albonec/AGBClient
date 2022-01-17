package com.albonec.othercode.ui;

import com.albonec.othercode.start;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;

public class CustomIngameGui extends GuiIngame {
    private Minecraft mc = Minecraft.getMinecraft();
    private FontRenderer fonts = mc.fontRendererObj;

    public CustomIngameGui(Minecraft mcIn) {
        super(mcIn);
    }

    @Override
    public void renderGameOverlay(float partialTicks) {
        super.renderGameOverlay(partialTicks);
        if(!mc.gameSettings.showDebugProfilerChart) {
            renderInfo();
        }
    }

    private void renderInfo() {
        fonts.drawString("Coordinates", 2, 20, 0xffffff);
        fonts.drawString(ChatFormatting.RED +"X: " + ChatFormatting.WHITE + String.valueOf(mc.thePlayer.posX), 2, 30, 0xffffff);
        fonts.drawString(ChatFormatting.RED +"Y: " + ChatFormatting.WHITE + String.valueOf(mc.thePlayer.posY), 2, 40, 0xffffff);
        fonts.drawString(ChatFormatting.RED +"Z: " + ChatFormatting.WHITE + String.valueOf(mc.thePlayer.posZ), 2, 50, 0xffffff);
    }

}
