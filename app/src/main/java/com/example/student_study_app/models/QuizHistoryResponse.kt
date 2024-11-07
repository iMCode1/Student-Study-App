package com.example.student_study_app.models

data class QuizHistoryResponse(
    val dateSubmitted: String,
    val score: Int,
    val timeTakenSeconds: Int
)