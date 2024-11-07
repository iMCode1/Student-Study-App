package com.studyappdatabase.database.repository

import com.studyappdatabase.database.AppDatabase
import com.studyappdatabase.database.entities.QuizAttempt
import javax.inject.Inject

// Define repository interface
interface IQuizAttemptRepository {
    suspend fun insertAttempt(attempt: QuizAttempt)
    suspend fun getAttemptsByUserAndQuiz(userProfileID: Int, quizID: Int): List<QuizAttempt>
    suspend fun getAllAttemptsByUser(userProfileID: Int): List<QuizAttempt>
    suspend fun deleteAttempt(attempt: QuizAttempt)
}

class QuizAttemptRepository @Inject constructor(
    private val database: AppDatabase
) : IQuizAttemptRepository {

    override suspend fun insertAttempt(attempt: QuizAttempt) {
        database.quizAttemptDao().insertAttempt(attempt)
    }

    override suspend fun getAttemptsByUserAndQuiz(userProfileID: Int, quizID: Int): List<QuizAttempt> {
        return database.quizAttemptDao().getAttemptsByUserAndQuiz(userProfileID, quizID)
    }

    override suspend fun getAllAttemptsByUser(userProfileID: Int): List<QuizAttempt> {
        return database.quizAttemptDao().getAllAttemptsByUser(userProfileID)
    }

    override suspend fun deleteAttempt(attempt: QuizAttempt) {
        database.quizAttemptDao().deleteAttempt(attempt)
    }
}