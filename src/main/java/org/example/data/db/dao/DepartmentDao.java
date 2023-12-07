package org.example.data.db.dao;

import org.example.data.db.dto.DepartmentDto;
import org.example.data.db.dto.PatientDto;

import java.util.List;

public interface DepartmentDao {


    public void addDepartment(DepartmentDto departmentDto);
    public DepartmentDto getDepartmentById(int id);
    public void editDepartment(DepartmentDto departmentDto);
    public void deleteDepartment(int id);
    public void deleteDepartment(DepartmentDto departmentDto);

    public List<DepartmentDto> getAllDepartments();
    public void deleteAllDepartments();

}

