package com.albonec.othercode.misc;

import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.core.helpers.SystemClock;

import java.text.DecimalFormat;

public class CalcSpeedThread extends Thread {
    Minecraft mc = Minecraft.getMinecraft();
    DecimalFormat df = new DecimalFormat("0.000");

    @Override
    public void run() {
        while(!this.isInterrupted()) {
            try {
                System.out.println(df.format(calcSpeed(getPosChangePerSec())));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public double[] getPosChangePerSec() throws InterruptedException {
        long prevTime = System.currentTimeMillis();
        double prevX = mc.thePlayer.posX;
        double prevY = mc.thePlayer.posY;
        double prevZ = mc.thePlayer.posZ;

        Thread.sleep(1000);

        return new double[]{Math.abs(mc.thePlayer.posX) - Math.abs(prevX), Math.abs(mc.thePlayer.posY) - Math.abs(prevY), Math.abs(mc.thePlayer.posZ) - Math.abs(prevZ)};
    }

    public double calcSpeed(double[] posChange) {
            double speed3D = Math.hypot(posChange[1], Math.hypot(posChange[0], posChange[2]));
            return speed3D;
    }
}
