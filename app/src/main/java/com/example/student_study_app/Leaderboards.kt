package com.example.student_study_app


import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ListAdapter
import com.example.student_study_app.R
import com.example.student_study_app.API.RetrofitInstance
import com.example.student_study_app.R.id.LeaderboardLayout
import com.example.student_study_app.databinding.ActivityMainBinding
import com.example.student_study_app.models.LeaderboardResponse
import com.example.student_study_app.models.QuizAPI
import kotlinx.coroutines.launch


class Leaderboards : AppCompatActivity() {
    private var listLeaderboard:ListView?=null
    private lateinit var binding: ActivityMainBinding
    private var QAadapter: ArrayAdapter<Any>?=null
    private var leaderboardArray: ArrayList<LeaderboardResponse>?=null
    private var quizSelect: Spinner?=null
    private var quizlist: ArrayList<QuizAPI>? =null
    private var leaderboardLayout: ConstraintLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listLeaderboard = findViewById(R.id.LeaderboardList)
        quizSelect= findViewById(R.id.QuizSelection)
        leaderboardLayout=findViewById(LeaderboardLayout)

        setContentView(com.example.student_study_app.R.layout.leaderboard_page)
        val launch = lifecycleScope.launch {
            try {
                val quizListResponse = RetrofitInstance.api.GetQuiz()
                if (quizListResponse.isSuccessful){
                    val quizzes=quizListResponse.body()
                    let { quizlist= quizzes}

                }


            } catch (e:Exception){  }
        }
        QAadapter= quizlist?.let { ArrayAdapter(this, android.R.layout.simple_spinner_item, it.toList()) }
        QAadapter?.addAll()
        quizSelect?.adapter=QAadapter

    //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, leaderboardArray)
       // setListAdapter(adapter)
        //showLeaderboard(6)
        var adapterView:AdapterView<ArrayAdapter<QuizAPI>>?
        var itemSel=quizSelect?.selectedItemId
quizSelect?.setOnClickListener()//from the item selecter, you extrapolate the quiz id, use the quis id to show the leaderboard
    }

    fun showLeaderboard(quizID:Int){

        val apiAccess=lifecycleScope.launch {

            val response = RetrofitInstance.api.getLeaderboard(quizID) // API interface
            if (response.isSuccessful) { // This is an if stattment to check if a response is succesful
                val repBody =
                    response.body() // If there is a response body (JSON), you will added to the variable you specified
                repBody?.let {
                    leaderboardArray = repBody // varaible you specified
                }

            }
        }
        val leaderboardAdapter= leaderboardArray?.let { ArrayAdapter(this, android.R.layout.simple_list_item_1, it.toList()) }
        leaderboardAdapter?.addAll()
        listLeaderboard?.adapter =leaderboardAdapter


    }


}

