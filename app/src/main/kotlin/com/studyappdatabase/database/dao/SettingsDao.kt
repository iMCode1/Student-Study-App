package com.studyappdatabase.database.dao

import androidx.room.*
import com.studyappdatabase.database.entities.Settings // Import the Module entity

@Dao
interface SettingsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateSettings(settings: Settings)

    @Query("SELECT * FROM settings_table WHERE userProfileID = :userProfileID")
    suspend fun getSettingsByUserId(userProfileID: Int): Settings?

    @Update
    suspend fun updateSettings(settings: Settings)

    @Delete
    suspend fun deleteSettings(settings: Settings)
}
