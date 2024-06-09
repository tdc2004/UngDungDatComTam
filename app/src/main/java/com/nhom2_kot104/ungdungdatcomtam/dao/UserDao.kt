package com.nhom2_kot104.ungdungdatcomtam.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nhom2_kot104.ungdungdatcomtam.model.UserAccount

@Dao
interface UserDao {
    @Insert
    suspend fun register(userAccount: UserAccount)

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    suspend fun login(username: String, password: String): UserAccount?
}