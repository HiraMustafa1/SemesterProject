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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.attendance.bean.StudentBean;
import com.android.attendance.db.DBAdapter;

public class AddStudent extends AppCompatActivity {

    Button btnSubmit;
    EditText textFirstName;
    EditText textLastName;
    EditText Roll_Number;

    EditText textContact;
    EditText textAddress;
    Spinner spinnerDept, spinnerField;
    String userRole, branch, year;
    private String[] deptString = new String[]{"cs"};
    private String[] fieldString = new String[]{"SE", "CS", "IT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        spinnerDept = (Spinner) findViewById(R.id.spinnerDept);
        spinnerField = (Spinner) findViewById(R.id.spinnerField);
        textFirstName = (EditText) findViewById(R.id.textFirstName);
        textLastName = (EditText) findViewById(R.id.textLastName);
        Roll_Number = (EditText) findViewById(R.id.Roll_Number);
        textContact = (EditText) findViewById(R.id.textContact);
        textAddress = (EditText) findViewById(R.id.textAddress);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        spinnerDept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                ((TextView) arg0.getChildAt(0)).setTextColor(Color.WHITE);
                branch = (String) spinnerDept.getSelectedItem();

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
                year = (String) spinnerField.getSelectedItem();

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


    btnSubmit.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick (View v) {
            // TODO Auto-generated method stub
            //......................................validation
            String first_name = textFirstName.getText().toString();
            String last_name = textLastName.getText().toString();
            String roll_no = Roll_Number.getText().toString();
            String phone_no = textContact.getText().toString();
            String address = textAddress.getText().toString();

            if (TextUtils.isEmpty(first_name)) {
                textFirstName.setError("please enter firstname");
            } else if (TextUtils.isEmpty(last_name)) {
                textLastName.setError("please enter lastname");
            } else if (TextUtils.isEmpty(roll_no)) {
                textLastName.setError("please enter rollNumber");
            } else if (TextUtils.isEmpty(phone_no)) {
                textContact.setError("please enter phoneno");
            } else if (TextUtils.isEmpty(address)) {
                textAddress.setError("enter address");
            } else {

                StudentBean studentBean = new StudentBean();

                studentBean.setStudent_firstName(first_name);
                studentBean.setStudent_lastName(last_name);
                studentBean.setStudent_rollNumber(roll_no);
                studentBean.setStudent_mobileNumber(phone_no);
                studentBean.setStudent_address(address);
                studentBean.setStudent_department(branch);
                studentBean.setStudent_class(year);

                DBAdapter dbAdapter = new DBAdapter(AddStudent.this);
                dbAdapter.addStudent(studentBean);

                Intent intent = new Intent(AddStudent.this, Menu.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "student added successfully", Toast.LENGTH_SHORT).show();
            }
        }
    });
  }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}