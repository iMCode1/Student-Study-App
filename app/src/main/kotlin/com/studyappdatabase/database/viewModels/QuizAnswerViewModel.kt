package com.studyappdatabase.database.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studyappdatabase.database.entities.QuizAnswer
import com.studyappdatabase.database.repository.IQuizAnswerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class QuizAnswerViewModel @Inject constructor(
    private val quizAnswerRepository: IQuizAnswerRepository
) : ViewModel() {

    // Insert a quiz answer
    fun insertAnswer(answer: QuizAnswer) {
        viewModelScope.launch(Dispatchers.IO) {
            quizAnswerRepository.insertAnswer(answer)
        }
    }

    // Get answers by question ID
    fun getAnswersByQuestionID(questionID: Int, onResult: (List<QuizAnswer>) -> Unit) {
        viewModelScope.launch {
            val answers = withContext(Dispatchers.IO) {
                quizAnswerRepository.getAnswersByQuestionID(questionID)
            }
            onResult(answers)
        }
    }

    // Update a quiz answer
    fun updateAnswer(answer: QuizAnswer) {
        viewModelScope.launch(Dispatchers.IO) {
            quizAnswerRepository.updateAnswer(answer)
        }
    }

    // Delete a quiz answer
    fun deleteAnswer(answer: QuizAnswer) {
        viewModelScope.launch(Dispatchers.IO) {
            quizAnswerRepository.deleteAnswer(answer)
        }
    }
}
