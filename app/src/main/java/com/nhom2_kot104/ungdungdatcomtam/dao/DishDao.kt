package com.nhom2_kot104.ungdungdatcomtam.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nhom2_kot104.ungdungdatcomtam.model.Dish

@Dao
interface DishDao {
    @Query("SELECT * FROM Dish")
    fun getAllDishes(): LiveData<List<Dish>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dish: Dish)
    @Update
    suspend fun update(dish: Dish)

    @Delete
    suspend fun delete(dish: Dish)
    @Query("SELECT * FROM Dish WHERE id = :dishID")
    suspend fun getDish(dishID: Int): Dish?

}