package com.example.student_study_app.API

import com.example.student_study_app.models.HistoryQuizRequest
import com.example.student_study_app.models.LeaderboardResponse
import com.example.student_study_app.models.LoginUserRequest
import com.example.student_study_app.models.NewUserObject
import com.example.student_study_app.models.QuizAPI
import com.example.student_study_app.models.QuizHistoryResponse
import com.example.student_study_app.models.QuizQuestionsAPI
import com.example.student_study_app.models.RegisterUserRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface APIservice {// this is an API service which defines the necessary endpoints for the user application
    //QUIZ endpoints
    @GET("/Quiz")
    suspend fun GetQuiz(): Response<ArrayList<QuizAPI>>
    @GET("/Quiz/{id}")
    suspend fun GetQuestions(@Path("id") id: Int): Response<ArrayList<QuizQuestionsAPI>>

    //Account endpoints
    @POST("/account/register")
    suspend fun RegisterUser(@Body user: RegisterUserRequest): Response<NewUserObject>
    @POST("/account/login")
    suspend fun loginUser(@Body user: LoginUserRequest): Response<NewUserObject>

    //Leaderboard endpoint
    @GET("/leaderboard/{id}")
    suspend fun getLeaderboard(@Path("id") id: Int): Response<LeaderboardResponse>

    //History endpoints - require authorisation
    @POST("/history")
    suspend fun GetUserHistory(@Body history: HistoryQuizRequest,@Header("Authorization")token:String)
    @GET("/history/Quiz/{id}")
    suspend fun GetUserHistory(@Path("id")id: Int,@Header("Authorization")token:String):Response<QuizHistoryResponse>
}