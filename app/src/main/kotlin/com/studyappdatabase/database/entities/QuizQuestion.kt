package com.studyappdatabase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "quiz_question_table",
    foreignKeys = [
        ForeignKey(
            entity = Quiz::class,
            parentColumns = ["quizID"],
            childColumns = ["quizID"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class QuizQuestion(
    @PrimaryKey(autoGenerate = true) val questionID: Int = 0,
    val quizID: Int,
    val questionText: String,
    val questionType: String,
    val isRequired: Boolean = true
)