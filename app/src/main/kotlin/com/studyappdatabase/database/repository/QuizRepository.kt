package com.studyappdatabase.database.repository

import com.studyappdatabase.database.AppDatabase
import com.studyappdatabase.database.entities.Quiz
import javax.inject.Inject

// Define repository interface
interface IQuizRepository {
    suspend fun insertQuiz(quiz: Quiz)
    suspend fun getQuizById(id: Int): Quiz?
    suspend fun getAllQuizzes(): List<Quiz>
    suspend fun updateQuiz(quiz: Quiz)
    suspend fun deleteQuiz(quiz: Quiz)
}

class QuizRepository @Inject constructor(
    private val database: AppDatabase
) : IQuizRepository {

    override suspend fun insertQuiz(quiz: Quiz) {
        database.quizDao().insertQuiz(quiz)
    }

    override suspend fun getQuizById(id: Int): Quiz? {
        return database.quizDao().getQuizById(id)
    }

    override suspend fun getAllQuizzes(): List<Quiz> {
        return database.quizDao().getAllQuizzes()
    }

    override suspend fun updateQuiz(quiz: Quiz) {
        database.quizDao().updateQuiz(quiz)
    }

    override suspend fun deleteQuiz(quiz: Quiz) {
        database.quizDao().deleteQuiz(quiz)
    }
}