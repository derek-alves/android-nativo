package com.composablecode.micro_front_android

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry

interface MicroApp {
    val routes: List<AppRoute>
    fun content(route: AppRoute, backStackEntry: NavBackStackEntry): @Composable () -> Unit
}