package com.example.meditation_ui.routes

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.meditation_ui.ui.screens.HomeScreen

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("played") {
            PlayedContents()
        }

    }
}


@Composable
fun PlayedContents() {
    Text("Player")
}