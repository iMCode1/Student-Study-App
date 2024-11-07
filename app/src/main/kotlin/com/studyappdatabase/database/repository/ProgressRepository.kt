package com.studyappdatabase.database.repository

import com.studyappdatabase.database.AppDatabase
import com.studyappdatabase.database.entities.Progress
import javax.inject.Inject

// Define repository interface
interface IProgressRepository {
    suspend fun insertOrUpdateProgress(progress: Progress)
    suspend fun getProgressByUserAndModule(userProfileID: Int, moduleID: Int): Progress?
    suspend fun getAllProgressByUserId(userProfileID: Int): List<Progress>
    suspend fun updateProgress(progress: Progress)
    suspend fun deleteProgress(progress: Progress)
}

class ProgressRepository @Inject constructor(
    private val database: AppDatabase
) : IProgressRepository {

    override suspend fun insertOrUpdateProgress(progress: Progress) {
        database.progressDao().insertOrUpdateProgress(progress)
    }

    override suspend fun getProgressByUserAndModule(userProfileID: Int, moduleID: Int): Progress? {
        return database.progressDao().getProgressByUserAndModule(userProfileID, moduleID)
    }

    override suspend fun getAllProgressByUserId(userProfileID: Int): List<Progress> {
        return database.progressDao().getAllProgressByUserId(userProfileID)
    }

    override suspend fun updateProgress(progress: Progress) {
        database.progressDao().updateProgress(progress)
    }

    override suspend fun deleteProgress(progress: Progress) {
        database.progressDao().deleteProgress(progress)
    }
}