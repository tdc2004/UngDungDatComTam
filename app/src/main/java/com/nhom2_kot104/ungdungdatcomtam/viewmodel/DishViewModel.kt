package com.nhom2_kot104.ungdungdatcomtam.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.nhom2_kot104.ungdungdatcomtam.database.DbHelper
import com.nhom2_kot104.ungdungdatcomtam.model.Dish
import com.nhom2_kot104.ungdungdatcomtam.repositotry.DishRepository
import kotlinx.coroutines.launch

class DishViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DishRepository
    val allDishs: LiveData<List<Dish>>

    init {
        val dishDao = DbHelper.getInstance(application).getDisDao()
        repository = DishRepository(dishDao)
        allDishs = repository.allDishs
    }

    fun insert(dish: Dish) {
        viewModelScope.launch {
            repository.insert(dish)
        }
    }

    fun delete(dish: Dish) {
        viewModelScope.launch {
            repository.delete(dish)
        }
    }

    fun update(dish: Dish) {
        viewModelScope.launch {
            repository.update(dish)
        }
    }

    //    fun getDish(dishID: Int): LiveData<Dish> {
//        return liveData {
//            val dish = repository.getDish(dishID)
//            emit(dish ?: Dish(uid = dishID, name = "", price = , image = "",)) // Trả về một Category mặc định nếu category là null
//        }
//    }
    fun getDish(dishId: Int): LiveData<Dish?> {
        return liveData {
            val dish = repository.getDish(dishId)
            emit(dish) // Trả về một Dish hoặc null nếu không tìm thấy
        }
    }


}