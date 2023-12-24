package org.example.domain.use_cases;


import org.example.data.repository.DepartmentRepositoryImpl;
import org.example.domain.models.Department;
import org.example.domain.repositories.DepartmentRepository;

public class GetDepartmentUseCase {
    public DepartmentRepository repository;
    private static GetDepartmentUseCase INSTANCE = null;
    public static GetDepartmentUseCase getInstance(){
        if (INSTANCE == null) INSTANCE = new GetDepartmentUseCase(DepartmentRepositoryImpl.getInstance());
        return INSTANCE;
    }
    public GetDepartmentUseCase(DepartmentRepository repository){
        this.repository = repository;
    }

    public Department execute(Integer departmentNumber){
       return repository.getDepartmentById(departmentNumber);
    }
}
