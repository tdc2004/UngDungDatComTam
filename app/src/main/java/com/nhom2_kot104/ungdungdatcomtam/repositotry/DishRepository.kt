package com.nhom2_kot104.ungdungdatcomtam.repositotry

import androidx.lifecycle.LiveData
import com.nhom2_kot104.ungdungdatcomtam.dao.DishDao
import com.nhom2_kot104.ungdungdatcomtam.model.Dish

class DishRepository(private val dishDao: DishDao){
    // Lấy tất cả các Category từ cơ sở dữ liệu
    val allDishs: LiveData<List<Dish>> = dishDao.getAllDishes()

    // Thêm một Category mới
    suspend fun insert(category: Dish) {
        dishDao.insert(category)
    }
    // Xóa một Category
    suspend fun delete(category: Dish) {
        dishDao.delete(category)
    }

    // Cập nhật một Category
    suspend fun update(category: Dish) {
        dishDao.update(category)
    }
    suspend fun getDish(dishId: Int): Dish? {
        return dishDao.getDish(dishId)
    }

}