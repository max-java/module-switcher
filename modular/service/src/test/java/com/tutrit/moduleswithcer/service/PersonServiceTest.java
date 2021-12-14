package com.tutrit.moduleswithcer.service;

import com.tutrit.moduleswithcer.persistence.dao.PersonDaoContract;
import com.tutrit.moduleswithcer.persistence.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    PersonDaoContract personDao;
    @InjectMocks
    PersonService personService;

    @Test
    void findPersonNameById() {
        Mockito.when(personDao.findById(1L)).thenReturn(new Person(1L, "Mikas"));
        String actual = personService.findPersonNameById(1L);
        assertEquals("Mikas", actual);
    }
}