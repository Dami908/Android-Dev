package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
/*
    Charles Thomson 301062645
    Emmanuel Ajayi 301050676
    COMP304 March 20, 2021

    Activity for overall navigation
 */

public class MainActivity extends AppCompatActivity {

    Button btnRegisterPatient, btnEnterTestData, btnViewTestData, btnUpdatePatientInfo;
    ImageButton btnLogout;

    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegisterPatient = (Button)findViewById(R.id.btnRegisterPatient);
        btnRegisterPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoPatientActivity();
            }
        });
        btnEnterTestData = (Button)findViewById(R.id.btnEnterTestData);
        btnEnterTestData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoTestActivity();
            }
        });
        btnViewTestData = (Button)findViewById(R.id.btnViewTestData);
        btnViewTestData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoViewActivity();
            }
        });
        btnUpdatePatientInfo = (Button)findViewById(R.id.btnUpdatePatientInfo);
        btnUpdatePatientInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUpdateInfoActivity();
            }
        });

        mSharedPreferences = this.getSharedPreferences(this.getPackageName(), this.MODE_PRIVATE);

        btnLogout = (ImageButton)findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear Shared Preferences
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putInt("nurseId", 0);
                editor.apply();
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubar_activity,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.id_patient:
                gotoPatientActivity();
                break;
            case R.id.id_testActivity:
                gotoTestActivity();
                break;
            case R.id.id_viewTest:
                gotoViewActivity();
                break;
            case R.id.id_updateInfo:
                gotoUpdateInfoActivity();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void gotoPatientActivity() {
        Intent intent;
        intent =new Intent(this, PatientActivity.class);
        startActivity(intent);
    }

    private void gotoTestActivity() {
        Intent intent;
        intent =new Intent(this, TestActivity.class);
        startActivity(intent);
    }

    private void gotoViewActivity() {
        Intent intent;
        intent =new Intent(this, ViewActivity.class);
        startActivity(intent);
    }

    private void gotoUpdateInfoActivity() {
        Intent intent;
        intent =new Intent(this, UpdateInfoActivity.class);
        startActivity(intent);
    }
}