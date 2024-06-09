package com.nhom2_kot104.ungdungdatcomtam.model

import androidx.room.ColumnInfo
import  androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class UserAccount (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int? = 0,
    @ColumnInfo(name = "fullName")
    val fullName : String? ,
    @ColumnInfo(name = "username")
    var username : String ,
    @ColumnInfo(name = "password")
    var password : String ,
    @ColumnInfo(name = "role")
    var role : Int
){
}