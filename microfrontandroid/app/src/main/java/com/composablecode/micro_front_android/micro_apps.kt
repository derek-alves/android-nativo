package com.composablecode.micro_front_android

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

class HomeMicroApp() : MicroApp {
    override fun NavGraphBuilder.registerRoutes() {
        composable<AppRoute.Home> {
            HomeScreen(onNavigateToDetails = {
                NavigatorServiceProvider.I.navigateTo(AppRoute.HomeDetails)
            })
        }
        composable<AppRoute.HomeDetails>() { HomeDetailsScreen() }
        composable<AppRoute.HomeSettings>() { HomeSettingsScreen() }
    }

}

class ProfileMicroApp : MicroApp {
    override fun NavGraphBuilder.registerRoutes() {
        composable<AppRoute.Profile> { ProfileScreen(userId = "AAA AA") }
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
fun HomeScreen(onNavigateToDetails: () -> Unit = {}) {
    Text("Home Screen")
    Button(onClick = onNavigateToDetails) {
        Text("Navigate to Details")
    }
}

@Composable
fun ProfileScreen(userId: String) {
    Text("Profile Screen $userId")
}