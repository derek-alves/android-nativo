package com.composablecode.micro_front_android

import androidx.navigation.NavController

object NavigatorServiceProvider {
    lateinit var I: NavigationService

    fun initialize(navController: NavController) {
        I = NavigationService(navController)
    }
}

class NavigationService(private val navController: NavController) {
    private val registeredRoutes = mutableListOf<AppRoute>()

    fun registerRoute(route: AppRoute) {
        registeredRoutes.add(route)
    }

    fun navigateTo(route: AppRoute) {
        if (registeredRoutes.contains(route)) {
            navController.navigate(route)
        }
    }

    fun navigateBack() {
        navController.popBackStack()
    }
}
