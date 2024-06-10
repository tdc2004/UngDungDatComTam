package com.nhom2_kot104.ungdungdatcomtam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "category")
data class Category(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var uid: Int? = 0,
    val name: String
)