package com.tutrit.moduleswithcer.monolith.dao.mysql;

import com.tutrit.moduleswithcer.monolith.dao.PersonDao;
import com.tutrit.moduleswithcer.monolith.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("mysql")
class PersonDaoTest {

    @Autowired
    PersonDao personDao;
    @Autowired
    DataSource source;

    @Test
    void findById() throws Exception {
        Person person = personDao.findById(1L);
        assertEquals("maria", person.getName());
        assertEquals("MariaDB", personDao.getJdbcTemplate().getJdbcTemplate().getDataSource().getConnection().getMetaData().getDatabaseProductName());
    }
}
