package com.example.student_study_app

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
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
import android.graphics.drawable.GradientDrawable
import android.os.CountDownTimer
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AlertDialog
import kotlinx.coroutines.launch

class QuizQuestionActivity:AppCompatActivity() {
    private var userName: String? = null
    private lateinit var binding: ActivityMainBinding
    private var questionsList: ArrayList<QuizQuestionsAPI>? = Constants.qq;
    private var currentQuestionIndex = 0;
    private var selectedAlternativeIndex = -1;
    private var isAnswerChecked = false;
    private var totalScore = 0;

    private var tvQuizScore: TextView? =null
    private var tvQuestion: TextView? = null
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var btnSubmit: Button? = null
    private var tvTime: TextView? =null
    private var tvAlternatives: ArrayList<TextView>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        binding = ActivityMainBinding.inflate(layoutInflater)
        tvQuestion = findViewById(R.id.tvQuestion)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuizScore = findViewById(R.id.tvScore)
        tvTime = findViewById(R.id.tvQuizTime)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvAlternatives = arrayListOf(
            findViewById(R.id.optionOne),
            findViewById(R.id.optionTwo),
            findViewById(R.id.optionThree),
            findViewById(R.id.optionFour),
        )
        updateQuestion()
        timer.start()
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
                    val intent = Intent(this, ResultActivity::class.java)
                    questionsList?.let { it1 -> intent.putExtra(Constants.TOTAL_QUESTIONS, it1.size) }
                    intent.putExtra(Constants.SCORE, totalScore)
                    timer.cancel()
                    startActivity(intent)
                    finish()
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
    val timer = object : CountDownTimer(Constants.QuizTime.toLong()*1000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            // Called every second
            tvTime?.text = "Time remaingn: ${(millisUntilFinished / 1000).toString()}"
            Constants.TimeTaken = (millisUntilFinished / 1000).toInt()
        }

        override fun onFinish() {
            val intent = Intent(this@QuizQuestionActivity, ResultActivity::class.java)
            questionsList?.let { it1 -> intent.putExtra(Constants.TOTAL_QUESTIONS, it1.size) }
            intent.putExtra(Constants.SCORE, totalScore)
            startActivity(intent)
            finish()
        }

    }
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Confirm Exit")
            .setMessage("Are you sure you want to go back?")
            .setPositiveButton("Yes") { _, _ ->
                timer.cancel()
                super.onBackPressed() // Exit the activity
            }
            .setNegativeButton("No", null) // Dismiss the dialog
            .show()
    }

    private fun updateQuestion() {//This function updates the onscreen quiz options
        defaultAlternativesView()
        progressBar?.max = questionsList?.size!!
        tvQuizScore?.text = "Score: $totalScore"
        // Render Question Text
        tvQuestion?.text = questionsList?.get(currentQuestionIndex)?.questionTitle
        // progressBar
        progressBar?.progress = currentQuestionIndex+1
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
            alternativeTv.setTextColor(Color.parseColor("#000000"))
            alternativeTv.background = ContextCompat.getDrawable(
                this@QuizQuestionActivity,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedAlternativeView(option: TextView, index: Int) {
        // Reset other options to default view
        defaultAlternativesView()

        // Set the selected index
        selectedAlternativeIndex = index

        // Customize text appearance
        option.setTextColor(Color.parseColor("#f0f0f0"))
        option.setTypeface(option.typeface, Typeface.BOLD)

        // Create a drawable for the background to support color animation
        val backgroundDrawable = ContextCompat.getDrawable(
            this@QuizQuestionActivity,
            R.drawable.selected_option_border_bg
        ) as GradientDrawable

        // Set initial background color if needed
        backgroundDrawable.setColor(Color.parseColor("#ffffff")) // Initial color

        // Apply the drawable to the TextView
        option.background = backgroundDrawable

        // Define the color animation
        val colorAnimation = ObjectAnimator.ofArgb(
            backgroundDrawable, "color",
            Color.parseColor("#ffffff"), // Starting color (white)
            Color.parseColor("#031157")  // Target color (your choice)
        )
        colorAnimation.duration = 300 // Animation duration in milliseconds
        colorAnimation.interpolator = AccelerateDecelerateInterpolator()

        // Start the animation
        colorAnimation.start()
    }

    private fun answerView(view: TextView, drawableId: Int) {
        view.background = ContextCompat.getDrawable(
            this@QuizQuestionActivity,
            drawableId
        )
    }
}



