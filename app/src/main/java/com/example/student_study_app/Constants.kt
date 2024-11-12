package com.example.student_study_app

import com.example.student_study_app.models.NewUserObject
import com.example.student_study_app.models.QuizQuestionsAPI

//this page server to provide the app with constants that will be used throughout the application
object Constants {
        val USER: NewUserObject = NewUserObject(
            email = " ",
            token = " ",
            userName = "TestUser",
            userID = "s"
        )
        val TOTAL_QUESTIONS: String = "total_questions"
        var TimeTaken: Int = 0
        val SCORE: String = "score"
        var qq: ArrayList<QuizQuestionsAPI>? = null
         var QuizTime: Int =1
        var QuizID:Int = 0
}
