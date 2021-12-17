package com.tutrit.moduleswithcer.monolith.controller.cmd;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;


@ConditionalOnProperty(prefix = "controller", name = "cmd")
public @interface EnableInConsoleCommands {
}
