package com.composablecode.micro_front_android

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import kotlin.reflect.KClass



object NavigatorServiceProvider {
    lateinit var I: NavigationService

    fun initialize(navController: NavController) {
        I = NavigationService(navController)
    }
}

class NavigationService(private val navController: NavController) {
    private val registeredPages = mutableListOf<Page<AppRoute>>()
    private val registeredPages2 = mutableMapOf<AppRoute,@Composable () -> Unit>()

    fun registerPage(route: AppRoute, content: @Composable () -> Unit) {
        registeredPages2[route] = content
    }

    fun addPage(page: Page<AppRoute>) {
        registeredPages.add(page)

    }

    fun navigateTo(route: AppRoute) {
            navController.navigate(route)
    }

    fun getRegisteredPages(): MutableList<Page<AppRoute>> {
        return registeredPages
    }

    fun navigateBack() {
        navController.popBackStack()
    }
}
