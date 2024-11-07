package com.studyappdatabase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "flashcard_table",
    foreignKeys = [
        ForeignKey(
            entity = Module::class,
            parentColumns = ["moduleID"],
            childColumns = ["moduleID"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Flashcard(
    @PrimaryKey(autoGenerate = true) val flashcardID: Int = 0,
    val title: String,
    val content: String,
    val description: String?,
    val quizServerID: String? = null,
    val moduleID: Int   //Foreign key referencing Module
)
