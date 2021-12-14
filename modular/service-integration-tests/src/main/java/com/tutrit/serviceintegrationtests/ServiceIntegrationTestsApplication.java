package com.tutrit.serviceintegrationtests;

import com.tutrit.moduleswithcer.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tutrit"})
public class ServiceIntegrationTestsApplication {

    public static void main(String[] args) {
        String name = SpringApplication.run(ServiceIntegrationTestsApplication.class, args)
                .getBean(PersonService.class)
                .findPersonNameById(1L);
        System.out.println("database is " + name);
    }

}
