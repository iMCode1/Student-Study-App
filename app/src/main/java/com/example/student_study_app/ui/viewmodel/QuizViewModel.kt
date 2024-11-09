package com.example.student_study_app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.student_study_app.API.RetrofitInstance
import com.example.student_study_app.models.QuizAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizViewModel: ViewModel() {
    private val _quizs = MutableStateFlow<List<QuizAPI>>(emptyList())
    val quizs:StateFlow<List<QuizAPI>> = _quizs.asStateFlow()
    fun FetchQuizs(){//function to fetch products to be displayed
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.GetQuiz()
                if(response.isSuccessful){
                    response.body()?.let { quizlist->_quizs.value = quizlist }
                }
            }catch (e: Exception){

            }

        }

    }
}