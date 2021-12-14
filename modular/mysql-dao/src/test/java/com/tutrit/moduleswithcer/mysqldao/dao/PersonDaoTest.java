package com.tutrit.moduleswithcer.mysqldao.dao;


import com.tutrit.moduleswithcer.mysqldao.config.DataSourceConfig;
import com.tutrit.moduleswithcer.persistence.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {DataSourceConfig.class})
@ComponentScan
@EnableAutoConfiguration
class PersonDaoTest {

    @Autowired
    PersonDao personDao;

    @Test
    void findById() {
        Person person = personDao.findById(1L);
        assertEquals("maria", person.getName());
    }
}