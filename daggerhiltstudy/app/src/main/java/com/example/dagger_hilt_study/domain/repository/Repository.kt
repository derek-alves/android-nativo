package com.example.dagger_hilt_study.domain.repository

interface Repository {
    suspend fun doNetWordCall()
}