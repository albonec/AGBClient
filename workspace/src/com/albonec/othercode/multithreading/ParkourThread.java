package com.albonec.othercode.multithreading;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;

public class ParkourThread extends Thread{

    private Minecraft mc = Minecraft.getMinecraft();

    /*
    n^n+1/n+1
     */

    private String getArcFunction(int[] blockCoordinates) {
        double secantSlope2D = (mc.thePlayer.posY - blockCoordinates[1]) / (mc.thePlayer.posX - blockCoordinates[0]);
        double secantYIntercept = mc.thePlayer.posY - blockCoordinates[1];

        String function = Math.abs(secantSlope2D/2) + "x^2" + (secantYIntercept < 0 ? " - " : " + ") + Math.abs(secantYIntercept) + "x" + " + " + secantYIntercept;
        return function;
    }

    private double calcDistance(double x, double y, double z) {
        return Math.hypot(Math.abs(y), Math.hypot(Math.abs(x), Math.abs(z)));
    }

    @Override
    public void run() {
        for (int i = 0; i < 28; i++) {
            if(!Block.isEqualTo(Block.getBlockById(0), Block.getBlockById(9))) {
                //render code goes here
            }
        }
    }
}


