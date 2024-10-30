package com.example.student_study_app;

public class User {
    private String UserID;
    private String FirstName;
    private String LastName;
    private String Username;

    public User(String userID, String username, String fname, String lname){
        this.FirstName=fname;
        this.LastName=lname;
        this.UserID=userID;
        this.Username=username;
    }
}
