package com.example.student_study_app

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import com.example.student_study_app.API.RetrofitInstance
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import com.example.student_study_app.R.id.LeaderboardLayout
import com.example.student_study_app.databinding.ActivityMainBinding
import com.example.student_study_app.models.LeaderboardResponse
import com.example.student_study_app.models.QuizAPI
import kotlinx.coroutines.launch


class Leaderboards : AppCompatActivity() {
    private var listLeaderboard:ListView?=null
    private lateinit var binding: ActivityMainBinding
    private var adapter: ArrayAdapter<Any>?=null
    private var leaderboardArray: ArrayList<LeaderboardResponse>?=null
    private var quizSelect: Spinner?=null
    private var quizlist: ArrayList<QuizAPI>? =null
    private var leaderboardLayout: ConstraintLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listLeaderboard = findViewById(R.id.LeaderboardList)
        quizSelect= findViewById(R.id.QuizSelection)
        leaderboardLayout=findViewById(LeaderboardLayout)

        setContentView(R.layout.leaderboard_page)
        val launch = lifecycleScope.launch {
            try {
                val quizListResponse = RetrofitInstance.api.GetQuiz()
                if (quizListResponse.isSuccessful){
                    val quizzes=quizListResponse.body()
                    let { quizlist= quizzes}

                }


            } catch (e:Exception){  }
        }
        var QuizAdapter= quizlist?.let { ArrayAdapter(this, android.R.layout.simple_spinner_item, it.toList()) }


    //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, leaderboardArray)
       // setListAdapter(adapter)

    }

    fun showLeaderboard(quizID:Int){

        val apiAccess=lifecycleScope.launch {

            val response = RetrofitInstance.api.getLeaderboard(quizID) // API interface
            if (response.isSuccessful) { // This is an if stattment to check if a response is succesful
                val repBody =
                    response.body() // If there is a response body (JSON), you will added to the variable you specified
                repBody?.let {
                    leaderboardArray = response // varaible you specified
                }

            }
        }
    }


}
