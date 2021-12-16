package com.tutrit.moduleswithcer.monolith.proxy.feign;

import com.tutrit.moduleswithcer.monolith.model.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "outside-service", url = "http://localhost:8080/")
public interface PersonProxyFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/person/{id}", produces = "application/json")
    Person getPersonById(@PathVariable("id") Long id);
}