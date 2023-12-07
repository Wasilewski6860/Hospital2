package org.example.presentation.command;

import java.util.Scanner;

public interface Command {

    void execute(Scanner in);

    String getMessage();
}
