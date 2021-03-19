package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Nurse;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.viewmodels.NurseViewModel;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText etNurseName, etPassword;
    private TextView txtError;
    private Button btnLogin;

    private NurseViewModel nurseViewModel;

    private List<Nurse> mNurses = new ArrayList<>();
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etNurseName = (EditText)findViewById(R.id.editTextNurseName);
        etPassword = (EditText)findViewById(R.id.editTextPassword);
        txtError = (TextView)findViewById(R.id.txtError);
        txtError.setVisibility(View.INVISIBLE);

        nurseViewModel = ViewModelProviders.of(this).get(NurseViewModel.class);

        // Insert initial data into database
        Nurse nurse1 = new Nurse();
        nurse1.setNurseId(100);
        nurse1.setFirstName("Meryl");
        nurse1.setLastName("Streep");
        nurse1.setDepartment("Parametics");
        nurse1.setPassword("password");
        Nurse nurse2 = new Nurse();
        nurse2.setNurseId(101);
        nurse2.setFirstName("Beyonce");
        nurse2.setLastName("Knowles");
        nurse2.setDepartment("Parametics");
        nurse2.setPassword("password");
        nurseViewModel.insert(nurse1);
        nurseViewModel.insert(nurse2);

        // Get data from the database and observe any changes
        nurseViewModel.getAllNurses().observe(this, new Observer<List<Nurse>>() {
            @Override
            public void onChanged(@Nullable List<Nurse> nurses) {
                if (nurses != null) {
                    mNurses.clear();
                    mNurses = nurses;
                }
            }
        });

        mSharedPreferences = this.getSharedPreferences(this.getPackageName(), this.MODE_PRIVATE);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int inputId = Integer.parseInt(etNurseName.getText().toString());
                String inputPassword = etPassword.getText().toString();

                // Check for matching id and password in database
                if (mNurses != null) {
                    for (int i = 0; i < mNurses.size(); i++) {
                        if (mNurses.get(i).getNurseId() == inputId
                                && mNurses.get(i).getPassword().equals(inputPassword)) {
                            Log.d("CT", "Nurse found!");
                            // Put nurseId into Shared Preferences
                            SharedPreferences.Editor editor = mSharedPreferences.edit();
                            editor.putInt("nurseId", mNurses.get(i).getNurseId());
                            editor.apply();
                            // Go to MainActivity
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            txtError.setVisibility(View.INVISIBLE);// for if we come back to this Activity
                            return;
                        }
                    }
                }
                // If there was no match or there was an error
                txtError.setVisibility(View.VISIBLE);
            }
        });
    }
}