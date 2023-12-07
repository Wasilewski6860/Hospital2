package org.example.domain.use_cases;


import org.example.domain.models.Patient;
import org.example.domain.repositories.PatientRepository;

import java.util.List;

public class GetAllPatientsUseCase {

    public PatientRepository repository;

    public GetAllPatientsUseCase(PatientRepository repository){
        this.repository = repository;
    }

    public List<Patient> execute(Integer departmentID){
        return repository.getAllPatientsInDepartment(departmentID);
    }

}
