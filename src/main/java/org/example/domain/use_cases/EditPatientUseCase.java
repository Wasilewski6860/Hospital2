package org.example.domain.use_cases;


import org.example.data.repository.PatientRepositoryImpl;
import org.example.domain.models.Patient;
import org.example.domain.repositories.PatientRepository;

public class EditPatientUseCase {

    public PatientRepository repository;
    private static EditPatientUseCase INSTANCE = null;
    public static EditPatientUseCase getInstance(){
        if (INSTANCE == null) INSTANCE = new EditPatientUseCase(PatientRepositoryImpl.getInstance());
        return INSTANCE;
    }
    public EditPatientUseCase(PatientRepository repository){
        this.repository = repository;
    }

    public void execute(Integer departmentID,Integer patientId, String name, String gender){
        repository.editPatient(new Patient(departmentID,patientId,name,gender));
    }

}
