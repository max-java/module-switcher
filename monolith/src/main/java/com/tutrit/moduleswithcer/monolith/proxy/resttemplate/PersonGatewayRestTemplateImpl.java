package com.tutrit.moduleswithcer.monolith.proxy.resttemplate;

import com.tutrit.moduleswithcer.monolith.model.Person;
import com.tutrit.moduleswithcer.monolith.proxy.PersonGateway;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("restTemplateGateway")
public class PersonGatewayRestTemplateImpl implements PersonGateway {

    final RestTemplate restTemplate;

    public PersonGatewayRestTemplateImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Person getPersonById(Long id) {
        return restTemplate
                .getForObject("http://localhost:8080/person/1", Person.class);
    }
}
