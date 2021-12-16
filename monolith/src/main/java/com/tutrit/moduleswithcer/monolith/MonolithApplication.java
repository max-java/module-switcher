package com.tutrit.moduleswithcer.monolith;

import com.tutrit.moduleswithcer.monolith.controller.cmd.CommandDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@EnableFeignClients
@SpringBootApplication
public class MonolithApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MonolithApplication.class, args);
        runConsoleCommandDispatcher(ctx);
    }

    private static void runConsoleCommandDispatcher(ConfigurableApplicationContext ctx) {
        try {
            CommandDispatcher commandDispatcher = ctx.getBean(CommandDispatcher.class);
            commandDispatcher.run();
            ctx.close();
        } catch (Exception e) {
            System.out.println(":> cmd controller not initialized");
        }
    }
}
