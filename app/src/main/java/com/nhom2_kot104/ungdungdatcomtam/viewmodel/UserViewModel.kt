package com.nhom2_kot104.ungdungdatcomtam.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.nhom2_kot104.ungdungdatcomtam.dao.UserDao
import com.nhom2_kot104.ungdungdatcomtam.model.UserAccount
import com.nhom2_kot104.ungdungdatcomtam.repositotry.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(val repository : UserRepository) : ViewModel() {
    private val _isAuthenticated = mutableStateOf<Boolean?>(null)
    val isAuthenticated: State<Boolean?> get() = _isAuthenticated

    fun register(userAccount: UserAccount) = viewModelScope.launch {
        repository.register(userAccount)
    }

    //Nếu muốn phân quyền thì kiểm tra role
    fun checkLogin(username: String, password: String) = viewModelScope.launch {
        val userAccount = repository.login(username, password)
        if(userAccount != null){
            _isAuthenticated.value = true
        }else{
            _isAuthenticated.value = false
        }
    }

    class ViewModelFactory(val repository : UserRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
                return UserViewModel(repository) as T
            }
            throw IllegalArgumentException("Unable construct viewModel")
        }
    }
}


