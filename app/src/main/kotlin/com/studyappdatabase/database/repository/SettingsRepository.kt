package com.studyappdatabase.database.repository

import com.studyappdatabase.database.AppDatabase
import com.studyappdatabase.database.entities.Settings
import javax.inject.Inject

// Define repository interface
interface ISettingsRepository {
    suspend fun insertOrUpdateSettings(settings: Settings)
    suspend fun getSettingsByUserId(userProfileID: Int): Settings?
    suspend fun updateSettings(settings: Settings)
    suspend fun deleteSettings(settings: Settings)
}

class SettingsRepository @Inject constructor(
    private val database: AppDatabase
) : ISettingsRepository {  // Implements the interface

    override suspend fun insertOrUpdateSettings(settings: Settings) {
        database.settingsDao().insertOrUpdateSettings(settings)
    }

    override suspend fun getSettingsByUserId(userProfileID: Int): Settings? {
        return database.settingsDao().getSettingsByUserId(userProfileID)
    }

    override suspend fun updateSettings(settings: Settings) {
        database.settingsDao().updateSettings(settings)
    }

    override suspend fun deleteSettings(settings: Settings) {
        database.settingsDao().deleteSettings(settings)
    }
}