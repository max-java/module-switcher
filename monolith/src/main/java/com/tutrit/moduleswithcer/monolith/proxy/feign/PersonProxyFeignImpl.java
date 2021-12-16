package com.tutrit.moduleswithcer.monolith.proxy.feign;

import com.tutrit.moduleswithcer.monolith.model.Person;
import com.tutrit.moduleswithcer.monolith.proxy.PersonGateway;
import org.springframework.stereotype.Component;

@Component
public class PersonProxyFeignImpl implements PersonGateway {

    final PersonProxyFeign personProxyFeign;

    public PersonProxyFeignImpl(PersonProxyFeign personProxyFeign) {
        this.personProxyFeign = personProxyFeign;
    }

    @Override
    public Person getPersonById(Long id) {
        return personProxyFeign.getPersonById(id);
    }
}
