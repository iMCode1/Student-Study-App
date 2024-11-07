package com.studyappdatabase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile_table")
data class User(
    @PrimaryKey(autoGenerate = true) val userProfileID: Int = 0,
    val userServerID: Int,
    val username: String,
    val token: String,
    val email: String
)