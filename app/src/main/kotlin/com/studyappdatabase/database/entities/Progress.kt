package com.studyappdatabase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "progress_table",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userProfileID"],
            childColumns = ["userProfileID"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Module::class,
            parentColumns = ["moduleID"],
            childColumns = ["moduleID"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Progress(
    @PrimaryKey(autoGenerate = true) val progressID: Int = 0,
    val userProfileID: Int,                  // Foreign key referencing User
    val moduleID: Int,                  // Foreign key referencing Module
    val completedQuizzes: Int,
    val lastAccessed: Long = System.currentTimeMillis()
)
