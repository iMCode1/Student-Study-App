package com.studyappdatabase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz_table")
data class Quiz(
    @PrimaryKey(autoGenerate = true) val quizID: Int = 0,
    val title: String,
    val description: String? = null,
    val dateCreated: Long = System.currentTimeMillis(),
    val duration: Int, //Duration in minutes
    val totalQuestion: Int
)
