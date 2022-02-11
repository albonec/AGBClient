package com.albonec.othercode.misc;

import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.core.helpers.SystemClock;

public class CalcSpeed {
    Minecraft mc = Minecraft.getMinecraft();

    public double[] getPosChangePerSec() {
        long prevTime = System.currentTimeMillis();
        double prevX = mc.thePlayer.posX;
        double prevY = mc.thePlayer.posY;
        double prevZ = mc.thePlayer.posZ;

        return new double[]{mc.thePlayer.posX - prevX, mc.thePlayer.posY - prevY, mc.thePlayer.posZ - mc.thePlayer.posZ - prevZ};
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
