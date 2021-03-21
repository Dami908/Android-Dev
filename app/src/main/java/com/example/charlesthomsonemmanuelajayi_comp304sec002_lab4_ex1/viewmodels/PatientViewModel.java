package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Patient;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.repositories.PatientRepository;

import java.util.List;

/*
    Charles Thomson 301062645
    Emmanuel Ajayi 301050676
    COMP304 March 20, 2021
 */
public class PatientViewModel extends AndroidViewModel {

    private PatientRepository patientRepository;
    private LiveData<Integer> insertResult;
    private LiveData<Integer> updateResult;
    private LiveData<List<Patient>> allPatients;

    public PatientViewModel(@NonNull Application application) {
        super(application);
        patientRepository = new PatientRepository(application);
        insertResult = patientRepository.getInsertResult();
        allPatients = patientRepository.getAllPatients();
    }

    // Calls repository to insert a patient
    public void insert(Patient patient) {
        patientRepository.insert(patient);
    }

    // Gets insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    // Calls repository to update a patient
    public void update(Patient patient) { patientRepository.update(patient); }

    // Gets update results as LiveData obejct
    public LiveData<Integer> getUpdateResult() { return updateResult; }

    // Return query results as LiveData object
    public LiveData<List<Patient>> getAllPatients() {
        return allPatients;
    }
}
