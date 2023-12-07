package org.example.presentation.command.impl;

import org.example.domain.use_cases.AddPatientUseCase;
import org.example.domain.use_cases.ValidateDepartmentUseCase;
import org.example.presentation.command.Command;

import java.util.Scanner;

public class AddPatientCommand implements Command {

    private AddPatientUseCase addPatientUseCase;
    private ValidateDepartmentUseCase validateDepartmentUseCase;

    public AddPatientCommand(AddPatientUseCase addPatientUseCase, ValidateDepartmentUseCase validateDepartmentUseCase) {
        this.addPatientUseCase = addPatientUseCase;
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
        System.out.println("Input gender");
        String gender = in.nextLine();
        addPatientUseCase.execute(id,name,gender);
    }

    @Override
    public String getMessage() {
        return "Add Patient ";
    }
}
