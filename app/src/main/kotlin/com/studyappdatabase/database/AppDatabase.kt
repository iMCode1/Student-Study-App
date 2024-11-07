package com.studyappdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.studyappdatabase.database.dao.FlashcardDao
import com.studyappdatabase.database.dao.ModuleDao
import com.studyappdatabase.database.dao.ProgressDao
import com.studyappdatabase.database.dao.QuizAnswerDao
import com.studyappdatabase.database.dao.QuizAttemptDao
import com.studyappdatabase.database.dao.QuizDao
import com.studyappdatabase.database.dao.QuizQuestionDao
import com.studyappdatabase.database.dao.SettingsDao
import com.studyappdatabase.database.dao.UserDao
import com.studyappdatabase.database.dao.WishlistDao
import com.studyappdatabase.database.entities.Flashcard
import com.studyappdatabase.database.entities.Module
import com.studyappdatabase.database.entities.Progress
import com.studyappdatabase.database.entities.Quiz
import com.studyappdatabase.database.entities.QuizAnswer
import com.studyappdatabase.database.entities.QuizAttempt
import com.studyappdatabase.database.entities.QuizQuestion
import com.studyappdatabase.database.entities.Settings
import com.studyappdatabase.database.entities.User
import com.studyappdatabase.database.entities.Wishlist

@Database(
    entities = [
        User::class, Module::class, Flashcard::class, Quiz::class,
        QuizAnswer::class, QuizAttempt::class, QuizQuestion::class,
        Wishlist::class, Progress::class, Settings::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun moduleDao(): ModuleDao
    abstract fun flashcardDao(): FlashcardDao
    abstract fun quizDao(): QuizDao
    abstract fun quizAnswerDao(): QuizAnswerDao
    abstract fun quizAttemptDao(): QuizAttemptDao
    abstract fun quizQuestionDao(): QuizQuestionDao
    abstract fun wishlistDao(): WishlistDao
    abstract fun progressDao(): ProgressDao
    abstract fun settingsDao(): SettingsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "studyappdatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
