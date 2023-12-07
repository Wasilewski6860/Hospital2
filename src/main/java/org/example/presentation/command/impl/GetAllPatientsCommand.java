package org.example.presentation.command.impl;

import org.example.domain.models.Patient;
import org.example.domain.use_cases.GetAllPatientsUseCase;
import org.example.domain.use_cases.ValidateDepartmentUseCase;
import org.example.presentation.command.Command;

import java.util.Scanner;

public class GetAllPatientsCommand implements Command {

    private GetAllPatientsUseCase getAllPatientsUseCase;
    private ValidateDepartmentUseCase validateDepartmentUseCase;

    public GetAllPatientsCommand(GetAllPatientsUseCase getAllPatientsUseCase,ValidateDepartmentUseCase validateDepartmentUseCase) {
        this.getAllPatientsUseCase = getAllPatientsUseCase;
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

        for (Patient patient : getAllPatientsUseCase.execute(id)){
            System.out.println(patient.toString());
        }
    }

    @Override
    public String getMessage() {
        return "All Patients in department ";
    }

}
