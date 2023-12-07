package org.example.domain.models;

public  class Department{

    private Integer departmentNumber;
    private String name;
    private int patient_count;

    public Department(String name) {
        departmentNumber = 0;
        this.name = name;
    }
    public Department(String name, Integer departmentNumber) {
        this.departmentNumber = departmentNumber;
        this.name = name;
    }

    public Department(Integer departmentNumber, String name, int patient_count) {
        this.departmentNumber = departmentNumber;
        this.name = name;
        this.patient_count = patient_count;
    }

    public Integer getDepartmentNumber() {
        return departmentNumber;
    }

    public String getName() {
        return name;
    }

    public void setID(int id) {
        departmentNumber = id;
    }
    public int getID(){
        return departmentNumber;
    }

    public void setDepartmentNumber(Integer departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public int getPatient_count() {
        return patient_count;
    }

    public void setPatient_count(int patient_count) {
        this.patient_count = patient_count;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name+" department № "+departmentNumber.toString()+" , patients count: "+patient_count;
    }
}