package org.example.presentation.command.impl;

import org.example.domain.models.Patient;
import org.example.domain.use_cases.GetAllPatientsInDepartmentUseCase;
import org.example.domain.use_cases.GetDepartmentUseCase;
import org.example.domain.use_cases.ValidateDepartmentUseCase;
import org.example.presentation.command.Command;

import java.util.Scanner;

public class GetDepartmentCommand implements Command {

    private GetAllPatientsInDepartmentUseCase getAllPatientsInDepartmentUseCase;
    private GetDepartmentUseCase getDepartmentUseCase;
    private ValidateDepartmentUseCase validateDepartmentUseCase;

    public GetDepartmentCommand(GetAllPatientsInDepartmentUseCase getAllPatientsInDepartmentUseCase, GetDepartmentUseCase getDepartmentUseCase, ValidateDepartmentUseCase validateDepartmentUseCase) {
        this.getAllPatientsInDepartmentUseCase = getAllPatientsInDepartmentUseCase;
        this.getDepartmentUseCase = getDepartmentUseCase;
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
            System.out.println();
        }

        System.out.println();
        System.out.println("Department info");
        System.out.println(" "+getDepartmentUseCase.execute(id).toString());
        for (Patient patient : getAllPatientsInDepartmentUseCase.execute(id)){
            System.out.println("  "+patient.toString());
        }
    }

    @Override
    public String getMessage() {
        return "Department info ";
    }

}
