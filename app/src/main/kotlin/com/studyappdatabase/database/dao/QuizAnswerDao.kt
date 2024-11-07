package com.studyappdatabase.database.dao

import androidx.room.*
import com.studyappdatabase.database.entities.QuizAnswer // Import the Module entity

@Dao
interface QuizAnswerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnswer(answer: QuizAnswer)

    @Query("SELECT * FROM quiz_answer_table WHERE questionID = :questionID")
    suspend fun getAnswersByQuestionID(questionID: Int): List<QuizAnswer>

    @Update
    suspend fun updateAnswer(answer: QuizAnswer)

    @Delete
    suspend fun deleteAnswer(answer: QuizAnswer)
}

