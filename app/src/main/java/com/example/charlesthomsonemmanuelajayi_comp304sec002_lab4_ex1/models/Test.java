package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
    Charles Thomson 301062645
    Emmanuel Ajayi 301050676
    COMP304 March 20, 2021
 */
@Entity
public class Test {

    @PrimaryKey(autoGenerate = true)
    private int testId;
    private int patientId;
    private int nurseId;
    private double bpl; // blood pressure low value
    private double bph; // blood pressure high value
    private double temperature;
    private double glucoseTolerance;
    private double thymolTurbidity;
    private double boneMarrowAspiration;

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
    public void setGlucoseTolerance(double glucoseTolerance) {
        this.glucoseTolerance = glucoseTolerance;
    }
    public void setThymolTurbidity(double thymolTurbidity) {
        this.thymolTurbidity = thymolTurbidity;
    }
    public void setBoneMarrowAspiration(double boneMarrowAspiration) {
        this.boneMarrowAspiration = boneMarrowAspiration;
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
    public double getGlucoseTolerance() {
        return glucoseTolerance;
    }
    public double getThymolTurbidity() {
        return thymolTurbidity;
    }
    public double getBoneMarrowAspiration() {
        return boneMarrowAspiration;
    }
}
