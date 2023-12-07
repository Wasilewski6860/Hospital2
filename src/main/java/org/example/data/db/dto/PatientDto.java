package org.example.data.db.dto;

import java.util.Objects;

public class PatientDto {

    private Integer cardNumber = 0;
    private Integer departmentId;
    private String name;
    private String gender;

    public PatientDto(Integer departmentId,String name, String gender){
        this.departmentId = departmentId;
        this.name = name;
        this.gender = gender;
    }

    public PatientDto(Integer departmentId,Integer cardNumber, String name, String gender) {
        this.departmentId = departmentId;
        this.cardNumber = cardNumber;
        this.name = name;
        this.gender = gender;
    }

    public Integer getID() {
        return cardNumber;
    }

    public void setID(int id) {
        cardNumber = id;
    }
    public int getDepartmentId(){
        return departmentId;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }

}

