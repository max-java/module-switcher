package com.tutrit.moduleswithcer.psqldao.info;

import com.tutrit.moduleswithcer.versioning.ModuleInfo;
import org.springframework.stereotype.Component;

@Component
public class PsqlDaoModuleInfo implements ModuleInfo {
    @Override
    public String getInfo() {
        return "com.tutrit.moduleswithcer.psqldao";
    }
}
