package com.example.student_study_app

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.student_study_app.databinding.ActivityMainBinding

class LoginPageActivity:AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)
        binding = ActivityMainBinding.inflate(layoutInflater)
    }
}