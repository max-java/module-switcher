package com.tutrit.moduleswithcer.service;

import com.tutrit.moduleswithcer.persistence.dao.PersonDaoContract;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonDaoContract personDao;

    public PersonService(final PersonDaoContract personDao) {
        this.personDao = personDao;
    }

    public String findPersonNameById(Long id) {
        return personDao.findById(id).getName();
    }
}
