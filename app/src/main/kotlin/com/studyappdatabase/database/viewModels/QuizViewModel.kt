package com.studyappdatabase.database.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studyappdatabase.database.entities.Quiz
import com.studyappdatabase.database.repository.IQuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val quizRepository: IQuizRepository  // Inject the interface
) : ViewModel() {

    // Insert a quiz
    fun insertQuiz(quiz: Quiz) {
        viewModelScope.launch(Dispatchers.IO) {
            quizRepository.insertQuiz(quiz)
        }
    }

    // Get quiz by ID
    fun getQuizById(id: Int, onResult: (Quiz?) -> Unit) {
        viewModelScope.launch {
            val quiz = withContext(Dispatchers.IO) {
                quizRepository.getQuizById(id)
            }
            onResult(quiz)
        }
    }

    // Get all quizzes
    fun getAllQuizzes(onResult: (List<Quiz>) -> Unit) {
        viewModelScope.launch {
            val quizzes = withContext(Dispatchers.IO) {
                quizRepository.getAllQuizzes()
            }
            onResult(quizzes)
        }
    }

    // Update a quiz
    fun updateQuiz(quiz: Quiz) {
        viewModelScope.launch(Dispatchers.IO) {
            quizRepository.updateQuiz(quiz)
        }
    }

    // Delete a quiz
    fun deleteQuiz(quiz: Quiz) {
        viewModelScope.launch(Dispatchers.IO) {
            quizRepository.deleteQuiz(quiz)
        }
    }
}

