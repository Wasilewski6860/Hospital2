package org.example.data.db.dao;

import org.example.data.db.dto.DepartmentDto;
import org.example.data.db.dto.PatientDto;

import java.util.List;

public interface HospitalDao {


    public void addDepartment(DepartmentDto departmentDto);
    public DepartmentDto getDepartmentById(int id);
    public void editDepartment(DepartmentDto departmentDto);
    public void deleteDepartment(int id);
    public void deleteDepartment(DepartmentDto departmentDto);

    public void addPatient(PatientDto patientDto);
    public PatientDto getPatientById(int id);
    public void editPatient(PatientDto patientDto);
    public void deletePatient(int id);
    public void deletePatient(PatientDto patientDto);

    public List<DepartmentDto> getAllDepartments();
    public void deleteAllDepartments();
    public List<PatientDto> getAllPatients();
    public List<PatientDto> getAllPatientsInDepartment(int id);
    public void deleteAllPatientsInDepartment(int id);


}
