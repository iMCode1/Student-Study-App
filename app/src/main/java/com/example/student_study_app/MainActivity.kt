package com.example.student_study_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.student_study_app.ui.theme.StudentStudyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        }

    fun gradeQuiz(quiz: Quiz,answers: List<String>, selections: List<String>):Int{
        var score=0
        var total=answers.size
        //get quiz from database using API, get questions relating to said quiz,
        // use a loop to put them in a list, present
        // questions in order of ID , as well as the 3 options, capture the user's selection
        for ( i in answers.indices){
            if (answers[i]==selections[i]){
                score++
            }
        }
return score
    }

            
        
    }
}

