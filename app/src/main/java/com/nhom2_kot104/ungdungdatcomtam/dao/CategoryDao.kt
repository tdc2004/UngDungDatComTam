package com.nhom2_kot104.ungdungdatcomtam.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nhom2_kot104.ungdungdatcomtam.model.Category

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category")
    fun getAll(): LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: Category)
    @Update
    suspend fun update(category: Category)

    @Delete
    suspend fun delete(category: Category)
    @Query("SELECT * FROM category WHERE id = :categoryId")
    suspend fun getCategory(categoryId: Int): Category?

}