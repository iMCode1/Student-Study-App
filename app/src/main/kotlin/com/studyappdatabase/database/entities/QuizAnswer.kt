package com.studyappdatabase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "quiz_answer_table",
    foreignKeys = [
        ForeignKey(
            entity = QuizQuestion::class,
            parentColumns = ["questionID"],
            childColumns = ["questionID"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class QuizAnswer(
    @PrimaryKey(autoGenerate = true) val answerID: Int = 0,
    val questionID: Int,
    val answerText: String,
    val iCorrect: Boolean = false
)