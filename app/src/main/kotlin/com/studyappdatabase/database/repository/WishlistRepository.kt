package com.studyappdatabase.database.repository

import com.studyappdatabase.database.AppDatabase
import com.studyappdatabase.database.entities.Wishlist
import javax.inject.Inject

// Define repository interface
interface IWishlistRepository {
    suspend fun insertWishlistItem(wishlist: Wishlist)
    suspend fun getWishlistByUserId(userId: Int): List<Wishlist>
    suspend fun getWishlistByUserAndModule(userId: Int, moduleId: Int): List<Wishlist>
    suspend fun getWishlistByModuleId(moduleId: Int): List<Wishlist>
    suspend fun updateWishlistItem(wishlist: Wishlist)
    suspend fun deleteWishlistItem(wishlist: Wishlist)
}

class WishlistRepository @Inject constructor(
    private val database: AppDatabase
) : IWishlistRepository {  // Implements the interface

    override suspend fun insertWishlistItem(wishlist: Wishlist) {
        database.wishlistDao().insertWishlistItem(wishlist)
    }

    override suspend fun getWishlistByUserId(userId: Int): List<Wishlist> {
        return database.wishlistDao().getWishlistByUserId(userId)
    }

    override suspend fun getWishlistByUserAndModule(userId: Int, moduleId: Int): List<Wishlist> {
        return database.wishlistDao().getWishlistByUserAndModule(userId, moduleId)
    }

    override suspend fun getWishlistByModuleId(moduleId: Int): List<Wishlist> {
        return database.wishlistDao().getWishlistByModuleId(moduleId)
    }

    override suspend fun updateWishlistItem(wishlist: Wishlist) {
        database.wishlistDao().updateWishlistItem(wishlist)
    }

    override suspend fun deleteWishlistItem(wishlist: Wishlist) {
        database.wishlistDao().deleteWishlistItem(wishlist)
    }
}