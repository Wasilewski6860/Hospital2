package org.example.domain.use_cases;


import org.example.domain.models.Department;
import org.example.domain.repositories.DepartmentRepository;

public class EditDepartmentUseCase {

    public DepartmentRepository repository;

    public EditDepartmentUseCase(DepartmentRepository repository){
        this.repository = repository;
    }

    public void execute(Integer departmentNumberOld, String name){
        repository.editDepartment(new Department(name,departmentNumberOld));
    }

}
