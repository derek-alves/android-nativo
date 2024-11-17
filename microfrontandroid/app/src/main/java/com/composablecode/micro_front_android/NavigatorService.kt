package com.composablecode.micro_front_android

import androidx.navigation.NavController

object NavigatorServiceProvider {
    lateinit var I: NavigationService

    fun initialize(navController: NavController) {
        I = NavigationService(navController)
    }
}

class NavigationService(private val navController: NavController) {
    private val registeredRoutes = mutableMapOf<String, AppRoute>()

    fun registerRoute(route: AppRoute) {
        registeredRoutes[route::class.qualifiedName!!] = route
    }

    fun navigateTo(route: String) {
        if (registeredRoutes.containsKey(route)) {
            navController.navigate(route)
        }
    }

    fun navigateBack() {
        navController.popBackStack()
    }
}
