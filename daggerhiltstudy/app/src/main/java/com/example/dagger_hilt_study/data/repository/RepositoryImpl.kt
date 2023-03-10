package com.example.dagger_hilt_study.data.repository

import android.app.Application
import com.example.dagger_hilt_study.R
import com.example.dagger_hilt_study.data.remote.Api
import com.example.dagger_hilt_study.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: Api, private val appContext: Application) : Repository {
    init {
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository. The app name is $appName")
    }
    override suspend fun doNetWordCall() {
        api.doNetWorkCall()
    }

}