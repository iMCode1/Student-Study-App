package com.example.student_study_app

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIservice {// this is an API service which defines the necessary endpoints for the user application
    //QUIZ endpoints
    @GET("/Quiz")
    suspend fun GetQuiz(): Response<List<QuizAPI>>

    //Account endpoints
    @POST("/account/register")
    suspend fun RegisterUser(@Body user: RegisterUserRequest): Response<NewUserObject>

    @POST("/account/login")
    suspend fun loginUser(@Body user: LoginUserRequest): Response<NewUserObject>

    //Leaderboard endpoint
    @GET("/leaderboard/{id}")
    suspend fun getLeaderboard(@Path("id") id: Int): Response<LeaderboardResponse>
}