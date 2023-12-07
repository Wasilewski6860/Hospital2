package org.example.presentation.command.impl;

import org.example.domain.use_cases.GetPatientUseCase;
import org.example.domain.use_cases.ValidatePatientUseCase;
import org.example.presentation.command.Command;

import java.util.Scanner;

public class GetPatientCommand implements Command {

    private GetPatientUseCase getPatientUseCase;
    private ValidatePatientUseCase validatePatientUseCase;

    public GetPatientCommand(GetPatientUseCase getPatientUseCase,ValidatePatientUseCase validatePatientUseCase) {
        this.getPatientUseCase = getPatientUseCase;
        this.validatePatientUseCase = validatePatientUseCase;
    }

    @Override
    public void execute(Scanner in) {
        System.out.println("Input patient id");
        int id = in.nextInt();
        while (!validatePatientUseCase.execute(id)){
            System.out.println("It's wrong, try again  or close( \" close\" )");
            in.nextLine();
            String s= in.nextLine();
            if (s.equals("close")){
                return;
            }
            id = Integer.parseInt(s);;
        }

        System.out.println(getPatientUseCase.execute(id).toString());
    }

    @Override
    public String getMessage() {
        return "Patient info ";
    }

}
