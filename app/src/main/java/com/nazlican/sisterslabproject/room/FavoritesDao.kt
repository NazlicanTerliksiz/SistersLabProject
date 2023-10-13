package com.nazlican.sisterslabproject.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nazlican.sisterslabproject.data.model.ProductX

@Dao
interface FavoritesDao {
    @Query("SELECT * FROM favorites")
    suspend fun getFavorites() : List<ProductX>

    @Insert
    suspend fun addToFavorite(productX: ProductX)

    @Query("DELETE FROM favorites WHERE id = :id")
    suspend fun deleteFromFavorites(id: Int)
}