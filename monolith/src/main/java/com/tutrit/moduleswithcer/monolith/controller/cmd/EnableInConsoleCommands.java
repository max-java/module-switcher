package com.tutrit.moduleswithcer.monolith.controller.cmd;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(prefix = "controller", name = "cmd")
public @interface EnableInConsoleCommands {
}
