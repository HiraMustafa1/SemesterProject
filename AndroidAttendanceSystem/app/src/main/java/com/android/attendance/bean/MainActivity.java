package com.example.mcproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class StudentMainActivity extends Activity {
    EditText teacherName,teacherID;
    Button add,view,viewall,Show1,delete,modify;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main.xml);
        teacherName=(EditText)findViewById(R.id.name);
        teacherID = (EditText) findViewById(R.id.teacherID);
        add=(Button)findViewById(R.id.addbtn);
        view=(Button)findViewById(R.id.viewbtn);
        viewall=(Button)findViewById(R.id.viewallbtn);
        delete=(Button)findViewById(R.id.deletebtn);
        Show1=(Button)findViewById(R.id.showbtn);
        modify=(Button)findViewById(R.id.modifybtn);

        db=openOrCreateDatabase(getString(R.string.faculty_manage), Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS faculty(teacherID INTEGER,teacherName VARCHAR);");


        add.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(teacherID.getText().toString().trim().length()==0||
                        teacherName.getText().toString().trim().length()==0)
                {
                    showMessage("Error", "Please enter all values");
                    return;
                }
                db.execSQL("INSERT INTO student VALUES('"+teacherID.getText()+"','"+teacherName.getText());
                showMessage("Success", "Record added successfully");
                clearText();
            }
        });
        delete.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(teacherID.getText().toString().trim().length()==0)
                {
                    showMessage("Error", "Please enter Teacher ID");
                    return;
                }
                Cursor c=db.rawQuery("SELECT * FROM Ffaculty WHERE teacherID='"+teacherID.getText()+"'", null);
                if(c.moveToFirst())
                {
                    db.execSQL("DELETE FROM student WHERE teacherID='"+teacherID.getText()+"'");
                    showMessage("Success", "Record Deleted");
                }
                else
                {
                    showMessage("Error", "Invalid ID");
                }
                clearText();
            }
        });
        modify.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(teacherID.getText().toString().trim().length()==0)
                {
                    showMessage("Error", "Please enter ID");
                    return;
                }
                Cursor c=db.rawQuery("SELECT * FROM faculty WHERE teacherID='"+teacherID.getText()+"'", null);
                if(c.moveToFirst())
                {
                    db.execSQL("UPDATE faculty SET teacherName='"+teacherName.getText()+
                            "' WHERE teacherID='"+teacherID.getText()+"'");
                    showMessage("Success", "Record Modified");
                }
                else
                {
                    showMessage("Error", "Teacher ID");
                }
                clearText();
            }
        });
        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(teacherID.getText().toString().trim().length()==0)
                {
                    showMessage("Error", "Please enter Teacher ID");
                    return;
                }
                Cursor c=db.rawQuery("SELECT * FROM faculty WHERE teacherID='"+teacherID.getText()+"'", null);
                if(c.moveToFirst())
                {
                    teacherID.setText(c.getString(1));
                    teacherName.setText(c.getString(2));
                }
                else
                {
                    showMessage("Error", "Invalid Teacher ID ");
                    clearText();
                }
            }
        });
        viewall.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                @SuppressLint("Recycle") Cursor c=db.rawQuery("SELECT * FROM student", null);
                if(c.getCount()==0)
                {
                    showMessage("Error", "No records found");
                    return;
                }
                StringBuilder buffer;
                buffer = new StringBuilder();
                while(c.moveToNext())
                {
                    buffer.append("Rollno: "+c.getString(0)+"\n");
                    buffer.append("Name: ").append(c.getString(1)).append("\n");
                }
                showMessage("Teacher Details", buffer.toString());
            }
        });
        Show1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                showMessage("Student Management Application", "Developed By Delaroy Studios");
            }
        });

    }
    public void showMessage(String title,String message)
    {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        teacherID.setText("");
        teacherName.setText("");
        teacherID.requestFocus();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.student_main, menu);
        return true;
    }

}