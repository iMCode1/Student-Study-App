package com.example.student_study_app.models

data class QuizAPI(
    val createdOn: String,
    val id: Int,
    val quizTitle: String,
    val subjectCategory: String,
    val timeLimitSeconds: Int
)