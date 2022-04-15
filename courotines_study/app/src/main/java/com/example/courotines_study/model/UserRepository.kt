package com.example.courotines_study.model

import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers(): List<User> {
        delay(8000)
        return listOf(
            User(1, "derek"),
            User(2, "AADerek"),
            User(3, "BBBDerek"),
            User(4, "CCCDerek"),
            User(5, "DDDDerek"),
            User(6, "EEEDerek"),
        )
    }
}