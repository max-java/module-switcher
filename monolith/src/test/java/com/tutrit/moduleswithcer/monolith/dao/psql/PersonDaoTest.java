package com.tutrit.moduleswithcer.monolith.dao.psql;

import com.tutrit.moduleswithcer.monolith.dao.PersonDao;
import com.tutrit.moduleswithcer.monolith.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("psql")
class PersonDaoTest {

    @Autowired
    PersonDao personDao;

    @Test
    void findById() {
        Person person = personDao.findById(1L);
        assertEquals("PostgreSQL", person.getName());
    }
}