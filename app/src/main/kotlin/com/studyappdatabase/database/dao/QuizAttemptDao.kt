package com.studyappdatabase.database.dao

import androidx.room.*
import com.studyappdatabase.database.entities.QuizAttempt // Import the Module entity

@Dao
interface QuizAttemptDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttempt(attempt: QuizAttempt)

    @Query("SELECT * FROM quiz_attempt_table WHERE userProfileID = :userProfileID AND quizID = :quizID")
    suspend fun getAttemptsByUserAndQuiz(userProfileID: Int, quizID: Int): List<QuizAttempt>

    @Query("SELECT * FROM quiz_attempt_table WHERE userProfileID = :userProfileID")
    suspend fun getAllAttemptsByUser(userProfileID: Int): List<QuizAttempt>

    @Delete
    suspend fun deleteAttempt(attempt: QuizAttempt)
}

