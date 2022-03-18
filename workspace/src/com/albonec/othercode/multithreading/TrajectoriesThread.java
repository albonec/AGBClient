package com.albonec.othercode.multithreading;

import net.minecraft.client.Minecraft;

public class TrajectoriesThread extends Thread {
    private Minecraft mc = Minecraft.getMinecraft();

    @Override
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
        while (!this.isInterrupted()) {
            System.out.println(getActualYaw(mc.thePlayer.rotationYawHead));
        }
    }

    private double getActualYaw(double reportedYaw) {
        double outYaw = reportedYaw;
        int sign = reportedYaw < 0 ? -1 : 1;
        if (Math.abs(reportedYaw) <= 360) {
            return reportedYaw;
        } else {
            while(Math.abs(outYaw) > 360) {
                outYaw -= sign * 360;
            }
        }
        return outYaw * sign;
    }
}
