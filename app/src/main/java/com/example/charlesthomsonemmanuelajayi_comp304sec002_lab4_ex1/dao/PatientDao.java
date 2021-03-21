package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Patient;

import java.util.List;
/*
    Charles Thomson 301062645
    Emmanuel Ajayi 301050676
    COMP304 March 20, 2021
 */
@Dao
public interface PatientDao {

    @Insert
    void insert(Patient patient);
    @Query("select * from Patient order by lastName")
    LiveData<List<Patient>> getAllPatients();
    @Update
    int update(Patient patient);
}
