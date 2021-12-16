package com.tutrit.moduleswithcer.monolith.controller.cmd;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@EnableInConsoleCommands
public class CommandDispatcher {

    final PersonCmdController pcc;

    public CommandDispatcher(PersonCmdController personCmdController) {
        this.pcc = personCmdController;
    }

    public void run() {
        String command;
        do {
            System.out.println(":> Enter command (i.e.: person/1) or type `exit` for close:");
            Scanner in = new Scanner(System.in);
            command = in.nextLine();
            pcc.getPerson(command);
        } while (!"exit".equals(command));
    }
}
