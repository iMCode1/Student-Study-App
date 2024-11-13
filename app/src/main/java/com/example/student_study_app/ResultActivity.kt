package com.example.student_study_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.student_study_app.API.RetrofitInstance
import com.example.student_study_app.AccountValdiation.AccoutnValidationObject
import com.example.student_study_app.databinding.ActivityMainBinding
import com.example.student_study_app.models.HistoryQuizRequest
import kotlinx.coroutines.launch

class ResultActivity:AppCompatActivity() {
    private var btnRestart: Button? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultspage)

        val userName = AccoutnValidationObject.readFromFile(this,"TestUsername.txt")
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val score = intent.getIntExtra(Constants.SCORE, 0)
        val congratulationsTv: TextView = findViewById(R.id.congratulationsTv)
        val scoreTv: TextView = findViewById(R.id.scoreTv)

        btnRestart = findViewById(R.id.btnRestart)
        congratulationsTv.text = "Congratulations, $userName!"
        scoreTv.text = "Your score is $score of $totalQuestions"

        btnRestart?.setOnClickListener{
            val HistoryQui = HistoryQuizRequest(Constants.QuizID,(score.toDouble()/totalQuestions),((Constants.QuizTime)-Constants.TimeTaken),AccoutnValidationObject.readFromFile(this,"TestUserID.txt"))
            lifecycleScope.launch{
                val response = RetrofitInstance.api.AddHistory(HistoryQui)
                if (response.isSuccessful) {
                }
            }
            val intent = Intent(this@ResultActivity, QuizzesPageActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}