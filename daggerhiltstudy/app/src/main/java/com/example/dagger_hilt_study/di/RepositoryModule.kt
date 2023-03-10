package com.example.dagger_hilt_study.di

import android.app.Application
import com.example.dagger_hilt_study.data.remote.Api
import com.example.dagger_hilt_study.data.repository.RepositoryImpl
import com.example.dagger_hilt_study.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract  class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMyRepository(
        repositoryImpl: RepositoryImpl
    ):Repository

}