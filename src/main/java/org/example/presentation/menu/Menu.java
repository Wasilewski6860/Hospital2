package org.example.presentation.menu;

import org.example.data.repository.DepartmentRepositoryImpl;
import org.example.data.repository.PatientRepositoryImpl;
import org.example.domain.repositories.DepartmentRepository;
import org.example.domain.repositories.PatientRepository;
import org.example.domain.use_cases.*;
import org.example.presentation.command.Command;
import org.example.presentation.command.impl.*;

import java.util.Scanner;

public class Menu {

    private static Scanner in;
    private static final PatientRepository patientRepository = PatientRepositoryImpl.getInstance();
    private static final DepartmentRepository departmentRepository = DepartmentRepositoryImpl.getInstance();
    private final Command[] commands = new Command[]{
            new GetAllDepartmentCommand(new GetAllDepartmentsUseCase(departmentRepository)),
            new GetDepartmentCommand(new GetAllPatientsInDepartmentUseCase(patientRepository),new GetDepartmentUseCase(departmentRepository),new ValidateDepartmentUseCase(departmentRepository)),
            new AddDepartmentCommand(new AddDepartmentUseCase(departmentRepository)),
            new EditDepartmentCommand(new EditDepartmentUseCase(departmentRepository),new ValidateDepartmentUseCase(departmentRepository)),
            new DeleteAllDepartmentsCommand(new DeleteAllDepartmentsUseCase(departmentRepository)),
            new DeleteDepartmentCommand(new DeleteDepartmentUseCase(departmentRepository),new ValidateDepartmentUseCase(departmentRepository)),
            new GetAllPatientsCommand(new GetAllPatientsUseCase(patientRepository), new ValidateDepartmentUseCase(departmentRepository)),
            new GetPatientCommand(new GetPatientUseCase(patientRepository), new ValidatePatientUseCase(patientRepository)),
            new AddPatientCommand(new AddPatientUseCase(patientRepository), new ValidateDepartmentUseCase(departmentRepository)),
            new EditPatientCommand(new EditPatientUseCase(patientRepository), new ValidateDepartmentUseCase(departmentRepository), new ValidatePatientUseCase(patientRepository)),
            new RemovePatientCommand(new RemovePatientUseCase(patientRepository), new ValidatePatientUseCase(patientRepository))

    };

    public void printMenu(){
        in = new Scanner(System.in);

        Scanner in = new Scanner(System.in);
        try {
            boolean isContinue = true;
            while (isContinue) {
                System.out.println();
                System.out.println("Menu:");
                for (int i=0;i<commands.length;i++){
                    System.out.println(" "+i+"- "+commands[i].getMessage());
                }
                System.out.println(" "+commands.length+"- Exit");
                System.out.println();
                int com = in.nextInt();
                if (com >= 0 && com < commands.length)
                   commands[com].execute(in);
                else if (com == commands.length)
                    break;
                else System.out.println(" It's wrong, try again \n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public boolean isValid(String s){
        return isNumeric(s) && Integer.parseInt(s) >= 0 && Integer.parseInt(s) < commands.length;
    }

}