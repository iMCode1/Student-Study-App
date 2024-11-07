package com.studyappdatabase.database.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studyappdatabase.database.entities.Module
import com.studyappdatabase.database.repository.IModuleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ModuleViewModel @Inject constructor(
    private val moduleRepository: IModuleRepository
) : ViewModel() {

    // Insert a module
    fun insertModule(module: Module) {
        viewModelScope.launch(Dispatchers.IO) {
            moduleRepository.insertModule(module)
        }
    }

    // Get module by ID
    fun getModuleById(id: Int, onResult: (Module?) -> Unit) {
        viewModelScope.launch {
            val module = withContext(Dispatchers.IO) {
                try {
                    moduleRepository.getModuleById(id)
                } catch (e: Exception) {
                    null
                }
            }
            onResult(module)
        }
    }

    // Get all modules
    fun getAllModules(onResult: (List<Module>) -> Unit) {
        viewModelScope.launch {
            val modules = withContext(Dispatchers.IO) {
                moduleRepository.getAllModules()
            }
            onResult(modules)
        }
    }

    // Update module
    fun updateModule(module: Module) {
        viewModelScope.launch(Dispatchers.IO) {
            moduleRepository.updateModule(module)
        }
    }

    // Delete module
    fun deleteModule(module: Module) {
        viewModelScope.launch(Dispatchers.IO) {
            moduleRepository.deleteModule(module)
        }
    }
}
