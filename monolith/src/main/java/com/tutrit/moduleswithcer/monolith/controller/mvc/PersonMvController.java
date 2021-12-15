package com.tutrit.moduleswithcer.monolith.controller.mvc;

import com.tutrit.moduleswithcer.monolith.service.PersonService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ConditionalOnProperty(prefix = "controller", name = "type", havingValue = "mvc")
public class PersonMvController {

    PersonService personService;

    public PersonMvController(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person/{id}")
    public ModelAndView getPerson(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("person-card");
        modelAndView.addObject("person", personService.findById(id));
        return modelAndView;
    }
}
