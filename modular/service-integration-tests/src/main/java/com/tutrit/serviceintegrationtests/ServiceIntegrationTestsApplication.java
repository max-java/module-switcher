package com.tutrit.serviceintegrationtests;

import com.tutrit.moduleswithcer.service.PersonService;
import com.tutrit.moduleswithcer.versioning.ModuleInfoProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.logging.Logger;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tutrit"})
public class ServiceIntegrationTestsApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ServiceIntegrationTestsApplication.class, args);
        String name = ctx
                .getBean(PersonService.class)
                .findPersonNameById(1L);
        System.out.println("database is " + name);

        try {
            ctx.getBean(ModuleInfoProvider.class)
                    .getModules()
                    .forEach(moduleInfo -> Logger.getLogger("[Modules]").info(String.format(moduleInfo.getInfo())));
        } catch (Exception e) {
            //silently do nothing
        }
    }
}
