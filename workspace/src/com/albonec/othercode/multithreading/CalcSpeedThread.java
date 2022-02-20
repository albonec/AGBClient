package com.albonec.othercode.multithreading;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

public class CalcSpeedThread extends Thread {
    private Minecraft mc = Minecraft.getMinecraft();
    private DecimalFormat df = new DecimalFormat("0.000");
    private FontRenderer fonts = mc.fontRendererObj;


    @Override
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
        while (!this.isInterrupted()) {
            this.mc.gameSettings.playerSpeed = Double.parseDouble(df.format(calcSpeed(getPosChangePerTick())));
            this.mc.gameSettings.vertAngle = Double.parseDouble(df.format(verticalAngleDisplacement(getPosChangePerTick())));
        }
    }

// output array has coords x, y, z at respective indexes 0, 1, 2
    public double[] getPosChangePerTick() {
        return new double[] {Math.abs(mc.thePlayer.posX) - Math.abs(mc.thePlayer.lastTickPosX), Math.abs(mc.thePlayer.posY) - Math.abs(mc.thePlayer.lastTickPosY), Math.abs(mc.thePlayer.posZ) - Math.abs(mc.thePlayer.lastTickPosZ)};
    }

    public double calcSpeed(@NotNull double[] posChange) {
        return 20 * Math.hypot(posChange[1], Math.hypot(posChange[0], posChange[2]));
    }

    public double verticalAngleDisplacement(@NotNull double[] posChange) {
        double angle = Math.atan(posChange[1] / Math.hypot(posChange[0], posChange[2])) * (180/Math.PI);
        if(Double.isNaN(angle)) {
            return 0.0;
        } else {
            return angle;
        }
    }
}
