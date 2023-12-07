package org.example.data.repository;

import org.example.data.db.dto.PatientDto;
import org.example.data.db.impl.PatientStorageImpl;
import org.example.data.db.storage.PatientStorage;
import org.example.domain.models.Patient;
import org.example.domain.repositories.PatientRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PatientRepositoryImpl implements PatientRepository {
    private PatientStorage storage;

    public PatientRepositoryImpl(PatientStorage storage) {
        this.storage = storage;
    }

    @Override
    public void addPatient(Patient patient) {
        storage.addPatient(mapToData(patient));
    }

    @Override
    public Patient getPatientById(int id) {
        return mapToDomain(storage.getPatientById(id));
    }

    @Override
    public void editPatient(Patient patient) {
        storage.editPatient(mapToData(patient));
    }

    @Override
    public void deletePatient(int id) {
        storage.deletePatient(id);
    }

    @Override
    public void deletePatient(Patient patient) {
        storage.deletePatient(mapToData(patient));
    }

    @Override
    public List<Patient> getAllPatientsInDepartment(int id) {
        return storage.getAllPatientsInDepartment(id).stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }
    @Override
    public boolean isUserIdValid(int id) {
        return storage.isUserIdValid(id);
    }

    public Patient mapToDomain(PatientDto patientDto){
        return new Patient(patientDto.getDepartmentId(), patientDto.getID(),patientDto.getName(), patientDto.getGender());
    }
    public PatientDto mapToData(Patient patient){
        return new PatientDto(patient.getDepartmentId(), patient.getID(),patient.getName(), patient.getGender());
    }

    private static PatientRepositoryImpl INSTANCE = null;
    public static PatientRepositoryImpl getInstance(){
        if (INSTANCE == null) INSTANCE = new PatientRepositoryImpl(PatientStorageImpl.getInstance());
        return INSTANCE;
    }
}
