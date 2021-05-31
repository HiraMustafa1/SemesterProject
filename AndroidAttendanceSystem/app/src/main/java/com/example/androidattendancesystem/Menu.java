package com.example.androidattendancesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
}