package com.example.student_study_app


import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import com.example.student_study_app.API.RetrofitInstance
import com.example.student_study_app.databinding.ActivityMainBinding
import com.example.student_study_app.models.LeaderboardResponse
import com.example.student_study_app.models.QuizAPI
import kotlinx.coroutines.launch


class Leaderboards : AppCompatActivity() {
    private var listLeaderboard:ListView?=null
    private lateinit var binding: ActivityMainBinding
    private var leaderboardArray: ArrayList<LeaderboardResponse>?=null
    private var quizSelect: Spinner?=null
   // private var quizlist: ArrayList<QuizAPI>? =null
    private var leaderboardLayout: ConstraintLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.leaderboard_page)
        binding = ActivityMainBinding.inflate(layoutInflater)
        listLeaderboard = findViewById(R.id.leaderboardList)
        quizSelect = findViewById(R.id.quizSelection)
        leaderboardLayout=findViewById(R.id.leaderboardLayout)
        SpinnerPopulater()
        quizSelect?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Get the selected item
                val a = Constants.qb?.get(position)?.id
                val b = Constants.qb?.get(position)?.quizTitle
                if (a != null) {
                    showLeaderboard(a)
                }
                // Handle the selection
                Toast.makeText(this@Leaderboards, "Selected: ${b}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    fun showLeaderboard(quizID:Int){// Used to populate the list view
        lifecycleScope.launch {
            val response = RetrofitInstance.api.getLeaderboard(quizID)
            if (response.isSuccessful) {
                val repBody = response.body()
                repBody?.let {a -> displayResults(a)}
            }
        }
        val leaderboardAdapter= leaderboardArray?.let { ArrayAdapter(this, android.R.layout.simple_list_item_1, it.toList()) }
        leaderboardAdapter?.addAll()
        listLeaderboard?.adapter =leaderboardAdapter


    }
    private fun displayResults(quiz: List<LeaderboardResponse>) {
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            quiz.map { "${it.username} \nScore: ${it.score} \nTime: ${it.timeTakenSeconds}" }
        )
        listLeaderboard?.adapter = adapter
        binding.listView.adapter = adapter
    }

    fun SpinnerPopulater(){ //Used for populating the spinner
        val adapter = ArrayAdapter(this@Leaderboards, android.R.layout.simple_spinner_item, Constants.qb!!.map { it.quizTitle })//adapts the list to the spinner only displaying the titles
        quizSelect?.adapter = adapter
    }


}
