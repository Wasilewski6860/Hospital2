package org.example.data.db.storage;

import org.example.data.db.dto.PatientDto;

import java.util.List;

public interface PatientStorage {

    void addPatient(PatientDto patientDto);
    PatientDto getPatientById(int id);
    void editPatient(PatientDto patientDto);
    void deletePatient(int id);
    void deletePatient(PatientDto patientDto);
    List<PatientDto> getAllPatientsInDepartment(int id);
    void deleteAllPatientsInDepartment(int id);
    boolean isUserIdValid(int id);

}
