package com.composablecode.micro_front_android

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class HomeMicroApp() : MicroApp {
    override fun pages(registryService: RegistryService) {
        registryService.apply {
            addPage(
                Page(AppRoute.Home) { _, _ ->
                    HomeScreen(onNavigateToDetails = {
                        NavigatorServiceProvider.I.navigateTo(AppRoute.HomeDetails)
                    })
                },
            )
            addPage(
                Page(AppRoute.HomeDetails) { _, _ ->
                    HomeDetailsScreen()
                },
            )
        }
    }


}

class ProfileMicroApp : MicroApp {
    override fun pages(registryService: RegistryService) {
        registryService.apply {
            register<AppRoute.Profile> { route ->
                Page(route) { args, _ ->
                    ProfileScreen(userId = args.userId)
                }
            }
            addPage(
                Page(AppRoute.ProfileSettings) { _, _ ->
                    ProfileSettingsScreen()
                },
            )
            addPage(
                Page(AppRoute.ProfileSettings) { _, _ ->
                    ProfileSettingsScreen()
                },
            )
        }
    }


}

@Composable
fun ProfileSettingsScreen() {
    Text("Profile Settings Screen")
}

@Composable
fun HomeSettingsScreen() {
    Text("Home Settings Screen")
}

@Composable
fun HomeDetailsScreen() {
    Column {
        Text("Home Details Screen")
        Button(onClick = {
            NavigatorServiceProvider.I.navigateTo(AppRoute.Profile("123"))
        }) {
            Text("Navigate to Profile")
        }
    }
}

@Composable
fun HomeScreen(onNavigateToDetails: () -> Unit = {}) {

    Column {
        Text("Home Screen")
        Button(onClick = onNavigateToDetails) {
            Text("Navigate to Details")
        }
    }
}


@Composable
fun ProfileScreen(userId: String) {
    Text("Profile Screen $userId")
    Column {
        Text("Profile Screen $userId")
        Button(onClick = {
            NavigatorServiceProvider.I.navigateTo(AppRoute.ProfileSettings)
        }) {
            Text("Navigate to Profile")
        }
    }
}