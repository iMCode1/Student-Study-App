package com.example.student_study_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.student_study_app.AccountValdiation.AccoutnValidationObject
import com.example.student_study_app.databinding.ActivityMainBinding

class IntroPageActivity:AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var btnLogin: Button? = null
    private var btnReg: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_page)
        binding = ActivityMainBinding.inflate(layoutInflater)
        btnLogin = findViewById(R.id.signInButton)
        btnReg = findViewById(R.id.registerButton)
        if(AccoutnValidationObject.CheckIfExists(this,"TestUsername.txt")){
            Toast.makeText(this, "Welcome back,${AccoutnValidationObject.readFromFile(this,"TestUsername.txt")}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, QuizzesPageActivity::class.java)
            startActivity(intent)
            finish()
        }
        btnLogin?.setOnClickListener{
            val intent = Intent(this, LoginPageActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnReg?.setOnClickListener{
            val intent = Intent(this, RegisterPageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}