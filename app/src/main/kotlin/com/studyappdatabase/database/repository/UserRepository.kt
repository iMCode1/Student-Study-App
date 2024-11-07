package com.studyappdatabase.database.repository

import com.studyappdatabase.database.AppDatabase
import com.studyappdatabase.database.entities.User
import javax.inject.Inject

// Define repository interface
interface IUserRepository {
    suspend fun insertUser(user: User)
    suspend fun getUserById(id: Int): User?
    suspend fun updateUser(user: User)
    suspend fun deleteUser(user: User)
}

class UserRepository @Inject constructor(
    private val database: AppDatabase
) : IUserRepository {

    override suspend fun insertUser(user: User) {
        database.userDao().insertUser(user)
    }

    override suspend fun getUserById(id: Int): User? {
        return database.userDao().getUserById(id)
    }

    override suspend fun updateUser(user: User) {
        database.userDao().updateUser(user)
    }

    override suspend fun deleteUser(user: User) {
        database.userDao().deleteUser(user)
    }
}