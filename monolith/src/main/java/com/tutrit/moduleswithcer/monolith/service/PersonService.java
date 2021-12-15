package com.tutrit.moduleswithcer.monolith.service;

import com.tutrit.moduleswithcer.monolith.dao.PersonDao;
import com.tutrit.moduleswithcer.monolith.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    final PersonDao personDao;

    public PersonService(final PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person findById(final Long id) {
        return personDao.findById(id);
    }
}
