package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.dao.NurseDao;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.dao.PatientDao;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.dao.TestDao;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Nurse;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Patient;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Test;

@Database(entities = {Patient.class, Test.class, Nurse.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;
    private static final String DATABASE_NAME = "HospitalDB";
    public abstract PatientDao patientDao();
    public abstract TestDao testDao();
    public abstract NurseDao nurseDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).build();
        }
        return INSTANCE;
    }
}
