package com.studyappdatabase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "settings_table",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userProfileID"],
            childColumns = ["userProfileID"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Settings(
    @PrimaryKey(autoGenerate = true) val settingID: Int = 0,
    val userProfileID: Int,                  // Foreign key referencing User
    val theme: String,
    val notificationEnabled: Boolean = true,
    val language: String
)
