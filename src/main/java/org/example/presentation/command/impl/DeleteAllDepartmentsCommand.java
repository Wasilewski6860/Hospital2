package org.example.presentation.command.impl;

import org.example.domain.use_cases.DeleteAllDepartmentsUseCase;
import org.example.presentation.command.Command;

import java.util.Scanner;

public class DeleteAllDepartmentsCommand implements Command {

    private DeleteAllDepartmentsUseCase deleteAllDepartmentsUseCase;

    public DeleteAllDepartmentsCommand(DeleteAllDepartmentsUseCase deleteAllDepartmentsUseCase) {
        this.deleteAllDepartmentsUseCase = deleteAllDepartmentsUseCase;
    }

    @Override
    public void execute(Scanner in) {
        deleteAllDepartmentsUseCase.execute();
    }

    @Override
    public String getMessage() {
        return "Delete All Departments ";
    }
}
