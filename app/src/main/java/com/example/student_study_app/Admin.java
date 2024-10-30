package com.example.student_study_app;

public class Admin extends User {
private int AdminID;
    public Admin(String userID, String username, String fname, String lname,int AdminID) {
        super(userID, username, fname, lname);
        this.AdminID=AdminID;
    }
}
