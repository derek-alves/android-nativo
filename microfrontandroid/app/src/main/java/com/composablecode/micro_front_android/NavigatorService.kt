package com.composablecode.micro_front_android

import androidx.navigation.NavController


object NavigatorServiceProvider {
    lateinit var I: NavigationService
    fun initialize(navController: NavController) {
        I = NavigationService(navController)
    }
}

class NavigationService(private val navController: NavController) {

    fun navigateTo(route: AppRoute) {
        navController.navigate(route)
    }


    fun navigateBack() {
        navController.popBackStack()
    }
}
