package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Nurse;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Patient;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.viewmodels.NurseViewModel;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.viewmodels.PatientViewModel;

import java.util.ArrayList;
import java.util.List;

/*
    Charles Thomson 301062645
    Emmanuel Ajayi 301050676
    COMP304 March 20, 2021
    
    Activity to view and edit a patient
 */
public class UpdateInfoActivity extends AppCompatActivity {

    EditText etId, etFirstName, etLastName, etDepartment, etNurseId, etRoom;
    TextView txtMessage;
    Button btnGetData, btnUpdate;

    private PatientViewModel patientViewModel;

    private List<Patient> mPatients = new ArrayList<>();
    private int selectedPatient; // refers to the index of the above ArrayList

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);

        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        // Get data from the database and observe any changes
        patientViewModel.getAllPatients().observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(@Nullable List<Patient> patients) {
                if (patients != null) {
                    mPatients.clear();
                    mPatients = patients;
                }
            }
        });

        etId = (EditText)findViewById(R.id.editTextId);
        etFirstName = (EditText)findViewById(R.id.editTextFirstName);
        etLastName = (EditText)findViewById(R.id.editTextLastName);
        etDepartment = (EditText)findViewById(R.id.editTextDepartment);
        etNurseId = (EditText)findViewById(R.id.editTextNurseId);
        etRoom = (EditText)findViewById(R.id.editTextRoom);
        txtMessage = (TextView)findViewById(R.id.txtMessage);
        txtMessage.setVisibility(View.INVISIBLE);

        btnGetData = (Button)findViewById(R.id.btnGetData);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Find the patient by id
                int inputId = Integer.parseInt(etId.getText().toString());
                boolean found = false;
                for (int i = 0; i < mPatients.size(); i++) {
                    if (mPatients.get(i).getPatientId() == inputId) {
                        selectedPatient = i;
                        found = true;
                        break;
                    }
                }
                if (found) {
                    // Fill the edit fields
                    etFirstName.setText(mPatients.get(selectedPatient).getFirstName());
                    etLastName.setText(mPatients.get(selectedPatient).getLastName());
                    etDepartment.setText(mPatients.get(selectedPatient).getDepartment());
                    etNurseId.setText(String.valueOf(mPatients.get(selectedPatient).getNurseId()));
                    etRoom.setText(mPatients.get(selectedPatient).getRoom());
                    txtMessage.setVisibility(View.INVISIBLE);
                } else {
                    // Couldn't find
                    txtMessage.setText(getString(R.string.update_patienterrormessage));
                    txtMessage.setVisibility(View.VISIBLE);
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Patient newPatient = new Patient();
                try {
                    newPatient.setPatientId(mPatients.get(selectedPatient).getPatientId());
                    newPatient.setFirstName(etFirstName.getText().toString());
                    newPatient.setLastName(etLastName.getText().toString());
                    newPatient.setDepartment(etDepartment.getText().toString());
                    newPatient.setRoom(etRoom.getText().toString());
                    newPatient.setNurseId(Integer.parseInt(etNurseId.getText().toString()));
                    patientViewModel.update(newPatient);
                    txtMessage.setText(getString(R.string.update_okmessage));
                    txtMessage.setTextColor(getResources().getColor(R.color.black));
                    txtMessage.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    Log.d("CT", "There was a problem with updating the patient");
                    txtMessage.setText(getString(R.string.update_errormessage));
                    txtMessage.setTextColor(getResources().getColor(R.color.red));
                    txtMessage.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}