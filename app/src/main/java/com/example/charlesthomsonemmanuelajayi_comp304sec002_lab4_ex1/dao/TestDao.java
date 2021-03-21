package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Test;

import java.util.List;

/*
    Charles Thomson 301062645
    Emmanuel Ajayi 301050676
    COMP304 March 20, 2021
 */
@Dao
public interface TestDao {

    @Insert
    void insert(Test test);
    @Query("select * from Test order by testId")
    LiveData<List<Test>> getAllTests();
    @Query("select * from Test where patientId = :patientId")
    LiveData<List<Test>> getTestsByPatientId(int patientId);
}
