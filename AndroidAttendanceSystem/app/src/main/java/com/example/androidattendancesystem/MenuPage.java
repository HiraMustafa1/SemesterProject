package com.example.androidattendancesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;


public class MenuPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
    }

    public void btn_addStudent(View view) {
        Intent intent = new Intent(this, AddStudent.class);
        startActivity(intent);
    }

    public void btn_viewStudent(View view) {
        Intent intent = new Intent(this, ViewStudent.class);
        startActivity(intent);
    }

    public void btn_attendancePerStudent(View view) {
        Intent intent = new Intent(this, AttendancePerStudent.class);
        startActivity(intent);
    }

    public void btn_addFaculty(View view) {
        Intent intent = new Intent(this, AddFaculty.class);
        startActivity(intent);
    }

    public void btn_viewFaculty(View view) {
        Intent intent = new Intent(this, ViewFaculty.class);
        startActivity(intent);
    }

    public void btn_logout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}