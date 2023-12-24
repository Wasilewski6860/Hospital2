package org.example.domain.use_cases;


import org.example.data.repository.PatientRepositoryImpl;
import org.example.domain.models.Patient;
import org.example.domain.repositories.PatientRepository;

public class GetPatientUseCase {

    public PatientRepository repository;
    private static GetPatientUseCase INSTANCE = null;
    public static GetPatientUseCase getInstance(){
        if (INSTANCE == null) INSTANCE = new GetPatientUseCase(PatientRepositoryImpl.getInstance());
        return INSTANCE;
    }
    public GetPatientUseCase(PatientRepository repository){
        this.repository = repository;
    }

    public Patient execute(Integer itemId){
        return repository.getPatientById(itemId);
    }

}
