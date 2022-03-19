package com.albonec.othercode.multithreading;

import net.minecraft.client.Minecraft;


public class TrajectoriesThread extends Thread {
    private Minecraft mc = Minecraft.getMinecraft();

    @Override
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
        while (!this.isInterrupted()) {
            mc.gameSettings.playerHeading = getActualYaw(mc.thePlayer.rotationYawHead);
            mc.gameSettings.facingBlock = FacingBlock(new double[]{mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ}, getActualYaw(mc.thePlayer.rotationYawHead));
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

    private int[] FacingBlock(double[] playerCoordinates, double playerYaw) {
        int[] blockCoordinate = new int[0];

        if(playerYaw > 343.5 || playerYaw <= 22.5) {
            return new int[]{(int) playerCoordinates[0], (int) playerCoordinates[1], (int) playerCoordinates[2] + 1};
        }
        if(playerYaw > 22.5 && playerYaw <= 67.5) {
            return new int[]{(int) playerCoordinates[0] - 1, (int) playerCoordinates[1], (int) playerCoordinates[2] + 1};
        }
        if(playerYaw > 67.5 && playerYaw <= 112.5) {
            return new int[]{(int) playerCoordinates[0] - 1, (int) playerCoordinates[1], (int) playerCoordinates[2]};
        }
        if(playerYaw > 112.5 && playerYaw <= 157.5) {
            return new int[]{(int) playerCoordinates[0] - 1, (int) playerCoordinates[1], (int) playerCoordinates[2] - 1};
        }
        if(playerYaw > 157.5 && playerYaw <= 202.5) {
            return new int[]{(int) playerCoordinates[0], (int) playerCoordinates[1], (int) playerCoordinates[2] - 1};
        }
        if(playerYaw > 202.5 && playerYaw <= 247.5) {
            return new int[]{(int) playerCoordinates[0] + 1, (int) playerCoordinates[1], (int) playerCoordinates[2] - 1};
        }
        if(playerYaw > 247.5 && playerYaw <= 292.5) {
            return new int[]{(int) playerCoordinates[0] + 1, (int) playerCoordinates[1], (int) playerCoordinates[2]};
        }
        if(playerYaw > 292.5 && playerYaw <= 343.5) {
            return new int[]{(int) playerCoordinates[0] + 1, (int) playerCoordinates[1], (int) playerCoordinates[2] + 1};
        }

        return blockCoordinate;
    }



}
