package com.example.dagger_hilt_study.di

import android.app.Application
import com.example.dagger_hilt_study.data.remote.Api
import com.example.dagger_hilt_study.data.repository.RepositoryImpl
import com.example.dagger_hilt_study.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): Api {
        return Retrofit.Builder().
        baseUrl("https://test.com")
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    @Named("hello1")
    fun provideString1()= "Hello 1"

    @Provides
    @Singleton
    @Named("hello2")
    fun provideString2()= "Hello 2"
}