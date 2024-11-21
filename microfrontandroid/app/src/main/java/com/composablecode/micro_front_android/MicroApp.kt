package com.composablecode.micro_front_android

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

interface MicroApp {
    fun NavGraphBuilder.registerRoutes()
}

class Page<T: AppRoute>(val content: @Composable () -> Unit) {
    inline fun <reified T: AppRoute> NavGraphBuilder.addPage(){
        composable<T>{
            content()
            }
    }
}