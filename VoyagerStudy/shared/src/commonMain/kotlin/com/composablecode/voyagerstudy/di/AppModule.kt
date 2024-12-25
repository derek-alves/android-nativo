package com.composablecode.voyagerstudy.di

import com.composablecode.voyagerstudy.presentation.viewModel.MainViewModel
import org.koin.dsl.module

val appModule = module {
    single {
        MainViewModel()
    }
}