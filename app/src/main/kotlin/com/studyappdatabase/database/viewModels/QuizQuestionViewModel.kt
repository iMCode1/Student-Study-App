package com.studyappdatabase.database.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studyappdatabase.database.entities.QuizQuestion
import com.studyappdatabase.database.repository.IQuizQuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class QuizQuestionViewModel @Inject constructor(
    private val quizQuestionRepository: IQuizQuestionRepository  // Inject the interface
) : ViewModel() {

    // Insert a quiz question
    fun insertQuestion(question: QuizQuestion) {
        viewModelScope.launch(Dispatchers.IO) {
            quizQuestionRepository.insertQuestion(question)
        }
    }

    // Get questions by quiz ID
    fun getQuestionsByQuizID(quizID: Int, onResult: (List<QuizQuestion>) -> Unit) {
        viewModelScope.launch {
            val questions = withContext(Dispatchers.IO) {
                quizQuestionRepository.getQuestionsByQuizID(quizID)
            }
            onResult(questions)
        }
    }

    // Update a quiz question
    fun updateQuestion(question: QuizQuestion) {
        viewModelScope.launch(Dispatchers.IO) {
            quizQuestionRepository.updateQuestion(question)
        }
    }

    // Delete a quiz question
    fun deleteQuestion(question: QuizQuestion) {
        viewModelScope.launch(Dispatchers.IO) {
            quizQuestionRepository.deleteQuestion(question)
        }
    }
}
