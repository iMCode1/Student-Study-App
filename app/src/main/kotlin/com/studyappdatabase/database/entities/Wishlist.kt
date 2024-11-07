package com.studyappdatabase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "wishlist_table",
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
data class Wishlist(
    @PrimaryKey(autoGenerate = true) val wishlistID: Int = 0,
    val userProfileID: Int,   //Foreign key referencing Module
    val moduleID: Int,
    val quizServerID: String? = null
)
