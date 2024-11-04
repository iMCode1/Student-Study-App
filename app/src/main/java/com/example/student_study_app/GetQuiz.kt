package com.example.student_study_app

import retrofit2.Response
import retrofit2.http.GET

interface GetQuiz {
    @GET("/Quiz")
    suspend fun GetQuiz(): Response<List<QuizAPI>>
}