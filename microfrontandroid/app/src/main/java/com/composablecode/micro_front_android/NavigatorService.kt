package com.composablecode.micro_front_android

import androidx.navigation.NavController

object NavigatorServiceProvider {
    lateinit var I: NavigationService

    fun initialize(navController: NavController) {
        I = NavigationService(navController)
    }
}

class NavigationService(private val navController: NavController) {
    private val registeredPages = mutableListOf<Page<AppRoute>>()
    fun addPage(page: Page<AppRoute>) {
        registeredPages.add(page)
    }

    fun navigateTo(route: AppRoute) {
            navController.navigate(route)
    }

    fun getRegisteredPages() : List<Page<AppRoute>> {
        return registeredPages
    }

    fun navigateBack() {
        navController.popBackStack()
    }
}
