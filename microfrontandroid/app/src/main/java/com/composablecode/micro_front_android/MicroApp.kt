package com.composablecode.micro_front_android

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

interface MicroApp {
    fun registerPages(navigationService: NavigationService)
    fun registerRoutes(builder: NavGraphBuilder)
}

class Page<out T: AppRoute>(val content: @Composable () -> Unit) {
    inline fun <reified T : AppRoute>  addPage(builder: NavGraphBuilder){
         builder.composable<T>{
            content()
            }
    }
}

fun Page<AppRoute>.register() {
    NavigatorServiceProvider.I.addPage(this)
}

fun NavGraphBuilder.registerMicroApps(microApps: List<MicroApp>) {
    microApps.forEach { app ->
        with(this) {
            app.registerRoutes(this)
            app.registerPages(NavigatorServiceProvider.I)
            NavigatorServiceProvider.I.getRegisteredPages().forEach {
                it.addPage(this)
            }
        }
    }
}