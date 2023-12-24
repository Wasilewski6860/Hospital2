package org.example.domain.use_cases;


import org.example.data.repository.PatientRepositoryImpl;
import org.example.domain.models.Patient;
import org.example.domain.repositories.PatientRepository;

import java.util.List;

public class GetAllPatientsUseCase {

    public PatientRepository repository;
    private static GetAllPatientsUseCase INSTANCE = null;
    public static GetAllPatientsUseCase getInstance(){
        if (INSTANCE == null) INSTANCE = new GetAllPatientsUseCase(PatientRepositoryImpl.getInstance());
        return INSTANCE;
    }
    public GetAllPatientsUseCase(PatientRepository repository){
        this.repository = repository;
    }

    public List<Patient> execute(Integer departmentID){
        return repository.getAllPatientsInDepartment(departmentID);
    }

}
