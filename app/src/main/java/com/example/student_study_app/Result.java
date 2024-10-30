package com.example.student_study_app;

import java.util.Date;

public class Result {
    private int resultID;
    private float score;
    private Date DoP;

    public Result(int resID, float mark, Date date){
        this.resultID=resID;
        this.score=mark;
        this.DoP=date;

    }
}
