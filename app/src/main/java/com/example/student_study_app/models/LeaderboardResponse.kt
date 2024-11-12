package com.example.student_study_app.models

data class LeaderboardResponse(
    val username: String,
    val score: Int,
    val timeTakenSeconds: Int
)