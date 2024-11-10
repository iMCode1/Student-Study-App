package com.example.student_study_app

import android.view.View
import com.example.student_study_app.API.RetrofitInstance
import com.example.student_study_app.databinding.ActivityMainBinding
import com.example.student_study_app.models.NewUserObject
import com.example.student_study_app.models.QuizQuestionsAPI
//this page server to provide the app with constants that will be used throughout the application
object Constants {
        val USER: NewUserObject = NewUserObject(
            email = " ",
            token = " ",
            userName = "TestUser",
        )
        val USER_NAME: String = "user_name"
        val TOTAL_QUESTIONS: String = "total_questions"
        val SCORE: String = "score"
        val qq: ArrayList<QuizQuestionsAPI>? = null

    suspend fun fetchAndDisplayQuiz(binding: ActivityMainBinding,a:Int): ArrayList<QuizQuestionsAPI>? {
        var leaderboard: ArrayList<QuizQuestionsAPI>? = null;
        try {
            binding.progressBar.visibility = View.VISIBLE
            val response = RetrofitInstance.api.GetQuestions(a)

            if (response.isSuccessful) {
                leaderboard = response.body()
                leaderboard?.let {
                    // Process the leaderboard data
                }

            } else {
                binding.textError.text = "Error: ${response.code()}"
                binding.textError.visibility = View.VISIBLE
            }
        } catch (e: Exception) {
            binding.textError.text = "Error: ${e.message}"
            binding.textError.visibility = View.VISIBLE
        } finally {
            binding.progressBar.visibility = View.GONE
        }
        return leaderboard
    }

}
