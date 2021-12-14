package com.tutrit.serviceintegrationtests;

import com.tutrit.moduleswithcer.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.tutrit"})
public class PersonServiceIntTest {

    @Autowired
    PersonService personService;

    @Test
    public void findPersonNameById() {
        String actual = personService.findPersonNameById(1L);
//        assertEquals("maria", actual, "Database is not a mariaDB!");
//        assertEquals("PostgreSQL", actual, "Database is not a PostgreSQL!");
    }
}
