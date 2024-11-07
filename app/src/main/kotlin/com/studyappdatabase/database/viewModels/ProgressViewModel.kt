package com.studyappdatabase.database.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studyappdatabase.database.entities.Progress
import com.studyappdatabase.database.repository.IProgressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProgressViewModel @Inject constructor(
    private val progressRepository: IProgressRepository
) : ViewModel() {

    // Insert or update progress
    fun insertOrUpdateProgress(progress: Progress) {
        viewModelScope.launch(Dispatchers.IO) {
            progressRepository.insertOrUpdateProgress(progress)
        }
    }

    // Get progress by user and module
    fun getProgressByUserAndModule(userProfileID: Int, moduleID: Int, onResult: (Progress?) -> Unit) {
        viewModelScope.launch {
            val progress = withContext(Dispatchers.IO) {
                try {
                    progressRepository.getProgressByUserAndModule(userProfileID, moduleID)
                } catch (e: Exception) {
                    null
                }
            }
            onResult(progress)
        }
    }

    // Get all progress by user ID
    fun getAllProgressByUserId(userProfileID: Int, onResult: (List<Progress>) -> Unit) {
        viewModelScope.launch {
            val progressList = withContext(Dispatchers.IO) {
                progressRepository.getAllProgressByUserId(userProfileID)
            }
            onResult(progressList)
        }
    }

    // Update progress
    fun updateProgress(progress: Progress) {
        viewModelScope.launch(Dispatchers.IO) {
            progressRepository.updateProgress(progress)
        }
    }

    // Delete progress
    fun deleteProgress(progress: Progress) {
        viewModelScope.launch(Dispatchers.IO) {
            progressRepository.deleteProgress(progress)
        }
    }
}
