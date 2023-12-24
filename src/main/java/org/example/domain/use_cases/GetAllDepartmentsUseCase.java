package org.example.domain.use_cases;


import org.example.data.repository.DepartmentRepositoryImpl;
import org.example.domain.models.Department;
import org.example.domain.repositories.DepartmentRepository;

import java.util.List;

public class GetAllDepartmentsUseCase {
    public DepartmentRepository repository;
    private static GetAllDepartmentsUseCase INSTANCE = null;
    public static GetAllDepartmentsUseCase getInstance(){
        if (INSTANCE == null) INSTANCE = new GetAllDepartmentsUseCase(DepartmentRepositoryImpl.getInstance());
        return INSTANCE;
    }
    public GetAllDepartmentsUseCase(DepartmentRepository repository){
        this.repository = repository;
    }

    public List<Department> execute(){
        return repository.getAllDepartments();
    }
}
