package com.example.coroutine_lifecycle.repositories

import com.example.coroutine_lifecycle.model.User
import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers(): List<User>{
        delay(8000)
        return listOf(
            User(1,"Derek"),
            User(2,"Perk"),
            User(3,"Jerk"),
            User(4,"Trek"),
            User(5,"Mark"),
        )
    }
}