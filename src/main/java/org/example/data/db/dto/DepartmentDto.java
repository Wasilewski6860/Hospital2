package org.example.data.db.dto;


public  class DepartmentDto{

    private Integer departmentNumber;
    private String name;
    private int patient_count;

    public DepartmentDto(String name) {
        departmentNumber = 0;
        this.name = name;
    }
    public DepartmentDto(String name, Integer departmentNumber) {
        this.departmentNumber = departmentNumber;
        this.name = name;
    }

    public DepartmentDto(Integer departmentNumber, String name, int patient_count) {
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

    public int getPatient_count() {
        return patient_count;
    }

    public void setPatient_count(int patient_count) {
        this.patient_count = patient_count;
    }

    public void setDepartmentNumber(Integer departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
}
