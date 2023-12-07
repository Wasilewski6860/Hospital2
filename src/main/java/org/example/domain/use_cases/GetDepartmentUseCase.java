package org.example.domain.use_cases;


import org.example.domain.models.Department;
import org.example.domain.repositories.DepartmentRepository;

public class GetDepartmentUseCase {
    public DepartmentRepository repository;

    public GetDepartmentUseCase(DepartmentRepository repository){
        this.repository = repository;
    }

    public Department execute(Integer departmentNumber){
       return repository.getDepartmentById(departmentNumber);
    }
}
