package com.nhom2_kot104.ungdungdatcomtam.model

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@Entity(tableName = "Dish")
class Dish (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var uid: Int? = 0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "price") var price: Double,
    @ColumnInfo(name = "image") var image: String,
    @ColumnInfo(name = "category_id") var categoryId: Int
)
