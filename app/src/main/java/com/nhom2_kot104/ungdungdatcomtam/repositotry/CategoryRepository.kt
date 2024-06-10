package com.nhom2_kot104.ungdungdatcomtam.repositotry

import androidx.lifecycle.LiveData
import com.nhom2_kot104.ungdungdatcomtam.dao.CategoryDao
import com.nhom2_kot104.ungdungdatcomtam.model.Category

class CategoryRepository(private val categoryDao: CategoryDao){
    // Lấy tất cả các Category từ cơ sở dữ liệu
    val allCategories: LiveData<List<Category>> = categoryDao.getAll()

    // Thêm một Category mới
    suspend fun insert(category: Category) {
        categoryDao.insert(category)
    }
    // Xóa một Category
    suspend fun delete(category: Category) {
        categoryDao.delete(category)
    }

    // Cập nhật một Category
    suspend fun update(category: Category) {
        categoryDao.update(category)
    }
    suspend fun getCategory(categoryId: Int): Category? {
        return categoryDao.getCategory(categoryId)
    }

}