package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Nurse {

    @PrimaryKey(autoGenerate = true)
    private int nurseId;
    private String firstName;
    private String lastName;
    private String department;
    private String password;

    // Setters
    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Getters
    public int getNurseId() {
        return nurseId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDepartment() {
        return department;
    }
    public String getPassword() {
        return password;
    }
}
