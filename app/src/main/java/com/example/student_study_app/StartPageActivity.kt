package com.example.student_study_app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.student_study_app.API.RetrofitInstance
import com.example.student_study_app.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class StartPageActivity:AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_page)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val loadingSpinner: ProgressBar = findViewById(R.id.loadingSpinner)


            lifecycleScope.launch {
                try {
                    Toast.makeText(this@StartPageActivity, "Loading, please wait", Toast.LENGTH_SHORT).show()
                    loadingSpinner.visibility = View.VISIBLE
                    Handler(Looper.getMainLooper()).postDelayed({
                        // Hide spinner after task is completed
                        loadingSpinner.visibility = View.GONE
                    }, 3000)
                    val response = RetrofitInstance.api.GetQuiz()
                    if (response.isSuccessful) {
                        val leaderboard = response.body()
                        leaderboard?.let {
                            // Process the leaderboard data
                            Constants.qb = leaderboard
                            val intent = Intent(this@StartPageActivity, IntroPageActivity::class.java)
                            startActivity(intent)
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
            }


    }

}