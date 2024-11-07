package com.example.student_study_app;

public class Question {
private int questionID;
private String question;
    private String Answer;
    private String Option1;
    private String Option2;
    private String Option3;

public Question(int questionID, String question, String Answer, String optionOne,String option2,String option3){
    this.questionID=questionID;
    this.question=question;
    this.Answer=Answer;
    this.Option1=optionOne;
    this.Option2=option2;
    this.Option3=option3;
}

}
