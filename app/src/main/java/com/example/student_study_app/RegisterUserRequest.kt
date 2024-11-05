package com.example.student_study_app

data class RegisterUserRequest(
    val email: String,
    val password: String,
    val userFirstName: String,
    val userLastName: String,
    val username: String
)