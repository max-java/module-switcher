package com.tutrit.moduleswithcer.info;

import com.tutrit.moduleswithcer.versioning.ModuleInfo;
import org.springframework.stereotype.Component;

@Component
public class ServiceModuleInfo implements ModuleInfo {

    @Override
    public String getInfo() {
        return "com.tutrit.moduleswithcer ";
    }
}
