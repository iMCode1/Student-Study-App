package com.studyappdatabase.database.repository

import com.studyappdatabase.database.AppDatabase
import com.studyappdatabase.database.entities.Flashcard
import javax.inject.Inject

interface IFlashcardRepository {
    suspend fun getFlashcardById(id: String): Flashcard
    suspend fun addFlashcard(flashcard: Flashcard)
    suspend fun getAllFlashcards(): List<Flashcard>
    suspend fun updateFlashcard(flashcard: Flashcard)
    suspend fun deleteFlashcardById(id: String)
    suspend fun searchFlashcards(query: String): List<Flashcard>
    suspend fun getFlashcardsByModule(moduleId: String): List<Flashcard>
    suspend fun flashcardExists(id: String): Boolean
}

class FlashcardRepository @Inject constructor(
    private val database: AppDatabase
) : IFlashcardRepository {

    override suspend fun getFlashcardById(id: String): Flashcard {
        return database.flashcardDao().getFlashcardById(id) ?: throw NoSuchElementException("Flashcard not found")
    }

    override suspend fun addFlashcard(flashcard: Flashcard) {
        database.flashcardDao().insertFlashcard(flashcard)
    }

    override suspend fun getAllFlashcards(): List<Flashcard> {
        return database.flashcardDao().getAllFlashcards()
    }

    override suspend fun updateFlashcard(flashcard: Flashcard) {
        database.flashcardDao().updateFlashcard(flashcard)
    }

    override suspend fun deleteFlashcardById(id: String) {
        database.flashcardDao().deleteFlashcardById(id)
    }

    override suspend fun searchFlashcards(query: String): List<Flashcard> {
        return database.flashcardDao().searchFlashcards(query)
    }

    override suspend fun getFlashcardsByModule(moduleId: String): List<Flashcard> {
        return database.flashcardDao().getFlashcardsByModule(moduleId)
    }

    override suspend fun flashcardExists(id: String): Boolean {
        return database.flashcardDao().flashcardExists(id)
    }
}