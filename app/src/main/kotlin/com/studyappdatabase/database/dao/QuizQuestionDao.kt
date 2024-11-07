package com.studyappdatabase.database.dao

import androidx.room.*
import com.studyappdatabase.database.entities.QuizQuestion

@Dao
interface QuizQuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: QuizQuestion)

    @Query("SELECT * FROM quiz_question_table WHERE quizID = :quizID")
    suspend fun getQuestionsByQuizID(quizID: Int): List<QuizQuestion>

    @Update
    suspend fun updateQuestion (question: QuizQuestion)

    @Delete
    suspend fun deleteQuestion(question: QuizQuestion)
}


