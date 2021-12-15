package com.tutrit.moduleswithcer.monolith.controller.rest;

import com.tutrit.moduleswithcer.monolith.model.Person;
import com.tutrit.moduleswithcer.monolith.service.PersonService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnProperty(prefix = "controller", name = "type", havingValue = "rest")
public class PersonRestController {

    PersonService personService;

    public PersonRestController(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.findById(id);
    }
}
