package com.composablecode.voyagerstudy.di

import com.composablecode.voyagerstudy.presentation.screens.main.MainViewModel
import org.koin.dsl.module

val appModule = module {
    single {
        MainViewModel()
    }
}