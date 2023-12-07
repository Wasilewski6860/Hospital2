package org.example.domain.repositories;

import org.example.domain.models.Department;

import java.util.List;

public interface DepartmentRepository {
    void addDepartment(Department department);
    Department getDepartmentById(int id);
    void editDepartment(Department department);
    void deleteDepartment(int id);
    void deleteAllDepartment();
    void deleteDepartment(Department department);
    List<Department> getAllDepartments();
    boolean isDepartmentIdValid(int id);

}
