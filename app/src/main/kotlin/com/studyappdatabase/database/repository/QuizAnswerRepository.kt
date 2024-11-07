package com.studyappdatabase.database.repository

import com.studyappdatabase.database.AppDatabase
import com.studyappdatabase.database.entities.QuizAnswer
import javax.inject.Inject

// Define repository interface
interface IQuizAnswerRepository {
    suspend fun insertAnswer(answer: QuizAnswer)
    suspend fun getAnswersByQuestionID(questionID: Int): List<QuizAnswer>
    suspend fun updateAnswer(answer: QuizAnswer)
    suspend fun deleteAnswer(answer: QuizAnswer)
}

class QuizAnswerRepository @Inject constructor(
    private val database: AppDatabase
) : IQuizAnswerRepository {

    override suspend fun insertAnswer(answer: QuizAnswer) {
        database.quizAnswerDao().insertAnswer(answer)
    }

    override suspend fun getAnswersByQuestionID(questionID: Int): List<QuizAnswer> {
        return database.quizAnswerDao().getAnswersByQuestionID(questionID)
    }

    override suspend fun updateAnswer(answer: QuizAnswer) {
        database.quizAnswerDao().updateAnswer(answer)
    }

    override suspend fun deleteAnswer(answer: QuizAnswer) {
        database.quizAnswerDao().deleteAnswer(answer)
    }
}