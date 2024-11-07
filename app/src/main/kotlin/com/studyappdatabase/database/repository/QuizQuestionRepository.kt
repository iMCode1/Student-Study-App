package com.studyappdatabase.database.repository

import com.studyappdatabase.database.AppDatabase
import com.studyappdatabase.database.entities.QuizQuestion
import javax.inject.Inject

// Define repository interface
interface IQuizQuestionRepository {
    suspend fun insertQuestion(question: QuizQuestion)
    suspend fun getQuestionsByQuizID(quizID: Int): List<QuizQuestion>
    suspend fun updateQuestion(question: QuizQuestion)
    suspend fun deleteQuestion(question: QuizQuestion)
}

class QuizQuestionRepository @Inject constructor(
    private val database: AppDatabase
) : IQuizQuestionRepository {

    override suspend fun insertQuestion(question: QuizQuestion) {
        database.quizQuestionDao().insertQuestion(question)
    }

    override suspend fun getQuestionsByQuizID(quizID: Int): List<QuizQuestion> {
        return database.quizQuestionDao().getQuestionsByQuizID(quizID)
    }

    override suspend fun updateQuestion(question: QuizQuestion) {
        database.quizQuestionDao().updateQuestion(question)
    }

    override suspend fun deleteQuestion(question: QuizQuestion) {
        database.quizQuestionDao().deleteQuestion(question)
    }
}