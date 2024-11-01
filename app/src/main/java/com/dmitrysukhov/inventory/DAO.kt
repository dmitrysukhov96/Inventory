package com.dmitrysukhov.inventory

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Query("SELECT * FROM items WHERE id = :id")
    suspend fun getItemById(id: Int): Item?

    @Query("SELECT * FROM items")
    fun getAllItems(): Flow<List<Item>>

    @Query("DELETE FROM items WHERE id = :id")
    suspend fun deleteById(id: Long)
}