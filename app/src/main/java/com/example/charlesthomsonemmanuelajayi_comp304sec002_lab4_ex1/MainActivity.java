package com.example.charlesthomsonemmanuelajayi_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubar_activity,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent;
        switch(item.getItemId()){
            case R.id.id_patient:
                intent =new Intent(this,patientActivity.class);
                startActivity(intent);
                break;
            case R.id.id_testActivity:
                intent =new Intent(this,testActivity.class);
                startActivity(intent);
                break;
            case R.id.id_updateInfo:
                intent =new Intent(this,updateInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.id_viewTest:
                intent =new Intent(this,viewActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}