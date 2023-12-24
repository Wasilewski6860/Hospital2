package org.example.domain.use_cases;


import org.example.data.repository.DepartmentRepositoryImpl;
import org.example.domain.models.Department;
import org.example.domain.repositories.DepartmentRepository;

public class EditDepartmentUseCase {

    public DepartmentRepository repository;
    private static EditDepartmentUseCase INSTANCE = null;
    public static EditDepartmentUseCase getInstance(){
        if (INSTANCE == null) INSTANCE = new EditDepartmentUseCase(DepartmentRepositoryImpl.getInstance());
        return INSTANCE;
    }
    public EditDepartmentUseCase(DepartmentRepository repository){
        this.repository = repository;
    }

    public void execute(Integer departmentNumberOld, String name){
        repository.editDepartment(new Department(name,departmentNumberOld));
    }

}
