package org.example.presentation.command.impl;

import org.example.domain.use_cases.EditDepartmentUseCase;
import org.example.domain.use_cases.ValidateDepartmentUseCase;
import org.example.presentation.command.Command;

import java.util.Scanner;

public class EditDepartmentCommand implements Command {
    private EditDepartmentUseCase editDepartmentUseCase;
    private ValidateDepartmentUseCase validateDepartmentUseCase;

    public EditDepartmentCommand(EditDepartmentUseCase editDepartmentUseCase, ValidateDepartmentUseCase validateDepartmentUseCase) {
        this.editDepartmentUseCase = editDepartmentUseCase;
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
        System.out.println("Input name");
        in.nextLine();
        String name = in.nextLine();
        editDepartmentUseCase.execute(id,name);
    }

    @Override
    public String getMessage() {
        return "Editting department ";
    }
}
