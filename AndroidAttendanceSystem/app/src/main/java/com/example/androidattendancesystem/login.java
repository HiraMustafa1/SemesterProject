package com.example.androidattendancesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class login extends AppCompatActivity {

    Button buttonLogin;
    EditText editTextTextPersonName;
    EditText editTextTextPassword;
    Spinner spinnerLoginAs;
    String userRole;
    private String[] userRoleString = new String[]{"admin", "faculty", "student"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonLogin = findViewById(R.id.buttonLogin);
        EditText editTextTextPerson = findViewById(R.id.editTextTextPersonName);
        EditText editTextTextPassword = findViewById(R.id.editTextTextPassword);
        Spinner spinnerLoginAs = findViewById(R.id.spinnerLoginAs);



    }


    public void btn_login(View view) {
        Intent intent = new Intent (this, Menu.class);
        startActivity(intent);
    }
}
