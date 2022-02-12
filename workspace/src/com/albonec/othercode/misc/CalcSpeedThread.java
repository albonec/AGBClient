package com.albonec.othercode.misc;

import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.core.helpers.SystemClock;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

public class CalcSpeedThread extends Thread {
    Minecraft mc = Minecraft.getMinecraft();
    DecimalFormat df = new DecimalFormat("0.000");

    @Override
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
        while (!this.isInterrupted()) {
            if (this.mc.thePlayer != null) {
                try {
                    System.out.println(df.format(calcSpeed(getPosChangePerSec())));
                } catch (InterruptedException n) {
                    n.printStackTrace();
                }
            } else {
                this.interrupt();
            }
        }
    }


    public double[] getPosChangePerSec() throws InterruptedException {

        double prevX = mc.thePlayer.posX;
        double prevY = mc.thePlayer.posY;
        double prevZ = mc.thePlayer.posZ;

        Thread.sleep(1000);

        return new double[]{Math.abs(mc.thePlayer.posX) - Math.abs(prevX), Math.abs(mc.thePlayer.posY) - Math.abs(prevY), Math.abs(mc.thePlayer.posZ) - Math.abs(prevZ)};
    }

    public double calcSpeed(@NotNull double[] posChange) {
        return Math.hypot(posChange[1], Math.hypot(posChange[0], posChange[2]));
    }
}
