package org.example.domain.use_cases;


import org.example.domain.models.Patient;
import org.example.domain.repositories.PatientRepository;

public class GetPatientUseCase {

    public PatientRepository repository;

    public GetPatientUseCase(PatientRepository repository){
        this.repository = repository;
    }

    public Patient execute(Integer itemId){
        return repository.getPatientById(itemId);
    }

}
