package com.studyappdatabase.database.entities

import android.provider.ContactsContract.Profile
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "quiz_attempt_table",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userProfileID"],
            childColumns = ["userProfileID"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Quiz::class,
            parentColumns = ["quizID"],
            childColumns = ["quizID"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class QuizAttempt(
    @PrimaryKey(autoGenerate = true) val attemptID: Int = 0,
    val userProfileID: Int,                  // Foreign key referencing User
    val quizID: Int,                  // Foreign key referencing Quiz
    val score: Int,
    val dateAttempted: Long = System.currentTimeMillis(),
    val totalQuestionsAttempted: Int,
    val correctAnswers: Int
)
