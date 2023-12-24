package org.example.data.db;

import org.example.data.db.dao.*;
import org.example.data.db.dao.impl.DepartmentDaoImpl;
import org.example.data.db.dao.impl.PatientDaoImpl;

import java.sql.*;

public class HospitalDatabase {

    private final static String DB_URL = "jdbc:postgresql://localhost:5432/hospital";
    private final static String DB_USER = "postgres";
    private final static String DB_PASS = "2143658709";


    public PatientDao getPatientDao(){
        return PatientDaoImpl.getInstance();
    }
    public DepartmentDao getDepartmentDao(){
        return DepartmentDaoImpl.getInstance();
    }

    private static HospitalDatabase INSTANCE = null;


    public static HospitalDatabase getInstance(){
        if (INSTANCE == null) INSTANCE = new HospitalDatabase();
        return INSTANCE;
    }

    private Connection getConnection()
            throws SQLException
    {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            System.err.println("боль");
            throw new RuntimeException();
        }
//        try {
//            return  DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }
//        return null;
        return  DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

//    public ResultSet executeSelect(String query) {
//        ResultSet resultSet = null;
//        try (Connection connection = getConnection();
//             Statement statement = connection.createStatement()) {
//            resultSet = statement.executeQuery(query);
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }
//        return resultSet;
//    }

    public ResultSet executeSelect(String query) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        int rows = 0;
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            rows = statement.executeUpdate(query);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return rows;
    }



}

