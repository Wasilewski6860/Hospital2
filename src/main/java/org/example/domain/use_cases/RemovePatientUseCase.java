package org.example.domain.use_cases;

import org.example.domain.repositories.PatientRepository;

public class RemovePatientUseCase {

    public PatientRepository repository;

    public RemovePatientUseCase(PatientRepository repository){
        this.repository = repository;
    }

    public void execute(Integer patientId){
        repository.deletePatient(patientId);
    }

}
