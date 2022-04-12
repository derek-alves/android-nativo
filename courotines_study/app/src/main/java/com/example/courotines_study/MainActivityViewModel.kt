package com.example.courotines_study

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.courotines_study.model.User
import com.example.courotines_study.model.UserRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel: ViewModel() {
    private var userRepository = UserRepository()
    var users: MutableLiveData<List<User>> = MutableLiveData()

    fun getUserData(){
        viewModelScope.launch {
        var result : List<User>? = null
            withContext(IO){
                result = userRepository.getUsers()
            }
            users.value = result
        }
    }
}