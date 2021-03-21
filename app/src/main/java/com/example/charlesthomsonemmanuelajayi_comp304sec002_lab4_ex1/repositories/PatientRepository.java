package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.AppDatabase;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.dao.PatientDao;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Patient;

import java.util.List;

/*
    Charles Thomson 301062645
    Emmanuel Ajayi 301050676
    COMP304 March 20, 2021
 */
public class PatientRepository {

    private final PatientDao patientDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private MutableLiveData<Integer> updateResult = new MutableLiveData<>();
    private LiveData<List<Patient>> patientsList;

    public PatientRepository(Context context) {
        // Create database object
        AppDatabase db = AppDatabase.getInstance(context);
        // Create interface object
        patientDao = db.patientDao();
        // Call interface method
        patientsList = patientDao.getAllPatients();
    }

    // Returns query results as LiveData object
    public LiveData<List<Patient>> getAllPatients() { return patientsList; }
    // Inserts a patient asynchronously
    public void insert(Patient patient) { insertAsync(patient); }
    // Returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() { return insertResult; }
    // Updates a patient asynchronously
    public void update(Patient patient) { updateAsync(patient); }
    // Returns update results as LiveData object
    public LiveData<Integer> getUpdateResult() { return updateResult; }

    private void insertAsync(final Patient patient) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    patientDao.insert(patient);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void updateAsync(final Patient patient) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    updateResult.postValue(patientDao.update(patient));
                } catch (Exception e) {
                    updateResult.postValue(0);
                }
            }
        }).start();
    }
}
