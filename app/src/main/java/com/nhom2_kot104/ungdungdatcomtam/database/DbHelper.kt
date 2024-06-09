package com.nhom2_kot104.ungdungdatcomtam.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nhom2_kot104.ungdungdatcomtam.dao.UserDao
import com.nhom2_kot104.ungdungdatcomtam.model.UserAccount

@Database(entities = [UserAccount::class], version = 1)
abstract class DbHelper : RoomDatabase(){
    abstract fun  getUserDao() : UserDao

    companion object{
        @Volatile

        private var instance : DbHelper? = null
        fun getInstance(context: Context) : DbHelper {
            if(instance == null){
                instance = Room.databaseBuilder(context,DbHelper::class.java,"DbHelper").build()
            }
            return instance!!
        }
    }
}