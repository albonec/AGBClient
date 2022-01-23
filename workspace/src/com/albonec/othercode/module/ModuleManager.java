package com.albonec.othercode.module;

import com.albonec.othercode.module.render.QuickHitboxes;
import com.albonec.othercode.module.render.Zoom;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;

public class ModuleManager {
    private ArrayList<Module> modules = new ArrayList<Module>();
    private Minecraft mc = Minecraft.getMinecraft();

    public ModuleManager() {
        //COMBAT

        //MOVEMENT

        //RENDER
        modules.add(new Zoom());
        modules.add(new QuickHitboxes());

        //PLAYER

        //MISC

        //NONE
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public Module getModuleByName(String name) {
        return modules.stream().filter(module -> module.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
