package com.composablecode.micro_front_android

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry

class HomeMicroApp : MicroApp {
    override val routes = listOf(
        AppRoute.Home,
        AppRoute.HomeDetails,
        AppRoute.HomeSettings
    )

    override fun content(
        route: AppRoute,
        backStackEntry: NavBackStackEntry
    ): @Composable () -> Unit = {
        when (route) {
            is AppRoute.Home -> HomeScreen(  onNavigateToDetails = {
                NavigatorServiceProvider.I.navigateTo(AppRoute.HomeDetails::class.qualifiedName!!)
            })
            is AppRoute.HomeDetails -> HomeDetailsScreen()
            is AppRoute.HomeSettings -> HomeSettingsScreen()
            else -> throw IllegalArgumentException("Unsupported route: $route")
        }
    }
}

class ProfileMicroApp : MicroApp {
    override val routes = listOf(AppRoute.Profile)

    override fun content(
        route: AppRoute,
        backStackEntry: NavBackStackEntry
    ): @Composable () -> Unit = {

        ProfileScreen(userId = "AAA AA")
    }
}


@Composable
fun HomeSettingsScreen() {
    Text("Home Settings Screen")
}

@Composable
fun HomeDetailsScreen() {
    Text("Home Details Screen")
}

@Composable
fun HomeScreen(onNavigateToDetails  : () -> Unit = {}) {
    Text("Home Screen")
    Button(onClick = onNavigateToDetails) {
        Text("Navigate to Details")
    }
}

@Composable
fun ProfileScreen(userId: String) {
    Text("Profile Screen $userId")
}