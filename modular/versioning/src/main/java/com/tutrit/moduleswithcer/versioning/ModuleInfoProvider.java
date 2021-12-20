package com.tutrit.moduleswithcer.versioning;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModuleInfoProvider {
    private List<ModuleInfo> modules;

    public ModuleInfoProvider(final List<ModuleInfo> modules) {
        this.modules = modules;
    }

    public List<ModuleInfo> getModules() {
        if (modules == null || modules.size() == 0) {
            modules = List.of(new ModuleInfo() {
                @Override
                public String getInfo() {
                    return "No modules found";
                }
            });
        }
        return modules;
    }
}
