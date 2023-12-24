package org.example.domain.use_cases;


import org.example.data.repository.DepartmentRepositoryImpl;
import org.example.domain.repositories.DepartmentRepository;

public class DeleteAllDepartmentsUseCase {
    public DepartmentRepository repository;
    private static DeleteAllDepartmentsUseCase INSTANCE = null;
    public static DeleteAllDepartmentsUseCase getInstance(){
        if (INSTANCE == null) INSTANCE = new DeleteAllDepartmentsUseCase(DepartmentRepositoryImpl.getInstance());
        return INSTANCE;
    }
    public DeleteAllDepartmentsUseCase(DepartmentRepository repository){
        this.repository = repository;
    }

    public void execute(){
        repository.deleteAllDepartment();
    }
}
