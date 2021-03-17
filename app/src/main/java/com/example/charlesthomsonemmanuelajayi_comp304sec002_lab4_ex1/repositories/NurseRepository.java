package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.AppDatabase;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.dao.NurseDao;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Nurse;

import java.util.List;

public class NurseRepository {

    private final NurseDao nurseDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private LiveData<List<Nurse>> nursesList;

    public NurseRepository(Context context) {
        // Create database object
        AppDatabase db = AppDatabase.getInstance(context);
        // Create interface object
        nurseDao = db.nurseDao();
        // Call interface method
        nursesList = nurseDao.getAllNurses();
    }

    // Returns query results as LiveData object
    public LiveData<List<Nurse>> getAllNurses() { return nursesList; }
    // Inserts a nurse asynchronously
    public void insert(Nurse nurse) { insertAsync(nurse); }
    // Returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() { return insertResult; }

    private void insertAsync(final Nurse nurse) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    nurseDao.insert(nurse);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }
}
