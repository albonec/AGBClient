package com.albonec.othercode;

import com.albonec.othercode.event.EventManager;
import org.lwjgl.opengl.Display;

public class start {
    public String ClientName = "AGB's Minecraft Client";

    public static start instance = new start();

    public EventManager eventManager;

    public void start() {
        eventManager = new EventManager();

        System.out.println(ClientName);
        Display.setTitle(ClientName);

        eventManager.register(this);
    }

    public void stop() {
        eventManager.unregister(this);
    }
}
