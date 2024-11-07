package com.studyappdatabase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "module_table")
data class Module(
    @PrimaryKey(autoGenerate = true) val moduleID: Int = 0,
    val moduleName: String,
    val moduleCode: String,
    val description: String?
)
