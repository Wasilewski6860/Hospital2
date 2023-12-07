package org.example.domain.use_cases;


import org.example.domain.repositories.DepartmentRepository;

public class DeleteAllDepartmentsUseCase {
    public DepartmentRepository repository;

    public DeleteAllDepartmentsUseCase(DepartmentRepository repository){
        this.repository = repository;
    }

    public void execute(){
        repository.deleteAllDepartment();
    }
}
