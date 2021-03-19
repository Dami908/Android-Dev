package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Nurse;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.repositories.NurseRepository;

import java.util.List;

public class NurseViewModel extends AndroidViewModel {

    private NurseRepository nurseRepository;
    private LiveData<Integer> insertResult;
    private LiveData<List<Nurse>> allNurses;

    public NurseViewModel(@NonNull Application application) {
        super(application);
        nurseRepository = new NurseRepository(application);
        insertResult = nurseRepository.getInsertResult();
        allNurses = nurseRepository.getAllNurses();
    }

    // Calls repository to insert a nurse
    public void insert(Nurse nurse) {
        nurseRepository.insert(nurse);
    }

    // Gets insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    // Return query results as LiveData object
    public LiveData<List<Nurse>> getAllNurses() {
        return allNurses;
    }
}
