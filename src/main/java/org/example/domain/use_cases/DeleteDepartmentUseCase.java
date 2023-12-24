package org.example.domain.use_cases;


import org.example.data.repository.DepartmentRepositoryImpl;
import org.example.domain.repositories.DepartmentRepository;

public class DeleteDepartmentUseCase {
    public DepartmentRepository repository;
    private static DeleteDepartmentUseCase INSTANCE = null;
    public static DeleteDepartmentUseCase getInstance(){
        if (INSTANCE == null) INSTANCE = new DeleteDepartmentUseCase(DepartmentRepositoryImpl.getInstance());
        return INSTANCE;
    }
    public DeleteDepartmentUseCase(DepartmentRepository repository){
        this.repository = repository;
    }

    public void execute(Integer departmentNumber){
        repository.deleteDepartment(departmentNumber);
    }

}
