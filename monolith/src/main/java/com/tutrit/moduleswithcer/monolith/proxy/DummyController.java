package com.tutrit.moduleswithcer.monolith.proxy;

import com.tutrit.moduleswithcer.monolith.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The reason to create this class is just to have entry point to PersonGateway that
 * take a Person from http://localhost:8080/person/{id} endpoint as json response,
 * so make sure you have rest type for that endpoint enabled in your application.properties file.
  */
@RestController
@EnableConfigurationProperties
public class DummyController {

    PersonGateway personGateway;
    String controllerType;

    public DummyController(ApplicationContext ctx,
                           @Value("${controller.type:none}") String controllerType,
                           @Value("${proxy.type:feignGateway}") String proxyType) {
        this.controllerType = controllerType;
        this.personGateway = (PersonGateway) ctx.getBean(proxyType);
    }

    @GetMapping(value = "/")
    public Person getPerson() {
        if (!"rest".equals(controllerType)) {
            throw new RuntimeException("DummyController take a Person from http://localhost:8080/person/{id} endpoint \n " +
                    "as json response,  which mean in should be enabled in 'rest' type your application.properties file.");
        }
        return personGateway.getPersonById(1L);
    }
}
