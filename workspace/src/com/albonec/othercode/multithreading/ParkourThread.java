package com.albonec.othercode.multithreading;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;

public class ParkourThread extends Thread{

    private Minecraft mc = Minecraft.getMinecraft();

    private double calcDistance(double x, double y, double z) {
        return Math.hypot(Math.abs(z), Math.hypot(Math.abs(x), Math.abs(y)));
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


