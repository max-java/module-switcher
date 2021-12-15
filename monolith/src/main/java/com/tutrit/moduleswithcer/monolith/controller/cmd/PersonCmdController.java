package com.tutrit.moduleswithcer.monolith.controller.cmd;

import com.tutrit.moduleswithcer.monolith.service.PersonService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "controller", name = "cmd")
public class PersonCmdController {

    final PersonService personService;

    public PersonCmdController(PersonService personService) {
        this.personService = personService;
    }

    public void getPerson(String[] args) {
        try {
            if("person/1".equals(args[0])) {
                System.out.println(personService.findById(1L));
            }
        } catch (Exception e) {
            System.out.println("Command not found Exception");
        }
    }
}
