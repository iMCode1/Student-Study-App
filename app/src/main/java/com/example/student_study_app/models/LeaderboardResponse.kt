package com.example.student_study_app.models

data class LeaderboardResponse(
    val score: Int,
    val timeTakenSeconds: Int,
    val username: String
)