package com.nhom2_kot104.ungdungdatcomtam.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.nhom2_kot104.ungdungdatcomtam.database.DbHelper
import com.nhom2_kot104.ungdungdatcomtam.model.Category
import com.nhom2_kot104.ungdungdatcomtam.repositotry.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application): AndroidViewModel(application) {
    private val repository: CategoryRepository
    val allCategories: LiveData<List<Category>>
    init {
        val categoryDao = DbHelper.getInstance(application).getCategoryDao()
        repository = CategoryRepository(categoryDao)
        allCategories = repository.allCategories
    }
    fun insert(category: Category) {
        viewModelScope.launch {
            repository.insert(category)
        }
    }

    fun delete(category: Category) {
        viewModelScope.launch {
            repository.delete(category)
        }
    }

    fun update(category: Category) {
        viewModelScope.launch {
            repository.update(category)
        }
    }
    fun getCategory(categoryId: Int): LiveData<Category> {
        return liveData {
            val category = repository.getCategory(categoryId)
            emit(category ?: Category(uid = categoryId, name = "")) // Trả về một Category mặc định nếu category là null
        }
    }


}