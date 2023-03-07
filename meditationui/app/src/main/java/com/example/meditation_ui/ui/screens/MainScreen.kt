package com.example.meditation_ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.meditation_ui.entity.BottomMenuContent
import com.example.meditation_ui.routes.NavigationHost
import com.example.meditation_ui.ui.screens.CustomBottomBar


@Preview()
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            CustomBottomBar(
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                },
                items = listOf(
                    BottomMenuContent("Home", "home", R.drawable.ic_home),
                    BottomMenuContent("Music", "played", R.drawable.ic_music),

                    )
            )
        }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationHost(navController = navController)
        }

    }
}
