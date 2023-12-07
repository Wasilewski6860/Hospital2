package org.example.presentation.command.impl;

import org.example.domain.models.Patient;
import org.example.domain.use_cases.GetAllPatientsInDepartmentUseCase;
import org.example.domain.use_cases.ValidateDepartmentUseCase;
import org.example.presentation.command.Command;

import java.util.Scanner;

public class GetAllPatientsInDepartmentCommand implements Command {

    private GetAllPatientsInDepartmentUseCase getAllPatientsInDepartmentUseCase;
    private ValidateDepartmentUseCase validateDepartmentUseCase;

    public GetAllPatientsInDepartmentCommand(GetAllPatientsInDepartmentUseCase getAllPatientsInDepartmentUseCase, ValidateDepartmentUseCase validateDepartmentUseCase) {
        this.getAllPatientsInDepartmentUseCase = getAllPatientsInDepartmentUseCase;
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

        for (Patient patient : getAllPatientsInDepartmentUseCase.execute(id)){
            System.out.println(patient.toString());
        }
    }

    @Override
    public String getMessage() {
        return "All Patients in department ";
    }

}
