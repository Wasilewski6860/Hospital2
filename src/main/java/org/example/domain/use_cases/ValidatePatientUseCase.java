package org.example.domain.use_cases;

import org.example.domain.repositories.PatientRepository;

public class ValidatePatientUseCase {
    public PatientRepository repository;

    public ValidatePatientUseCase(PatientRepository repository){
        this.repository = repository;
    }

    public boolean execute(int id){
        return repository.isUserIdValid(id);
    }

}
