package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Nurse;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.models.Test;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.viewmodels.NurseViewModel;
import com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1.viewmodels.TestViewModel;

import java.util.ArrayList;
import java.util.List;

/*
    Activity to view test data of a patient
 */
public class ViewActivity extends AppCompatActivity {

    EditText etPatientId;
    Button btnGetTests;
    ListView listViewTests;

    private TestViewModel testViewModel;
    private TestListAdapter testListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        etPatientId = (EditText)findViewById(R.id.editTextId);

        listViewTests = (ListView)findViewById(R.id.listViewTests);
        testViewModel = ViewModelProviders.of(this).get(TestViewModel.class);

        btnGetTests = (Button)findViewById(R.id.btnGetTests);
        btnGetTests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int inputId = Integer.parseInt(etPatientId.getText().toString());
                testViewModel.getTestsByPatientId(inputId).observe((LifecycleOwner) view.getContext(), new Observer<List<Test>>() {
                    @Override
                    public void onChanged(List<Test> tests) {
                        if (tests != null) {
                            // Update list view
                            int[] testIds = new int[tests.size()];
                            int[] patientIds = new int[tests.size()];
                            int[] nurseIds = new int[tests.size()];
                            double[] bpls = new double[tests.size()];
                            double[] bphs = new double[tests.size()];
                            double[] temperatures = new double[tests.size()];
                            for (int i = 0; i < tests.size(); i++) {
                                testIds[i] = tests.get(i).getTestId();
                                patientIds[i] = tests.get(i).getPatientId();
                                nurseIds[i] = tests.get(i).getNurseId();
                                bpls[i] = tests.get(i).getBpl();
                                bphs[i] = tests.get(i).getBph();
                                temperatures[i] = tests.get(i).getTemperature();
                            }
                            testListAdapter = new TestListAdapter(ViewActivity.this, testIds, patientIds, nurseIds, bpls, bphs, temperatures);
                            listViewTests.setAdapter(testListAdapter);
                        }
                    }
                });
            }
        });
    }
}