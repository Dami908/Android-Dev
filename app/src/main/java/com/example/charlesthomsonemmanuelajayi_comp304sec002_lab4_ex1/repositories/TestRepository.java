package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.AppDatabase;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.dao.TestDao;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Test;

import java.util.List;

public class TestRepository {

    private final TestDao testDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private LiveData<List<Test>> testsList;

    public TestRepository(Context context) {
        // Create database object
        AppDatabase db = AppDatabase.getInstance(context);
        // Create interface object
        testDao = db.testDao();
        // Call interface method
        testsList = testDao.getAllTests();
    }

    // Returns query results as LiveData object
    public LiveData<List<Test>> getAllTests() { return testsList; }
    public LiveData<List<Test>> getTestsByPatientId(int patientId) {
        return testDao.getTestsByPatientId(patientId);
    }
    // Inserts a test asynchronously
    public void insert(Test test) { insertAsync(test); }
    // Returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() { return insertResult; }

    private void insertAsync(final Test test) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    testDao.insert(test);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }
}
