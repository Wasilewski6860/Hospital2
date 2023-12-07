package org.example.data.db.impl;

import org.example.data.db.HospitalDatabase;
import org.example.data.db.dao.DepartmentDao;
import org.example.data.db.dao.HospitalDao;
import org.example.data.db.dto.DepartmentDto;
import org.example.data.db.storage.DepartmentStorage;

import java.util.List;

public class DepartmentStorageImpl implements DepartmentStorage {

    private DepartmentDao dao;

    public DepartmentStorageImpl(HospitalDatabase hospitalDatabase) {
        dao = hospitalDatabase.getDepartmentDao();
    }

    @Override
    public void addDepartment(DepartmentDto departmentDto) {
        dao.addDepartment(departmentDto);
    }

    @Override
    public DepartmentDto getDepartmentById(int id) {
        return dao.getDepartmentById(id);
    }

    @Override
    public void editDepartment(DepartmentDto departmentDto) {
        dao.editDepartment(departmentDto);
    }

    @Override
    public void deleteDepartment(int id) {
        dao.deleteDepartment(id);
    }

    @Override
    public void deleteDepartment(DepartmentDto departmentDto) {
        dao.deleteDepartment(departmentDto);
    }

    @Override
    public void deleteAllDepartments() {
        dao.deleteAllDepartments();
    }


    @Override
    public List<DepartmentDto> getAllDepartments() {
        return dao.getAllDepartments();
    }

    @Override
    public boolean isDepartmentIdValid(int id) {
        return dao.getAllDepartments().stream().anyMatch(department -> department.getID() == id);
    }


    private static DepartmentStorageImpl INSTANCE = null;
    public static DepartmentStorageImpl getInstance(){
        if (INSTANCE == null) INSTANCE = new DepartmentStorageImpl(HospitalDatabase.getInstance());
        return INSTANCE;
    }

}
