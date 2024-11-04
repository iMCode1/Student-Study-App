package com.example.student_study_app

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.student_study_app.databinding.ActivityMainBinding
import com.example.student_study_app.ui.theme.StudentStudyAppTheme
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudentStudyAppTheme {
            }
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            try {
                binding.progressBar.visibility = View.VISIBLE
                val response = RetrofitInstance.api.GetQuiz()
                if (response.isSuccessful) {
                    response.body()?.let { QuizAPI ->
                        displayProducts(QuizAPI)
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

    private fun displayProducts(quiz: List<QuizAPI>) {
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            quiz.map { "${it.quizTitle} - ${it.subjectCategory} - ${it.createdOn} - ${it.timeLimitSeconds} - ${it.id}" }
        )
        findViewById<ListView>(R.id.listView).adapter = adapter
        binding.listView.adapter = adapter
    }

}

