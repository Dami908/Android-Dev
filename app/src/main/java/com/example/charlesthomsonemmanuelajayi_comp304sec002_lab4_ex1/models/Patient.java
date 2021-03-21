package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
    Charles Thomson 301062645
    Emmanuel Ajayi 301050676
    COMP304 March 20, 2021
 */
@Entity
public class Patient {

    @PrimaryKey(autoGenerate = true)
    private int patientId;
    private String firstName;
    private String lastName;
    private String department;
    private int nurseId;
    private String room;

    // Setters
    public void setPatientId(int patientId) {
        this.patientId = patientId;
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
    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }
    public void setRoom(String room) {
        this.room = room;
    }

    // Getters
    public int getPatientId() {
        return patientId;
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
    public int getNurseId() {
        return nurseId;
    }
    public String getRoom() {
        return room;
    }
}
