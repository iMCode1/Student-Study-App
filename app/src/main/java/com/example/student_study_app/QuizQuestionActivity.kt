package com.example.student_study_app

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.student_study_app.API.RetrofitInstance
import com.example.student_study_app.databinding.ActivityMainBinding
import com.example.student_study_app.models.QuizQuestionsAPI
import android.graphics.Typeface
import com.example.student_study_app.APIutils.QuizDisplayer
import kotlinx.coroutines.launch

class QuizQuestionActivity:AppCompatActivity() {
    private var userName: String? = null
    private lateinit var binding: ActivityMainBinding
    private var questionsList: ArrayList<QuizQuestionsAPI>? = null;
    private var currentQuestionIndex = 0;
    private var selectedAlternativeIndex = -1;
    private var isAnswerChecked = false;
    private var totalScore = 0;

    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var btnSubmit: Button? = null
    private var tvAlternatives: ArrayList<TextView>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        binding = ActivityMainBinding.inflate(layoutInflater)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvAlternatives = arrayListOf(
            findViewById(R.id.optionOne),
            findViewById(R.id.optionTwo),
            findViewById(R.id.optionThree),
            findViewById(R.id.optionFour),
        )
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.GetQuestions(3)
                if (response.isSuccessful) {
                    response.body()?.let { products ->
                        questionsList = products
                    }
                    updateQuestion()
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

        btnSubmit?.setOnClickListener{
            if(!isAnswerChecked)
            {
                val anyAnswerIsChecked = selectedAlternativeIndex != -1
                if (!anyAnswerIsChecked) {
                    Toast.makeText(this, "Please, select an alternative", Toast.LENGTH_SHORT).show()
                }else
                {
                    val currentAnswer = questionsList?.get(currentQuestionIndex)?.questionAnswer
                    if(tvAlternatives!![selectedAlternativeIndex].text == currentAnswer){
                        totalScore++
                        answerView(tvAlternatives!![selectedAlternativeIndex], R.drawable.correct_option_border_bg)
                    }
                    else{
                        answerView(tvAlternatives!![selectedAlternativeIndex], R.drawable.wrong_option_border_bg)
                        if(tvAlternatives!![0].text == currentAnswer){
                            answerView(tvAlternatives!![0], R.drawable.correct_option_border_bg)
                        }
                        if(tvAlternatives!![1].text == currentAnswer){
                            answerView(tvAlternatives!![1], R.drawable.correct_option_border_bg)
                        }
                        if(tvAlternatives!![2].text == currentAnswer){
                            answerView(tvAlternatives!![2], R.drawable.correct_option_border_bg)
                        }
                        if(tvAlternatives!![3].text == currentAnswer){
                            answerView(tvAlternatives!![3], R.drawable.correct_option_border_bg)
                        }
                    }
                    isAnswerChecked = true
                    btnSubmit?.text = if (currentQuestionIndex+1 == (questionsList?.size)) "FINISH" else "GO TO NEXT QUESTION"
                    selectedAlternativeIndex = -1
                }
            }else{
                if (currentQuestionIndex < (questionsList?.size)?.minus(1)!!){
                    currentQuestionIndex++
                    updateQuestion()
                } else {
                    currentQuestionIndex == 0
                    updateQuestion()
                 /*  val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(QuizDisplayer.USER_NAME, userName)
                    questionsList?.let { it1 -> intent.putExtra(QuizDisplayer.TOTAL_QUESTIONS, it1.size) }
                    intent.putExtra(QuizDisplayer.SCORE, totalScore)
                    startActivity(intent)
                    finish()*/
                }
                isAnswerChecked = false
            }
        }
        tvAlternatives?.let {
            for (optionIndex in it.indices) {
                it[optionIndex].let {
                    it.setOnClickListener{
                        if (!isAnswerChecked) {
                            selectedAlternativeView(it as TextView, optionIndex)
                        }
                    }
                }
            }
        }

    }

    //@SuppressLint("SetTextI18n")
    private fun updateQuestion() {//This function updates the onscreen quiz options
        defaultAlternativesView()

        // Render Question Text
        tvQuestion?.text = questionsList?.get(currentQuestionIndex)?.questionTitle
        // progressBar
        progressBar?.progress = currentQuestionIndex
        // Text of progress bar
        tvProgress?.text = "${currentQuestionIndex + 1}/${questionsList?.size}"

        val randomNumberQuizAppList by lazy {
            listOf(0,1, 2, 3).shuffled()
        }


        tvAlternatives!![randomNumberQuizAppList[0]].text = questionsList?.get(currentQuestionIndex)?.questionAnswer
        tvAlternatives!![randomNumberQuizAppList[1]].text = questionsList?.get(currentQuestionIndex)?.questionOption1
        tvAlternatives!![randomNumberQuizAppList[2]].text = questionsList?.get(currentQuestionIndex)?.questionOption2
        tvAlternatives!![randomNumberQuizAppList[3]].text = questionsList?.get(currentQuestionIndex)?.questionOption3
        btnSubmit?.text = if (currentQuestionIndex == (questionsList?.size ?:-1 )) "FINISH" else "SUBMIT"
    }

    private fun defaultAlternativesView() {
        for (alternativeTv in tvAlternatives!!) {
            alternativeTv.typeface = Typeface.DEFAULT
            alternativeTv.setTextColor(Color.parseColor("#7A8089"))
            alternativeTv.background = ContextCompat.getDrawable(
                this@QuizQuestionActivity,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedAlternativeView(option: TextView, index: Int) {
        defaultAlternativesView()
        selectedAlternativeIndex = index
        option.setTextColor(
            Color.parseColor("#ff0000")
        )
        option.setBackgroundColor(
            Color.parseColor("#00ff1e")
        )
        option.setTypeface(option.typeface, Typeface.BOLD)
        option.background = ContextCompat.getDrawable(
            this@QuizQuestionActivity,
            R.drawable.selected_option_border_bg
        )
    }

    private fun answerView(view: TextView, drawableId: Int) {
        view.background = ContextCompat.getDrawable(
            this@QuizQuestionActivity,
            drawableId
        )
    }
}