package com.tutrit.moduleswithcer.persistence.dao;

import com.tutrit.moduleswithcer.persistence.model.Person;

public interface PersonDaoContract {
    Person findById(final Long id);
}
