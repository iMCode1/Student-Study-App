package com.example.student_study_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.student_study_app.databinding.ActivityMainBinding

class StartPageActivity:AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var btnStarted: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_page)
        binding = ActivityMainBinding.inflate(layoutInflater)
        btnStarted = findViewById(R.id.start_button)

        btnStarted?.setOnClickListener{
            val intent = Intent(this, IntroPageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}