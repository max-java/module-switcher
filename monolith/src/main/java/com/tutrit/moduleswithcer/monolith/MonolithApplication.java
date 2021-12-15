package com.tutrit.moduleswithcer.monolith;

import com.tutrit.moduleswithcer.monolith.controller.cmd.PersonCmdController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MonolithApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MonolithApplication.class, args);
        try {
            PersonCmdController pcc = ctx.getBean(PersonCmdController.class);
            pcc.getPerson(args);
            ctx.close();
        } catch (Exception e) {
            // TODO: 12/15/21 message?
        }
    }
}
