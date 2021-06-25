package com.example.androidattendancesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.attendance.bean.FacultyBean;
import com.android.attendance.context.ApplicationContext;
import com.android.attendance.db.DBAdapter;

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
        EditText editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        EditText editTextTextPassword = findViewById(R.id.editTextTextPassword);
        Spinner spinnerLoginAs = findViewById(R.id.spinnerLoginAs);

        spinnerLoginAs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                userRole =(String) spinnerLoginAs.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        ArrayAdapter<String> adapter_role = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, userRoleString);
        adapter_role
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLoginAs.setAdapter(adapter_role);

        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               if(userRole.equals("admin")) {
                   if (editTextTextPersonName.getText().toString().equals("admin") & (editTextTextPassword.getText().toString().equals("admin123"))) {
                       Intent intent = new Intent(login.this, MenuPage.class);
                       startActivity(intent);
                       Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                   } else {
                       Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                   }
               }
               else {
                   DBAdapter dbAdapter = new DBAdapter(login.this);
                   FacultyBean facultyBean = dbAdapter.validateFaculty(editTextTextPersonName.getText().toString(), editTextTextPassword.getText().toString());
                   if (facultyBean != null) {
                       Intent intent = new Intent(login.this, AddAttendanceSession.class);
                       startActivity(intent);
                       ((ApplicationContext) login.this.getApplicationContext()).setFacultyBean(facultyBean);
                       Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                   } else {
                       Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    }

