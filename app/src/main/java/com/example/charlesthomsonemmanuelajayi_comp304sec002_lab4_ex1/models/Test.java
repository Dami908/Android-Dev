package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Test {

    @PrimaryKey(autoGenerate = true)
    private int testId;
    private int patientId;
    private int nurseId;
    private double bpl; // blood pressure low value
    private double bph; // blood pressure high value
    private double temperature;

    // Setters
    public void setTestId(int testId) {
        this.testId = testId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }
    public void setBpl(double bpl) {
        this.bpl = bpl;
    }
    public void setBph(double bph) {
        this.bph = bph;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    // Getters
    public int getTestId() {
        return testId;
    }
    public int getPatientId() {
        return patientId;
    }
    public int getNurseId() {
        return nurseId;
    }
    public double getBpl() {
        return bpl;
    }
    public double getBph() {
        return bph;
    }
    public double getTemperature() {
        return temperature;
    }
}
