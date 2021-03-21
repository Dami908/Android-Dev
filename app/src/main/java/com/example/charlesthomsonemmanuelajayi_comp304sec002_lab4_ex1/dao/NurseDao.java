package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Nurse;

import java.util.List;

/*
    Charles Thomson 301062645
    Emmanuel Ajayi 301050676
    COMP304 March 20, 2021
 */
@Dao
public interface NurseDao {

    @Insert
    void insert(Nurse nurse);
    @Query("select * from Nurse order by lastName")
    LiveData<List<Nurse>> getAllNurses();
}
