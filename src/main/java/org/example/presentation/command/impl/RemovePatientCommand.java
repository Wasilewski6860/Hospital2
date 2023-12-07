package org.example.presentation.command.impl;

import org.example.domain.use_cases.RemovePatientUseCase;
import org.example.domain.use_cases.ValidatePatientUseCase;
import org.example.presentation.command.Command;

import java.util.Scanner;

public class RemovePatientCommand implements Command {

    private RemovePatientUseCase removePatientUseCase;
    private ValidatePatientUseCase validatePatientUseCase;

    public RemovePatientCommand(RemovePatientUseCase removePatientUseCase,ValidatePatientUseCase validatePatientUseCase) {
        this.removePatientUseCase = removePatientUseCase;
        this.validatePatientUseCase = validatePatientUseCase;
    }

    @Override
    public void execute(Scanner in) {
        System.out.println("Input patient id");
        int id = in.nextInt();
        while (!validatePatientUseCase.execute(id)){
            System.out.println("It's wrong, try again or close( \" close\" )");
            in.nextLine();
            String s= in.nextLine();
            if (s.equals("close")){
                return;
            }
            id = Integer.parseInt(s);
        }

        removePatientUseCase.execute(id);
        System.out.println("Patient removed");
    }

    @Override
    public String getMessage() {
        return "Remove patient ";
    }

}
