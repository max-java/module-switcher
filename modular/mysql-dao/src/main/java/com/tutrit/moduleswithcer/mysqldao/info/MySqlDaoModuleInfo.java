package com.tutrit.moduleswithcer.mysqldao.info;

import com.tutrit.moduleswithcer.versioning.ModuleInfo;
import org.springframework.stereotype.Component;

@Component
public class MySqlDaoModuleInfo implements ModuleInfo {
    @Override
    public String getInfo() {
        return "com.tutrit.moduleswithcer.mysqldao";
    }
}

