package org.example.data.repository;

import org.example.data.db.dto.DepartmentDto;
import org.example.data.db.impl.DepartmentStorageImpl;
import org.example.data.db.storage.DepartmentStorage;
import org.example.domain.models.Department;
import org.example.domain.repositories.DepartmentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentRepositoryImpl implements DepartmentRepository {
    private DepartmentStorage storage;


    public DepartmentRepositoryImpl(DepartmentStorage storage) {
        this.storage = storage;
    }

    @Override
    public void addDepartment(Department department) {
        storage.addDepartment(mapToData(department));
    }

    @Override
    public Department getDepartmentById(int id) {
        return mapToDomain(storage.getDepartmentById(id));
    }

    @Override
    public void editDepartment(Department department) {
        storage.editDepartment(mapToData(department));
    }

    @Override
    public void deleteDepartment(int id) {
        storage.deleteDepartment(id);
    }

    @Override
    public void deleteAllDepartment() {
        storage.deleteAllDepartments();
    }

    @Override
    public void deleteDepartment(Department department) {
        storage.deleteDepartment(mapToData(department));
    }



    @Override
    public List<Department> getAllDepartments() {
        return storage.getAllDepartments().stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isDepartmentIdValid(int id) {
        return storage.isDepartmentIdValid(id);
    }

    public Department mapToDomain(DepartmentDto departmentDto){
        return new Department(departmentDto.getID(), departmentDto.getName(), departmentDto.getPatient_count());
    }
    public DepartmentDto mapToData(Department department){
        return new DepartmentDto(department.getID() ,department.getName(),department.getPatient_count() );
    }

    private static DepartmentRepositoryImpl INSTANCE = null;
    public static DepartmentRepositoryImpl getInstance(){
        if (INSTANCE == null) INSTANCE = new DepartmentRepositoryImpl(DepartmentStorageImpl.getInstance());
        return INSTANCE;
    }
}
