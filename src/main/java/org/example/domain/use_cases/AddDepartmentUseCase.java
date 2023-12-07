package org.example.domain.use_cases;

import org.example.domain.models.Department;
import org.example.domain.repositories.DepartmentRepository;

public class AddDepartmentUseCase {

    public DepartmentRepository repository;

    public AddDepartmentUseCase(DepartmentRepository repository){
        this.repository = repository;
    }

    public void execute(String name, Integer departmentNumber){
        repository.addDepartment(new Department(name, departmentNumber));
    }
    public void execute(String name){
        repository.addDepartment(new Department(name));
    }

}
