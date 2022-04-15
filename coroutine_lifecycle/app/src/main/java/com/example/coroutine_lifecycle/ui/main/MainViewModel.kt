package com.example.coroutine_lifecycle.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.coroutine_lifecycle.model.User
import com.example.coroutine_lifecycle.repositories.UserRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private var userRepository = UserRepository()
     var usersWithoutLiveData: MutableLiveData<List<User>> = MutableLiveData()

    //livedata respects the life cycle
    var users = liveData(IO) {
        emit(userRepository.getUsers())
    }

    fun getUsers(){
        viewModelScope.launch {
            var result: List<User>? = null
            withContext(IO){
                result = userRepository.getUsers()
            }
            usersWithoutLiveData.value = result!!
        }
    }
}