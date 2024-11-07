package com.studyappdatabase.database.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studyappdatabase.database.entities.Flashcard
import com.studyappdatabase.database.repository.IFlashcardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FlashcardViewModel @Inject constructor(
    private val flashcardRepository: IFlashcardRepository
) : ViewModel() {

    // Fetch a flashcard by ID
    fun getFlashcardById(id: String, onResult: (Flashcard?) -> Unit) {
        viewModelScope.launch {
            val flashcard = withContext(Dispatchers.IO) {
                try {
                    flashcardRepository.getFlashcardById(id)
                } catch (e: Exception) {
                    null
                }
            }
            onResult(flashcard)
        }
    }

    // Add a new flashcard
    fun addFlashcard(flashcard: Flashcard) {
        viewModelScope.launch(Dispatchers.IO) {
            flashcardRepository.addFlashcard(flashcard)
        }
    }

    // Get all flashcards
    fun getAllFlashcards(onResult: (List<Flashcard>) -> Unit) {
        viewModelScope.launch {
            val flashcards = withContext(Dispatchers.IO) {
                flashcardRepository.getAllFlashcards()
            }
            onResult(flashcards)
        }
    }

    // Update an existing flashcard
    fun updateFlashcard(flashcard: Flashcard) {
        viewModelScope.launch(Dispatchers.IO) {
            flashcardRepository.updateFlashcard(flashcard)
        }
    }

    // Delete a flashcard by ID
    fun deleteFlashcardById(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            flashcardRepository.deleteFlashcardById(id)
        }
    }

    // Search flashcards by a query
    fun searchFlashcards(query: String, onResult: (List<Flashcard>) -> Unit) {
        viewModelScope.launch {
            val flashcards = withContext(Dispatchers.IO) {
                flashcardRepository.searchFlashcards(query)
            }
            onResult(flashcards)
        }
    }

    // Get flashcards by module ID
    fun getFlashcardsByModule(moduleId: String, onResult: (List<Flashcard>) -> Unit) {
        viewModelScope.launch {
            val flashcards = withContext(Dispatchers.IO) {
                flashcardRepository.getFlashcardsByModule(moduleId)
            }
            onResult(flashcards)
        }
    }

    // Check if a flashcard exists by ID
    fun flashcardExists(id: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val exists = withContext(Dispatchers.IO) {
                flashcardRepository.flashcardExists(id)
            }
            onResult(exists)
        }
    }
}
