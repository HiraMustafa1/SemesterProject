package com.example.androidattendancesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddStudent extends AppCompatActivity {

    Button btnSubmit;
    EditText textFirstName;
    EditText textLastName;

    EditText textContact;
    EditText textAddress;
    Spinner spinnerDept,spinnerField;
    String userRole,branch,year;
    private String[] deptString = new String[] { "cs"};
    private String[] fieldString = new String[] {"SE","CS","IT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        spinnerDept=(Spinner)findViewById(R.id.spinnerDept);
        spinnerField=(Spinner)findViewById(R.id.spinnerField);
        textFirstName=(EditText)findViewById(R.id.textFirstName);
        textLastName=(EditText)findViewById(R.id.textLastName);
        textContact=(EditText)findViewById(R.id.textContact);
        textAddress=(EditText)findViewById(R.id.textAddress);
        btnSubmit=(Button)findViewById(R.id.btnSubmit);

        spinnerDept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                branch =(String) spinnerDept.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<String> adapter_branch = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, deptString);
        adapter_branch
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDept.setAdapter(adapter_branch);
        ///......................spinner2
        spinnerField.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                year =(String) spinnerField.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<String> adapter_year = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, fieldString);
        adapter_year
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerField.setAdapter(adapter_year);


    }



    public void btn_submit(View view) {
    }
}