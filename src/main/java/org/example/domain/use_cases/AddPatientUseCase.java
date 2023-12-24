package org.example.domain.use_cases;


import org.example.data.repository.DepartmentRepositoryImpl;
import org.example.data.repository.PatientRepositoryImpl;
import org.example.domain.models.Patient;
import org.example.domain.repositories.PatientRepository;

public class AddPatientUseCase {

    public PatientRepository repository;
    private static AddPatientUseCase INSTANCE = null;
    public static AddPatientUseCase getInstance(){
        if (INSTANCE == null) INSTANCE = new AddPatientUseCase(PatientRepositoryImpl.getInstance());
        return INSTANCE;
    }
    public AddPatientUseCase(PatientRepository repository){
        this.repository = repository;
    }

    public void execute(Integer departmentID, String name, String gender){
        repository.addPatient(new Patient(departmentID,name,gender));
    }

}
