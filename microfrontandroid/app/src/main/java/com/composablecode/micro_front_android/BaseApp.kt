package com.composablecode.micro_front_android

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun BaseApp(
    microApps: List<MicroApp>,
    startRoute: AppRoute
) {
    val navController: NavController = rememberNavController()
    NavigatorServiceProvider.initialize(navController)
   
    Scaffold(
        content = { innerPadding ->
            NavHost(
                modifier = Modifier.padding(innerPadding),
                navController = navController as NavHostController,
                startDestination = startRoute
            ) {
                registerMicroApps(
                    microApps,
                    RegistryService,
                )
            }
        }
    )
}

