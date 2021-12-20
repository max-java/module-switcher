package com.tutrit.moduleswithcer.persistence.info;

import com.tutrit.moduleswithcer.versioning.ModuleInfo;
import org.springframework.stereotype.Component;

@Component
public class PersistenceModuleInfo implements ModuleInfo {
    @Override
    public String getInfo() {
        return "com.tutrit.moduleswithcer.persistence";
    }
}
