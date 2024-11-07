package com.studyappdatabase.database.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studyappdatabase.database.entities.QuizAttempt
import com.studyappdatabase.database.repository.IQuizAttemptRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class QuizAttemptViewModel @Inject constructor(
    private val quizAttemptRepository: IQuizAttemptRepository  // Inject the interface
) : ViewModel() {

    // Insert a quiz attempt
    fun insertAttempt(attempt: QuizAttempt) {
        viewModelScope.launch(Dispatchers.IO) {
            quizAttemptRepository.insertAttempt(attempt)
        }
    }

    // Get attempts by user and quiz
    fun getAttemptsByUserAndQuiz(userProfileID: Int, quizID: Int, onResult: (List<QuizAttempt>) -> Unit) {
        viewModelScope.launch {
            val attempts = withContext(Dispatchers.IO) {
                quizAttemptRepository.getAttemptsByUserAndQuiz(userProfileID, quizID)
            }
            onResult(attempts)
        }
    }

    // Get all attempts by user
    fun getAllAttemptsByUser(userProfileID: Int, onResult: (List<QuizAttempt>) -> Unit) {
        viewModelScope.launch {
            val attempts = withContext(Dispatchers.IO) {
                quizAttemptRepository.getAllAttemptsByUser(userProfileID)
            }
            onResult(attempts)
        }
    }

    // Delete a quiz attempt
    fun deleteAttempt(attempt: QuizAttempt) {
        viewModelScope.launch(Dispatchers.IO) {
            quizAttemptRepository.deleteAttempt(attempt)
        }
    }
}
