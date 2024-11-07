package com.studyappdatabase.database.dao

import androidx.room.*
import com.studyappdatabase.database.entities.Wishlist

@Dao
interface WishlistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWishlistItem(wishlist: Wishlist)

    @Query("SELECT * FROM wishlist_table WHERE userProfileID = :userId")
    suspend fun getWishlistByUserId(userId: Int): List<Wishlist>

    // Query to retrieve wishlist items by both userID and moduleID
    @Query("SELECT * FROM wishlist_table WHERE userProfileID = :userId AND moduleID = :moduleId")
    suspend fun getWishlistByUserAndModule(userId: Int, moduleId: Int): List<Wishlist>

    @Query("SELECT * FROM wishlist_table WHERE moduleID = :moduleId")
    suspend fun getWishlistByModuleId(moduleId: Int): List<Wishlist>

    @Update
    suspend fun updateWishlistItem(wishlist: Wishlist)

    @Delete
    suspend fun deleteWishlistItem(wishlist: Wishlist)
}