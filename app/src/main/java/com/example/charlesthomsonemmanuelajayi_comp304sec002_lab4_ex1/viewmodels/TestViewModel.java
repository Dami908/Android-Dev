package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Test;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.repositories.TestRepository;

import java.util.List;

/*
    Charles Thomson 301062645
    Emmanuel Ajayi 301050676
    COMP304 March 20, 2021
 */
public class TestViewModel extends AndroidViewModel {

    private TestRepository testRepository;
    private LiveData<Integer> insertResult;
    private LiveData<List<Test>> allTests;

    public TestViewModel(@NonNull Application application) {
        super(application);
        testRepository = new TestRepository(application);
        insertResult = testRepository.getInsertResult();
        allTests = testRepository.getAllTests();
    }

    // Calls repository to insert a test
    public void insert(Test test) {
        testRepository.insert(test);
    }

    // Gets insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    // Return query results as LiveData object
    LiveData<List<Test>> getAllTests() {
        return allTests;
    }

    public LiveData<List<Test>> getTestsByPatientId(int patientId) {
        return testRepository.getTestsByPatientId(patientId);
    }
}
