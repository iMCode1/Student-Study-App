package com.example.student_study_app;

public class FlashCard {
    private int flashID;
    private String Title;
    private String content;

    public FlashCard(int id, String title, String content){
        this.content=content;
        this.flashID=id;
        this.Title=title;
    }
}
