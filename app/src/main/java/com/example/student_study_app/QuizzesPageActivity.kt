package com.example.student_study_app

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.lifecycle.lifecycleScope
import com.example.student_study_app.API.RetrofitInstance
import com.example.student_study_app.databinding.ActivityMainBinding
import com.example.student_study_app.models.QuizAPI
import kotlinx.coroutines.launch

class QuizzesPageActivity:AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var quizlist: ArrayList<QuizAPI>? = null;
    private var containerLayout: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quizzes_page)
        binding = ActivityMainBinding.inflate(layoutInflater)
        containerLayout = findViewById(R.id.quiz_display)

        lifecycleScope.launch {
            try {
                binding.progressBar.visibility = View.VISIBLE
                val response = RetrofitInstance.api.GetQuiz()
                if (response.isSuccessful) {
                    val leaderboard = response.body()
                    leaderboard?.let {
                        // Process the leaderboard data
                        quizlist = leaderboard
                    }
                    updateQuiz()
                    handleItemClick()
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
    private  fun updateQuiz(){
        handleItemClick()
        containerLayout?.removeAllViews()
        for (i in 0 until quizlist!!.size) {
            val textView = TextView(this).apply {
                text = "Title: ${quizlist!![i].quizTitle}\nCategory: ${quizlist!![i].subjectCategory}\nTime Limit: ${quizlist!![i].timeLimitSeconds} seconds"
                id = quizlist!![i].id
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 24, 0, 24) // Add spacing between elements
                }

                // Text and background styling
                text = "Title: ${quizlist!![i].quizTitle}\nCategory: ${quizlist!![i].subjectCategory}\nTime Limit: ${quizlist!![i].timeLimitSeconds}"
                setTextColor(android.graphics.Color.parseColor("#f0f0f0")) // Slightly softer white
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f) // Smaller, to improve readability

                // Apply the custom background with rounded corners and gradient
                setBackgroundResource(R.drawable.rounded_background)

                // Additional styling
                setLineSpacing(8f, 1.2f) // Increase line height for readability
                typeface = Typeface.SANS_SERIF // Use sans-serif for a modern look
                textAlignment = View.TEXT_ALIGNMENT_CENTER // Center align text

                // Elevation and padding
                elevation = 4f // Subtle shadow
                setPadding(32, 32, 32, 32) // Larger padding for a spacious look
            }
            containerLayout?.addView(textView)
        }

    }
    private fun handleItemClick() {
        containerLayout?.children?.forEach { container ->
            container.setOnClickListener {
                Toast.makeText(this, "Clicked: ${container.id}", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, QuizQuestionActivity::class.java)
                lifecycleScope.launch{
                    try {
                        binding.progressBar.visibility = View.VISIBLE
                        val response = RetrofitInstance.api.GetQuestions(container.id)
                        if (response.isSuccessful) {
                            val leaderboard = response.body()
                            leaderboard?.let {
                                // Process the leaderboard data
                               for(i in 0..(quizlist?.size?.minus(1!!)!!)){
                                    if(quizlist!![i].id == container.id){Constants.QuizTime = quizlist!![i].timeLimitSeconds}
                               }
                                Constants.QuizID = container.id
                                Constants.qq = leaderboard
                                startActivity(intent)
                                finish()
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
        // Optional: Implement your click handling logic here
        // For example, open a new activity or show a dialog
            //showItemDialog(position, item)
    }
}