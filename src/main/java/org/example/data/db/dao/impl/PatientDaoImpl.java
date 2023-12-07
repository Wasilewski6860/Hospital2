package org.example.data.db.dao.impl;

import org.example.data.db.HospitalDatabase;
import org.example.data.db.dao.PatientDao;
import org.example.data.db.dto.DepartmentDto;
import org.example.data.db.dto.PatientDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoImpl implements PatientDao {


    private PatientDaoImpl() {
        database = HospitalDatabase.getInstance();
    }

    private static PatientDaoImpl INSTANCE;
    private HospitalDatabase database;


    @Override
    public void addPatient(PatientDto patientDto) {
        try{
            String name = "\'"+patientDto.getName()+"\'";
            String gender = "\'"+patientDto.getGender()+"\'";
            String id = ""+patientDto.getDepartmentId()+"";
            database.executeUpdate("INSERT INTO patient (name, gender, department_id) VALUES ( "+name+","+gender+","+id+" )");
            DepartmentDto departmentDto = DepartmentDaoImpl.getInstance().getDepartmentById(patientDto.getDepartmentId());
            departmentDto.setPatient_count(departmentDto.getPatient_count()+1);
            DepartmentDaoImpl.getInstance().editDepartment(departmentDto);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public PatientDto getPatientById(int id) {
        try{
            ResultSet result = database.executeSelect("SELECT * FROM patient WHERE card_number="+id+";");
            result.next();
            PatientDto patientDto = getPatientByResultSet(result);
            result.close();
            return patientDto;
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            return null;
        }
    }

    @Override
    public void editPatient(PatientDto patientDto) {
        String name = "\'"+patientDto.getName()+"\'";
        String gender = "\'"+patientDto.getGender()+"\'";
        String id = patientDto.getID().toString();
        String query = "UPDATE patient SET name = "+name+", gender=  "+gender+", department_id= "+patientDto.getDepartmentId()+" WHERE card_number = "+id+";";
        System.out.println(query);
        database.executeUpdate(query);
    }

    @Override
    public void deletePatient(int id) {
        PatientDto patientDto = getPatientById(id);
        database.executeUpdate("DELETE FROM patient WHERE card_number= "+id);
        DepartmentDto departmentDto = DepartmentDaoImpl.getInstance().getDepartmentById(patientDto.getDepartmentId());
        departmentDto.setPatient_count(departmentDto.getPatient_count()-1);
        DepartmentDaoImpl.getInstance().editDepartment(departmentDto);
    }

    @Override
    public void deletePatient(PatientDto patientDto) {
        database.executeUpdate("DELETE FROM patient WHERE card_number= "+patientDto.getCardNumber());
        DepartmentDto departmentDto = DepartmentDaoImpl.getInstance().getDepartmentById(patientDto.getDepartmentId());
        departmentDto.setPatient_count(departmentDto.getPatient_count()-1);
        DepartmentDaoImpl.getInstance().editDepartment(departmentDto);
    }



    @Override
    public List<PatientDto> getAllPatients() {
        List<PatientDto> patientDtos = new ArrayList<>();
        try{
            ResultSet resultSet = database.executeSelect("SELECT * FROM patient");
            while (resultSet.next()){
                patientDtos.add(getPatientByResultSet(resultSet));
            }
            resultSet.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return patientDtos;
    }

    @Override
    public List<PatientDto> getAllPatientsInDepartment(int id) {
        List<PatientDto> patientDtos = new ArrayList<>();
        try{
            ResultSet resultSet = database.executeSelect("SELECT * FROM patient WHERE patient.department_id="+id+";");
            while (resultSet.next()){
                patientDtos.add(getPatientByResultSet(resultSet));
            }
            resultSet.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return patientDtos;
    }

    @Override
    public void deleteAllPatientsInDepartment(int id) {
//        database.executeUpdate("DELETE FROM patient\n" +
//                "WHERE department_id IN (SELECT department_number FROM department);")
        List<PatientDto> patientDtos = getAllPatientsInDepartment(id);
        for (PatientDto patientDto : patientDtos)
            deletePatient(patientDto);
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

    public PatientDto getPatientByResultSet(ResultSet result){
        try {
            return new PatientDto(
                    result.getInt("department_id"),
                    result.getInt("card_number"),
                    result.getString("name"),
                    result.getString("gender")
            );
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static PatientDao getInstance() {
        if (INSTANCE == null) INSTANCE = new PatientDaoImpl();
        return INSTANCE;
    }
}
