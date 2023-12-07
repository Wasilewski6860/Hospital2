package org.example.data.db.impl;

import org.example.data.db.HospitalDatabase;
import org.example.data.db.dao.HospitalDao;
import org.example.data.db.dao.PatientDao;
import org.example.data.db.dto.PatientDto;
import org.example.data.db.storage.PatientStorage;

import java.util.List;

public class PatientStorageImpl implements PatientStorage {

    private PatientDao dao;

    public PatientStorageImpl(HospitalDatabase hospitalDatabase) {
        dao = hospitalDatabase.getPatientDao();
    }

    @Override
    public void addPatient(PatientDto patientDto) {
        dao.addPatient(patientDto);
    }

    @Override
    public PatientDto getPatientById(int id) {
        return dao.getPatientById(id);
    }

    @Override
    public void editPatient(PatientDto patientDto) {
        dao.editPatient(patientDto);
    }

    @Override
    public void deletePatient(int id) {
        dao.deletePatient(id);
    }

    @Override
    public void deletePatient(PatientDto patientDto) {
        dao.deletePatient(patientDto);
    }

    @Override
    public List<PatientDto> getAllPatientsInDepartment(int id) {
        return dao.getAllPatientsInDepartment(id);
    }

    @Override
    public void deleteAllPatientsInDepartment(int id) {
        dao.deleteAllPatientsInDepartment(id);
    }

    @Override
    public boolean isUserIdValid(int id) {
        return dao.getAllPatients().stream().anyMatch(patientDto -> patientDto.getID() == id);
    }

    private static PatientStorageImpl INSTANCE = null;
    public static PatientStorageImpl getInstance(){
        if (INSTANCE == null) INSTANCE = new PatientStorageImpl(HospitalDatabase.getInstance());
        return INSTANCE;
    }

}
