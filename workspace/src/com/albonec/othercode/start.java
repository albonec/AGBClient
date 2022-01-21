package com.albonec.othercode;

import com.albonec.othercode.event.EventManager;
import com.albonec.othercode.event.EventTarget;
import com.albonec.othercode.event.events.EventKey;
import com.albonec.othercode.module.ModuleManager;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

public class start {
    public String ClientName = "AGB's Minecraft Client";

    public static start instance = new start();
    private Minecraft mc = Minecraft.getMinecraft();

    public EventManager eventManager;
    public ModuleManager moduleManager;

    public void start() {
        eventManager = new EventManager();
        moduleManager = new ModuleManager();

        System.out.println(ClientName);
        Display.setTitle(ClientName);

        eventManager.register(this);
    }

    public void stop() {
        eventManager.unregister(this);
    }

    @EventTarget
    public void onKey(EventKey event) {
        moduleManager.getModules().stream().filter(module -> module.getKey() == event.getKey()).forEach(module -> module.toggle());
    }

}
