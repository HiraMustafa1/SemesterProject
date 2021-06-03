package com.example.androidattendancesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.attendance.bean.FacultyBean;
import com.android.attendance.db.DBAdapter;

public class AddFaculty extends AppCompatActivity {

    Button btn_submit;
    EditText textFirstName;
    EditText textLastName;
    EditText textContact;
    EditText textAddress;
    EditText textUserName;
    EditText textPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faculty);

        Button btn_submit = findViewById(R.id.btnSubmit);
        EditText textFirstName= findViewById(R.id.editTextTextPersonName);
        EditText textLastName= findViewById(R.id.textLastName);
        EditText textContact= findViewById(R.id.textContact);
        EditText textAddress= findViewById(R.id.textAddress);
        EditText textUserName= findViewById(R.id.textUserName);
        EditText textPassword= findViewById(R.id.textPassword);

        btn_submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (AddFaculty.this, MenuPage.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Faculty Added Successfully", Toast.LENGTH_SHORT).show();
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