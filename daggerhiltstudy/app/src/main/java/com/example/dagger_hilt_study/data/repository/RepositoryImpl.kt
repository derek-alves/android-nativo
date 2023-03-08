package com.example.dagger_hilt_study.data.repository

import com.example.dagger_hilt_study.data.remote.Api
import com.example.dagger_hilt_study.domain.repository.Repository

class RepositoryImpl(private val api: Api): Repository{
    override suspend fun doNetWordCall() {
        TODO("Not yet implemented")
    }

}