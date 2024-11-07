package com.studyappdatabase.database.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studyappdatabase.database.entities.User
import com.studyappdatabase.database.repository.IUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: IUserRepository  // Inject the interface
) : ViewModel() {

    // Insert a new user
    fun insertUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.insertUser(user)
        }
    }

    // Get a user by ID
    fun getUserById(id: Int, onResult: (User?) -> Unit) {
        viewModelScope.launch {
            val user = withContext(Dispatchers.IO) {
                userRepository.getUserById(id)
            }
            onResult(user)
        }
    }

    // Update an existing user
    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.updateUser(user)
        }
    }

    // Delete a user
    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.deleteUser(user)
        }
    }
}
