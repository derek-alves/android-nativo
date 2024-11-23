package com.composablecode.micro_front_android


import androidx.navigation.NavGraphBuilder


interface MicroApp {
    fun registerPages(navigationService: NavigationService)
    fun registerRoutes(builder: NavGraphBuilder)
}



fun NavGraphBuilder.registerMicroApps(microApps: List<MicroApp>) {
    microApps.forEach { app ->
        with(this) {
            app.registerRoutes(this)
            app.pages.forEach { page ->
        }
    }
}


