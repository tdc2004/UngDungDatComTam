package com.nhom2_kot104.ungdungdatcomtam.repositotry

import com.nhom2_kot104.ungdungdatcomtam.dao.UserDao
import com.nhom2_kot104.ungdungdatcomtam.model.UserAccount

class UserRepository (val userDao: UserDao){
    suspend fun register(userAccount: UserAccount) = userDao.register(userAccount)

    suspend fun login(username: String, password: String): UserAccount? = userDao.login(username, password)
}