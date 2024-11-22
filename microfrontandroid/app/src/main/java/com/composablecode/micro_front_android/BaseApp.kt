package com.composablecode.micro_front_android

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class BaseApp(
    private val microApps: List<MicroApp>,
    private val startRoute: AppRoute
) {
    private lateinit var navController: NavController
    private val routes = mutableListOf<AppRoute>()



    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Render() {
        navController = rememberNavController()

        NavigatorServiceProvider.initialize(navController)

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("My App") }
                )
            },
            content = { innerPadding ->
                NavHost(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController as NavHostController,
                    startDestination = startRoute
                ) {
                    registerMicroApps(microApps)
                }
            }
        )
    }
}

