package org.example.domain.use_cases;

import org.example.domain.repositories.DepartmentRepository;

public class ValidateDepartmentUseCase {
    public DepartmentRepository repository;

    public ValidateDepartmentUseCase(DepartmentRepository repository){
        this.repository = repository;
    }

    public boolean execute(int id){
       return repository.isDepartmentIdValid(id);
    }

}
