package com.studyappdatabase.database.dao

import androidx.room.*
import com.studyappdatabase.database.entities.Progress

@Dao
interface ProgressDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateProgress(progress: Progress)

    @Query("SELECT * FROM progress_table WHERE userProfileID = :userProfileID AND moduleID = :moduleID")
    suspend fun getProgressByUserAndModule(userProfileID: Int, moduleID: Int): Progress?

    @Query("SELECT * FROM progress_table WHERE userProfileID = :userProfileID")
    suspend fun getAllProgressByUserId(userProfileID: Int): List<Progress>

    @Update
    suspend fun updateProgress(progress: Progress)

    @Delete
    suspend fun deleteProgress(progress: Progress)
}

