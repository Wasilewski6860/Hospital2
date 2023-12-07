package org.example.data.db.dao.impl;

import org.example.data.db.HospitalDatabase;
import org.example.data.db.dao.DepartmentDao;
import org.example.data.db.dto.DepartmentDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {


    private DepartmentDaoImpl() {
        database = HospitalDatabase.getInstance();
    }

    private static DepartmentDaoImpl INSTANCE;
    private HospitalDatabase database;

    @Override
    public void addDepartment(DepartmentDto departmentDto) {
        database.executeUpdate("INSERT INTO department (name) VALUES (\' "+departmentDto.getName()+"\');");
    }

    @Override
    public DepartmentDto getDepartmentById(int id) {
        try{
            ResultSet result = database.executeSelect("SELECT * FROM department WHERE department_number="+id+";");
            result.next();
            DepartmentDto departmentDto = getDepartmentByResultSet(result);
            result.close();
            return departmentDto;
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            return null;
        }
    }

    @Override
    public void editDepartment(DepartmentDto departmentDto) {
        database.executeUpdate("UPDATE department SET name = \'"+departmentDto.getName()+" \', patient_count=  "+departmentDto.getPatient_count()+" WHERE department_number = "+departmentDto.getDepartmentNumber()+";");
    }

    @Override
    public void deleteDepartment(int id) {
        PatientDaoImpl.getInstance().deleteAllPatientsInDepartment(id);
        database.executeUpdate("DELETE FROM department WHERE department_number= "+id);
    }

    @Override
    public void deleteDepartment(DepartmentDto departmentDto) {
        PatientDaoImpl.getInstance().deleteAllPatientsInDepartment(departmentDto.getID());
        database.executeUpdate("DELETE FROM department WHERE department_number= "+departmentDto.getDepartmentNumber());
    }



    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        try{
            ResultSet resultSet = database.executeSelect("SELECT * FROM department;");
            while (resultSet.next()){
                departmentDtos.add(getDepartmentByResultSet(resultSet));
            }
            resultSet.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return departmentDtos;
    }

    @Override
    public void deleteAllDepartments() {
        database.executeUpdate("DELETE FROM patient");
        database.executeUpdate("DELETE FROM department");
    }

    public DepartmentDto getDepartmentByResultSet(ResultSet result){
        try {
            return new DepartmentDto(
                    result.getInt("department_number"),
                    result.getString("name"),
                    result.getInt("patient_count")
            );
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static DepartmentDao getInstance() {
        if (INSTANCE == null) INSTANCE = new DepartmentDaoImpl();
        return INSTANCE;
    }
}
