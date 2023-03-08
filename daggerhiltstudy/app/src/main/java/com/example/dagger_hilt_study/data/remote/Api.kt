package com.example.dagger_hilt_study.data.remote

import retrofit2.http.GET

interface Api {
    @GET("test")
    suspend fun  doNetWorkCall()
}