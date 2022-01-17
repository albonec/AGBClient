package com.albonec.othercode.module;

import java.util.ArrayList;

public class ModuleManager {
    private ArrayList<Module> modules = new ArrayList<Module>();

    public ModuleManager() {
        //COMBAT

        //MOVEMENT

        //RENDER

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
