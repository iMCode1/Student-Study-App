package com.example.studyappdatabase

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.studyappdatabase.database.AppDatabase
import com.studyappdatabase.database.dao.UserDao
import org.junit.After
import org.junit.Before

import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class UserDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao

    @Before
    fun initDb() {
        // Initialize an in-memory database for unit testing
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        userDao = database.userDao() // Initialize the DAO
    }

    @After
    fun closeDb() {
        database.close() // Close the database after the tests
    }

}
