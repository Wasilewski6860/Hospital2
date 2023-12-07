package org.example.domain.use_cases;


import org.example.domain.models.Patient;
import org.example.domain.repositories.PatientRepository;

public class AddPatientUseCase {

    public PatientRepository repository;

    public AddPatientUseCase(PatientRepository repository){
        this.repository = repository;
    }

    public void execute(Integer departmentID, String name, String gender){
        repository.addPatient(new Patient(departmentID,name,gender));
    }

}
