package com.tutrit.moduleswithcer.monolith.proxy.feign;

import com.tutrit.moduleswithcer.monolith.model.Person;
import com.tutrit.moduleswithcer.monolith.proxy.PersonGateway;
import org.springframework.stereotype.Component;

@Component("feignGateway")
public class PersonGatewayFeignImpl implements PersonGateway {

    final PersonProxyFeign personProxyFeign;

    public PersonGatewayFeignImpl(PersonProxyFeign personProxyFeign) {
        this.personProxyFeign = personProxyFeign;
    }

    @Override
    public Person getPersonById(Long id) {
        return personProxyFeign.getPersonById(id);
    }
}
