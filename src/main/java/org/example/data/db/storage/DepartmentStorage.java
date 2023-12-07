package org.example.data.db.storage;

import org.example.data.db.dto.DepartmentDto;

import java.util.List;

public interface DepartmentStorage {

    void addDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(int id);
    void editDepartment(DepartmentDto departmentDto);
    void deleteDepartment(int id);
    void deleteDepartment(DepartmentDto departmentDto);
    void deleteAllDepartments();
    List<DepartmentDto> getAllDepartments();
    boolean isDepartmentIdValid(int id);
}
