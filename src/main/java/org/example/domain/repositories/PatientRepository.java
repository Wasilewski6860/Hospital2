package org.example.domain.repositories;

import org.example.domain.models.Patient;

import java.util.List;

public interface PatientRepository {

    void addPatient(Patient patient);
    Patient getPatientById(int id);
    void editPatient(Patient patient);
    void deletePatient(int id);
    void deletePatient(Patient patient);
    List<Patient> getAllPatientsInDepartment(int id);
    boolean isUserIdValid(int id);
}
