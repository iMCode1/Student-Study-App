package com.studyappdatabase.database.dao

import androidx.room.*
import com.studyappdatabase.database.entities.Quiz // Import the Quiz entity

@Dao
interface QuizDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuiz(quiz: Quiz)

    @Query("SELECT * FROM quiz_table WHERE quizID = :id")
    suspend fun getQuizById(id: Int): Quiz?

    @Query("SELECT * FROM quiz_table")
    suspend fun getAllQuizzes(): List<Quiz>

    @Update
    suspend fun updateQuiz(quiz: Quiz)

    @Delete
    suspend fun deleteQuiz(quiz: Quiz)
}