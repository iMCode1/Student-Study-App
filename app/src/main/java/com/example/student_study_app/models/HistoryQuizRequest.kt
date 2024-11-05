package com.example.student_study_app.models

data class HistoryQuizRequest(
    val quizID: Int,
    val score: Int,
    val timeTakenSeconds: Int
)