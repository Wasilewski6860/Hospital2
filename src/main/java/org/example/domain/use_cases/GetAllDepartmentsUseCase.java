package org.example.domain.use_cases;


import org.example.domain.models.Department;
import org.example.domain.repositories.DepartmentRepository;

import java.util.List;

public class GetAllDepartmentsUseCase {
    public DepartmentRepository repository;

    public GetAllDepartmentsUseCase(DepartmentRepository repository){
        this.repository = repository;
    }

    public List<Department> execute(){
        return repository.getAllDepartments();
    }
}
