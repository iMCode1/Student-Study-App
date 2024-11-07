package com.studyappdatabase.database.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studyappdatabase.database.entities.Settings
import com.studyappdatabase.database.repository.ISettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsRepository: ISettingsRepository  // Inject the interface
) : ViewModel() {

    // Insert or update settings
    fun insertOrUpdateSettings(settings: Settings) {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.insertOrUpdateSettings(settings)
        }
    }

    // Get settings by user ID
    fun getSettingsByUserId(userProfileID: Int, onResult: (Settings?) -> Unit) {
        viewModelScope.launch {
            val settings = withContext(Dispatchers.IO) {
                settingsRepository.getSettingsByUserId(userProfileID)
            }
            onResult(settings)
        }
    }

    // Update settings
    fun updateSettings(settings: Settings) {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.updateSettings(settings)
        }
    }

    // Delete settings
    fun deleteSettings(settings: Settings) {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.deleteSettings(settings)
        }
    }
}
