package com.tutrit.serviceintegrationtests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.tutrit.moduleswithcer")
class ServiceIntegrationTestsApplicationTests {

    @Test
    void contextLoads() {
    }
}
