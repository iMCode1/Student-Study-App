package com.example.student_study_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.student_study_app.AccountValdiation.AccoutnValidationObject

class ResultActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultspage)
       // val userName = intent.getStringExtra(Constants.USER.userName)
        val userName = AccoutnValidationObject.readFromFile(this,"TestUsername.txt")
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val score = intent.getIntExtra(Constants.SCORE, 0)
        val congratulationsTv: TextView = findViewById(R.id.congratulationsTv)
        val scoreTv: TextView = findViewById(R.id.scoreTv)
        val btnRestart: Button = findViewById(R.id.btnRestart)
        congratulationsTv.text = "Congratulations, $userName!"
        scoreTv.text = "Your score is $score of $totalQuestions"
        btnRestart.setOnClickListener{
            val intent = Intent(this, QuizzesPageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}