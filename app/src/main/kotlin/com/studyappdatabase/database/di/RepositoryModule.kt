package com.studyappdatabase.database.di

import com.studyappdatabase.database.AppDatabase
import com.studyappdatabase.database.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    // Provide IFlashcardRepository implementation
    @Provides
    fun provideFlashcardRepository(database: AppDatabase): IFlashcardRepository {
        return FlashcardRepository(database)
    }

    // Provide IModuleRepository implementation
    @Provides
    fun provideModuleRepository(database: AppDatabase): IModuleRepository {
        return ModuleRepository(database)
    }

    // Provide IProgressRepository implementation
    @Provides
    fun provideProgressRepository(database: AppDatabase): IProgressRepository {
        return ProgressRepository(database)
    }

    // Provide IQuizAnswerRepository implementation
    @Provides
    fun provideQuizAnswerRepository(database: AppDatabase): IQuizAnswerRepository {
        return QuizAnswerRepository(database)
    }

    // Provide IQuizAttemptRepository implementation
    @Provides
    fun provideQuizAttemptRepository(database: AppDatabase): IQuizAttemptRepository {
        return QuizAttemptRepository(database)
    }

    // Provide IQuizQuestionRepository implementation
    @Provides
    fun provideQuizQuestionRepository(database: AppDatabase): IQuizQuestionRepository {
        return QuizQuestionRepository(database)
    }

    // Provide IQuizRepository implementation
    @Provides
    fun provideQuizRepository(database: AppDatabase): IQuizRepository {
        return QuizRepository(database)
    }

    // Provide ISettingsRepository implementation
    @Provides
    fun provideSettingsRepository(database: AppDatabase): ISettingsRepository {
        return SettingsRepository(database)
    }

    // Provide IUserRepository implementation
    @Provides
    fun provideUserRepository(database: AppDatabase): IUserRepository {
        return UserRepository(database)
    }

    // Provide IWishlistRepository implementation
    @Provides
    fun provideWishlistRepository(database: AppDatabase): IWishlistRepository {
        return WishlistRepository(database)
    }
}
