package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Patient;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.viewmodels.NurseViewModel;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.viewmodels.PatientViewModel;

import java.util.concurrent.ThreadLocalRandom;

/*
    Activity to add and view patients
 */
public class PatientActivity extends AppCompatActivity {

    EditText etFirstName, etLastName, etDepartment, etRoom;
    Button btnRegister;
    TextView txtMessage;

    private PatientViewModel patientViewModel;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        etFirstName = (EditText)findViewById(R.id.editTextFirstName);
        etLastName = (EditText)findViewById(R.id.editTextLastName);
        etDepartment = (EditText)findViewById(R.id.editTextDepartment);
        etRoom = (EditText)findViewById(R.id.editTextRoom);
        txtMessage = (TextView)findViewById(R.id.txtMessage);
        txtMessage.setVisibility(View.INVISIBLE);

        mSharedPreferences = this.getSharedPreferences(this.getPackageName(), this.MODE_PRIVATE);
        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);

        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = (int) (Math.random() * (999 - 000));// TODO: Is there a better way?
                String firstName = etFirstName.getText().toString();
                String lastName = etLastName.getText().toString();
                String department = etDepartment.getText().toString();
                String room = etRoom.getText().toString();
                // Get nurseId from SharedPreferences
                int nurseId = mSharedPreferences.getInt("nurseId", 0);
                Patient newPatient = new Patient();
                try {
                    newPatient.setPatientId(id);
                    newPatient.setFirstName(firstName);
                    newPatient.setLastName(lastName);
                    newPatient.setDepartment(department);
                    newPatient.setRoom(room);
                    newPatient.setNurseId(nurseId);
                    patientViewModel.insert(newPatient);
                    txtMessage.setText("Patient registered!");
                    txtMessage.setTextColor(getResources().getColor(R.color.black));
                    txtMessage.setVisibility(View.VISIBLE);
                    // Empty EditText fields
                    etFirstName.setText("");
                    etLastName.setText("");
                    etDepartment.setText("");
                    etRoom.setText("");
                } catch (Exception e) {
                    Log.d("CT", "There was a problem with creating/registering the new patient");
                    txtMessage.setText("Something went wrong with the registration");
                    txtMessage.setTextColor(getResources().getColor(R.color.red));
                    txtMessage.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}