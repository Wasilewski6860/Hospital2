package org.example.domain.use_cases;


import org.example.data.repository.PatientRepositoryImpl;
import org.example.domain.models.Patient;
import org.example.domain.repositories.PatientRepository;

import java.util.List;

public class GetAllPatientsInDepartmentUseCase {

    public PatientRepository repository;
    private static GetAllPatientsInDepartmentUseCase INSTANCE = null;
    public static GetAllPatientsInDepartmentUseCase getInstance(){
        if (INSTANCE == null) INSTANCE = new GetAllPatientsInDepartmentUseCase(PatientRepositoryImpl.getInstance());
        return INSTANCE;
    }
    public GetAllPatientsInDepartmentUseCase(PatientRepository repository){
        this.repository = repository;
    }

    public List<Patient> execute(Integer departmentID){
        List<Patient> entities = repository.getAllPatientsInDepartment(departmentID);
        return entities;
    }

}
