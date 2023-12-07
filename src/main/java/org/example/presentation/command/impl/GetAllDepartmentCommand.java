package org.example.presentation.command.impl;

import org.example.domain.models.Department;
import org.example.domain.use_cases.GetAllDepartmentsUseCase;
import org.example.presentation.command.Command;

import java.util.Scanner;

public class GetAllDepartmentCommand implements Command {

    private GetAllDepartmentsUseCase getAllDepartmentsUseCase;

    public GetAllDepartmentCommand(GetAllDepartmentsUseCase getAllDepartmentsUseCase) {
        this.getAllDepartmentsUseCase = getAllDepartmentsUseCase;
    }

    @Override
    public void execute(Scanner in) {
        System.out.println();
        System.out.println("All departments:");
       for (Department department : getAllDepartmentsUseCase.execute()){
           System.out.println(" "+department.toString());
       }
    }

    @Override
    public String getMessage() {
        return "All Departments ";
    }

}
