package com.example.student_study_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.student_study_app.databinding.ActivityMainBinding

class StartPageActivity:AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_page)
        binding = ActivityMainBinding.inflate(layoutInflater)
    }
}