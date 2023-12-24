package org.example.domain.use_cases;

import org.example.data.repository.PatientRepositoryImpl;
import org.example.domain.repositories.PatientRepository;

public class RemovePatientUseCase {

    public PatientRepository repository;
    private static RemovePatientUseCase INSTANCE = null;
    public static RemovePatientUseCase getInstance(){
        if (INSTANCE == null) INSTANCE = new RemovePatientUseCase(PatientRepositoryImpl.getInstance());
        return INSTANCE;
    }
    public RemovePatientUseCase(PatientRepository repository){
        this.repository = repository;
    }

    public void execute(Integer patientId){
        repository.deletePatient(patientId);
    }

}
