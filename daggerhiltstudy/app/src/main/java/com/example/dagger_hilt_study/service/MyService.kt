package com.example.dagger_hilt_study.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.dagger_hilt_study.domain.repository.Repository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MyService :Service(){

    @Inject
    lateinit var repository: Repository
    override fun onCreate() {
        super.onCreate()

    }
    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}