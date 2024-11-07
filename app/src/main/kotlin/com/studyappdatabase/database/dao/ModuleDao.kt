package com.studyappdatabase.database.dao

import androidx.room.*
import com.studyappdatabase.database.entities.Module // Import the Module entity

@Dao
interface ModuleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModule(module: Module)

    @Query("SELECT * FROM module_table WHERE moduleID = :id")
    suspend fun getModuleById(id: Int): Module?

    @Query("SELECT * FROM module_table")
    suspend fun getAllModules(): List<Module>

    @Update
    suspend fun updateModule(module: Module)

    @Delete
    suspend fun deleteModule(module: Module)
}