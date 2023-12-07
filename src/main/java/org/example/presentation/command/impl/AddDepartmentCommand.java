package org.example.presentation.command.impl;

import org.example.domain.use_cases.AddDepartmentUseCase;
import org.example.presentation.command.Command;

import java.util.Scanner;

public class AddDepartmentCommand implements Command {

    private AddDepartmentUseCase addDepartmentUseCase;

    public AddDepartmentCommand(AddDepartmentUseCase addDepartmentUseCase) {
        this.addDepartmentUseCase = addDepartmentUseCase;
    }

    @Override
    public void execute(Scanner in) {
        System.out.println("Input name");
        in.nextLine();
        String name = in.nextLine();
        addDepartmentUseCase.execute(name);
    }

    @Override
    public String getMessage() {
        return "Add Department ";
    }
}
