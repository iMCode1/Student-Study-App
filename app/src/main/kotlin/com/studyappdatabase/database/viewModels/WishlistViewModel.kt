package com.studyappdatabase.database.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studyappdatabase.database.entities.Wishlist
import com.studyappdatabase.database.repository.IWishlistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class WishlistViewModel @Inject constructor(
    private val wishlistRepository: IWishlistRepository
) : ViewModel() {

    // Insert a new wishlist item
    fun insertWishlistItem(wishlist: Wishlist) {
        viewModelScope.launch(Dispatchers.IO) {
            wishlistRepository.insertWishlistItem(wishlist)
        }
    }

    // Get wishlist by user ID
    fun getWishlistByUserId(userId: Int, onResult: (List<Wishlist>) -> Unit) {
        viewModelScope.launch {
            val wishlistItems = withContext(Dispatchers.IO) {
                wishlistRepository.getWishlistByUserId(userId)
            }
            onResult(wishlistItems)
        }
    }

    // Get wishlist by user and module ID
    fun getWishlistByUserAndModule(userId: Int, moduleId: Int, onResult: (List<Wishlist>) -> Unit) {
        viewModelScope.launch {
            val wishlistItems = withContext(Dispatchers.IO) {
                wishlistRepository.getWishlistByUserAndModule(userId, moduleId)
            }
            onResult(wishlistItems)
        }
    }

    // Get wishlist by module ID
    fun getWishlistByModuleId(moduleId: Int, onResult: (List<Wishlist>) -> Unit) {
        viewModelScope.launch {
            val wishlistItems = withContext(Dispatchers.IO) {
                wishlistRepository.getWishlistByModuleId(moduleId)
            }
            onResult(wishlistItems)
        }
    }

    // Update an existing wishlist item
    fun updateWishlistItem(wishlist: Wishlist) {
        viewModelScope.launch(Dispatchers.IO) {
            wishlistRepository.updateWishlistItem(wishlist)
        }
    }

    // Delete a wishlist item
    fun deleteWishlistItem(wishlist: Wishlist) {
        viewModelScope.launch(Dispatchers.IO) {
            wishlistRepository.deleteWishlistItem(wishlist)
        }
    }
}
