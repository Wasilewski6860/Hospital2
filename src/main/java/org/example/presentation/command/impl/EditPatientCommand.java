package org.example.presentation.command.impl;

import org.example.domain.use_cases.EditPatientUseCase;
import org.example.domain.use_cases.ValidateDepartmentUseCase;
import org.example.domain.use_cases.ValidatePatientUseCase;
import org.example.presentation.command.Command;

import java.util.Scanner;

public class EditPatientCommand implements Command {

    private EditPatientUseCase editPatientUseCase;
    private ValidateDepartmentUseCase validateDepartmentUseCase;
    private ValidatePatientUseCase validatePatientUseCase;

    public EditPatientCommand(EditPatientUseCase editPatientUseCase,
                                 ValidateDepartmentUseCase validateDepartmentUseCase,
                                 ValidatePatientUseCase validatePatientUseCase) {
        this.editPatientUseCase = editPatientUseCase;
        this.validateDepartmentUseCase = validateDepartmentUseCase;
        this.validatePatientUseCase = validatePatientUseCase;
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
        System.out.println("Input patient id");
        in.nextLine();
        int patientId = in.nextInt();
        while (!validatePatientUseCase.execute(patientId)){
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
        editPatientUseCase.execute(id,patientId,name,gender);
    }

    @Override
    public String getMessage() {
        return "Edit patient ";
    }

}
