package com.nhom2_kot104.ungdungdatcomtam.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nhom2_kot104.ungdungdatcomtam.dao.CategoryDao
import com.nhom2_kot104.ungdungdatcomtam.dao.DishDao
import com.nhom2_kot104.ungdungdatcomtam.dao.UserDao
import com.nhom2_kot104.ungdungdatcomtam.model.Category
import com.nhom2_kot104.ungdungdatcomtam.model.Dish
import com.nhom2_kot104.ungdungdatcomtam.model.UserAccount

//Để nham emtity bang dishDao
@Database(entities = [UserAccount::class,Category::class, Dish::class], version = 1)
abstract class DbHelper : RoomDatabase(){
    // Hàm trừu tượng để lấy đối tượng DAO
    abstract fun  getUserDao() : UserDao
    abstract fun getCategoryDao(): CategoryDao
    abstract fun getDisDao(): DishDao

    // Hàm để lấy instance của cơ sở dữ liệu, sử dụng pattern singleton
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