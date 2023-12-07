package org.example.presentation.command.impl;

import org.example.domain.use_cases.DeleteDepartmentUseCase;
import org.example.domain.use_cases.ValidateDepartmentUseCase;
import org.example.presentation.command.Command;

import java.util.Scanner;

public class DeleteDepartmentCommand implements Command {
    private DeleteDepartmentUseCase deleteDepartmentUseCase;
    private ValidateDepartmentUseCase validateDepartmentUseCase;

    public DeleteDepartmentCommand(DeleteDepartmentUseCase deleteDepartmentUseCase, ValidateDepartmentUseCase validateDepartmentUseCase) {
        this.deleteDepartmentUseCase = deleteDepartmentUseCase;
        this.validateDepartmentUseCase = validateDepartmentUseCase;
    }

    @Override
    public void execute(Scanner in) {
        System.out.println("Input department id");
        int id = in.nextInt();
        while (!validateDepartmentUseCase.execute(id)){
            System.out.println("It's wrong, try again  or close( \" close\" )");
            in.nextLine();
            String s= in.nextLine();
            if (s.equals("close")){
                return;
            }
            id = Integer.parseInt(s);
        }
        deleteDepartmentUseCase.execute(id);
    }

    @Override
    public String getMessage() {
        return "Delete department ";
    }
}
