package org.example.app;


import org.example.presentation.CLI;

public class Main {
    public static void main(String[] args) {
//        HospitalRealDatabase database = HospitalRealDatabase.getInstance();
//        System.out.println(database.getDao().getAllDepartments());
        new CLI().start();
    }
}