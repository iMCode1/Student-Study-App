package com.studyappdatabase.database.dao

import androidx.room.*
import com.studyappdatabase.database.entities.Flashcard

@Dao
interface FlashcardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlashcard(flashcard: Flashcard)

    @Query("SELECT * FROM flashcard_table WHERE flashcardID = :id")
    suspend fun getFlashcardById(id: String): Flashcard?

    @Query("SELECT * FROM flashcard_table")
    suspend fun getAllFlashcards(): List<Flashcard>

    @Update
    suspend fun updateFlashcard(flashcard: Flashcard)

    @Query("DELETE FROM flashcard_table WHERE flashcardID = :id")
    suspend fun deleteFlashcardById(id: String)

    @Query("SELECT * FROM flashcard_table WHERE title LIKE :query OR content LIKE :query")
    suspend fun searchFlashcards(query: String): List<Flashcard> {
        return searchFlashcards("%$query%")
    }

    @Query("SELECT * FROM flashcard_table WHERE moduleID = :moduleId")
    suspend fun getFlashcardsByModule(moduleId: String): List<Flashcard>

    @Query("SELECT EXISTS(SELECT 1 FROM flashcard_table WHERE flashcardID = :id)")
    suspend fun flashcardExists(id: String): Boolean
}
