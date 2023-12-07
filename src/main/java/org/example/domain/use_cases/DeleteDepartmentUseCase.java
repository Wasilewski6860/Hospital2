package org.example.domain.use_cases;


import org.example.domain.repositories.DepartmentRepository;

public class DeleteDepartmentUseCase {
    public DepartmentRepository repository;

    public DeleteDepartmentUseCase(DepartmentRepository repository){
        this.repository = repository;
    }

    public void execute(Integer departmentNumber){
        repository.deleteDepartment(departmentNumber);
    }

}
