package com.tutrit.moduleswithcer.psqldao.dao;

import com.tutrit.moduleswithcer.persistence.dao.PersonDaoContract;
import com.tutrit.moduleswithcer.persistence.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDao implements PersonDaoContract {

    final private NamedParameterJdbcTemplate jdbcTemplate;

    public PersonDao(final NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Person findById(final Long id) {
        final String query = "SELECT * FROM person where person_id = :personId";
        SqlParameterSource params = new MapSqlParameterSource().addValue("personId", id);
        List<Person> person = jdbcTemplate.query(query, params, new BeanPropertyRowMapper<>(Person.class));
        return person.get(0);
    }
}
