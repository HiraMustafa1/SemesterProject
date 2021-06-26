package com.android.attendance.bean;

public class StudentBean {

    private int student_id;
    private String student_firstName;
    private String student_lastName;
    private String student_mobileNumber;
    private String student_address;
    private String student_rollNumber;
    private String student_department;
    private String student_class;
    public int getStudent_id() { return student_id; }
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
    public String getStudent_firstName() {
        return student_firstName;
    }
    public void setStudent_firstName(String student_firstName) {
        this.student_firstName = student_firstName;
    }
    public String getStudent_lastName() {
        return student_lastName;
    }
    public void setStudent_lastName(String student_lastName) {
        this.student_lastName = student_lastName;
    }
    public String getStudent_rollNumber() {
        return student_rollNumber;
    }
    public void setStudent_rollNumber(String student_rollNumber) {
        this.student_lastName = getStudent_rollNumber();
    }
    public String getStudent_mobileNumber() {
        return student_mobileNumber;
    }
    public void setStudent_mobileNumber(String student_mobileNumber) {
        this.student_mobileNumber = student_mobileNumber;
    }
    public String getStudent_address() {
        return student_address;
    }
    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }
    public String getStudent_department() {
        return student_department;
    }
    public void setStudent_department(String student_department) {
        this.student_department = student_department;
    }
    public String getStudent_class() {
        return student_class;
    }
    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

}
