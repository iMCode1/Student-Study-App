package com.studyappdatabase.database.repository

import com.studyappdatabase.database.AppDatabase
import com.studyappdatabase.database.entities.Module
import javax.inject.Inject

// Define repository interface
interface IModuleRepository {
    suspend fun insertModule(module: Module)
    suspend fun getModuleById(id: Int): Module?
    suspend fun getAllModules(): List<Module>
    suspend fun updateModule(module: Module)
    suspend fun deleteModule(module: Module)
}

class ModuleRepository @Inject constructor(
    private val database: AppDatabase
) : IModuleRepository {  // Implements the interface

    override suspend fun insertModule(module: Module) {
        database.moduleDao().insertModule(module)
    }

    override suspend fun getModuleById(id: Int): Module? {
        return database.moduleDao().getModuleById(id)
    }

    override suspend fun getAllModules(): List<Module> {
        return database.moduleDao().getAllModules()
    }

    override suspend fun updateModule(module: Module) {
        database.moduleDao().updateModule(module)
    }

    override suspend fun deleteModule(module: Module) {
        database.moduleDao().deleteModule(module)
    }
}