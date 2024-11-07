package com.studyappdatabase.database.dao

import androidx.room.*
import com.studyappdatabase.database.entities.User // Import the User entity

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user_profile_table WHERE userProfileID = :id")
    suspend fun getUserById(id: Int): User?

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}
