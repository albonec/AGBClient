package com.albonec.othercode.misc;

import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.core.helpers.SystemClock;

public class CalcSpeedThread extends Thread {
    Minecraft mc = Minecraft.getMinecraft();

    @Override
    public void run() {
        try {
            System.out.println(calcSpeed(getPosChangePerSec()));
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        double speed2D = Math.hypot(posChange[0], posChange[2]);

        if (posChange[2] != 0) {
            double speed3D = Math.hypot(posChange[1], speed2D);
            return speed3D;
        } else {
            return speed2D;
        }
    }
}
