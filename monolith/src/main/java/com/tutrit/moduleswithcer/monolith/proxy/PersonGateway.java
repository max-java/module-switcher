package com.tutrit.moduleswithcer.monolith.proxy;

import com.tutrit.moduleswithcer.monolith.model.Person;

public interface PersonGateway {

    Person getPersonById(Long id);
}
