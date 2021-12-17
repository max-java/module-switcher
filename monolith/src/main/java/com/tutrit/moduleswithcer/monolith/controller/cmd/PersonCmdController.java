package com.tutrit.moduleswithcer.monolith.controller.cmd;

import com.tutrit.moduleswithcer.monolith.service.PersonService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
@EnableInConsoleCommands
public class PersonCmdController {

    final PersonService personService;

    public PersonCmdController(PersonService personService) {
        this.personService = personService;
    }

    public void getPerson(String command) {
        if ("person/1".equals(command)) {
            System.out.println(personService.findById(1L));

        } else {
            System.out.println("Entity not found or bad command ");
        }
    }
}
