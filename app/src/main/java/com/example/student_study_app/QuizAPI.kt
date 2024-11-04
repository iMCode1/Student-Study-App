package com.example.student_study_app

data class QuizAPI(
    val createdOn: String,
    val id: Int,
    val quizTitle: String,
    val subjectCategory: String,
    val timeLimitSeconds: Int
)