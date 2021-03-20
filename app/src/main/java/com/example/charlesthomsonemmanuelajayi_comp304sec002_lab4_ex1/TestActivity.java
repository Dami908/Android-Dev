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
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Test;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.viewmodels.PatientViewModel;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.viewmodels.TestViewModel;

/*
    Activity to add a test for a patient
 */
public class TestActivity extends AppCompatActivity {
    EditText patientid, bpl, bph,temp;
    Button btnRegister;
    TextView txtMessage;

    private TestViewModel testViewModel;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        patientid = (EditText)findViewById(R.id.patientID);
        bpl = (EditText)findViewById(R.id.BPL);
        bph = (EditText)findViewById(R.id.BPH);
        temp = (EditText)findViewById(R.id.Temperature);
        txtMessage = (TextView)findViewById(R.id.txtMessage);
        txtMessage.setVisibility(View.INVISIBLE);

        mSharedPreferences = this.getSharedPreferences(this.getPackageName(), this.MODE_PRIVATE);
        testViewModel = ViewModelProviders.of(this).get(TestViewModel.class);

        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Patientid = patientid.getText().toString();
                String BPL = bpl.getText().toString();
                String BPH = bph.getText().toString();
                String Temp = temp.getText().toString();

                int finalPatientid = Integer.parseInt(Patientid);
                double finalBPL = Double.parseDouble(BPL);
                double finalBPH = Double.parseDouble(BPH);
                double finalTEMP = Double.parseDouble(Temp);
                // Get nurseId from SharedPreferences
                int nurseId = mSharedPreferences.getInt("nurseId", 0);
                Test newTest = new Test();
                try {
                    newTest.setPatientId(finalPatientid);
                    newTest.setBpl(finalBPL);
                    newTest.setBph(finalBPH);
                    newTest.setTemperature(finalTEMP);
                    newTest.setNurseId(nurseId);
                    testViewModel.insert(newTest);
                    txtMessage.setText("Test Result registered!");
                    txtMessage.setTextColor(getResources().getColor(R.color.black));
                    txtMessage.setVisibility(View.VISIBLE);
                    // Empty EditText fields
                    patientid.setText("");
                    bpl.setText("");
                    bph.setText("");
                    temp.setText("");
                } catch (Exception e) {
                    Log.d("CT", "There was a problem with creating/registering the new Test Result");
                    txtMessage.setText("Something went wrong with the Test Registration");
                    txtMessage.setTextColor(getResources().getColor(R.color.red));
                    txtMessage.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}