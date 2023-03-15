package com.example.meditation_ui.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.meditation_ui.databinding.FragmentMessageBinding
import com.example.meditation_ui.ui.screens.HomeScreen

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("played") {
            MessageScreen()
        }

    }
}


@Composable
fun MessageScreen() {
    AndroidViewBinding(FragmentMessageBinding::inflate)
}