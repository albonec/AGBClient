package com.albonec.othercode.multithreading;

import net.minecraft.client.Minecraft;

public class TrajectoriesThread extends Thread {
    private Minecraft mc = Minecraft.getMinecraft();

    @Override
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
        while (!this.isInterrupted()) {
//            System.out.println(getActualYaw(mc.thePlayer.rotationYawHead));
        }
    }

    private double getActualYaw(double reportedYaw) {
        double outYaw = reportedYaw;
        if (reportedYaw <= 360 && reportedYaw >= 0) {
            outYaw = reportedYaw;
        } else {
            while (Math.abs(outYaw) > 360) {
                while (outYaw >= 0) {
                    outYaw -= 360;
                }
                while (outYaw < 0) {
                    outYaw += 360;
                }
            }
            if(Math.abs(outYaw) <= 360) {
                if(outYaw < 0) {
                    outYaw = 360 + outYaw;
                }
            }
        }
        return outYaw;
    }
}
