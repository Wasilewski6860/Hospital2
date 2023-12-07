package org.example.domain.use_cases;


import org.example.domain.models.Patient;
import org.example.domain.repositories.PatientRepository;

import java.util.List;

public class GetAllPatientsInDepartmentUseCase {

    public PatientRepository repository;

    public GetAllPatientsInDepartmentUseCase(PatientRepository repository){
        this.repository = repository;
    }

    public List<Patient> execute(Integer departmentID){
        List<Patient> entities = repository.getAllPatientsInDepartment(departmentID);
        return entities;
    }

}
