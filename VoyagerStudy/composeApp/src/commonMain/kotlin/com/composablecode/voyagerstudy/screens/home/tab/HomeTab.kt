package com.composablecode.voyagerstudy.screens.home.tab

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.composablecode.voyagerstudy.designToken.spacings


object HomeTab : Tab {
    @Composable
    override fun Content() {
        Scaffold(
            modifier = Modifier.fillMaxSize().padding(MaterialTheme.spacings().md),
            content = {
                Text("Welcome to Home Tab!", style = MaterialTheme.typography.h1)
            }
        )

    }

    override val options: TabOptions
        @Composable
        get() {
            val title = "Home"
            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }
}


object ProfileTab : Tab {
    @Composable
    override fun Content() {
        Text("This is the Profile Tab!")
    }

    override val options: TabOptions
        @Composable
        get() {
            val title = "Profile"
            val icon = rememberVectorPainter(Icons.Default.Person)

            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon
                )
            }
        }
}

object SettingsTab : Tab {
    @Composable
    override fun Content() {
        Text("Settings are here.")
    }

    override val options: TabOptions
        @Composable
        get() {
            val title = "settings"
            val icon = rememberVectorPainter(Icons.Default.Settings)

            return remember {
                TabOptions(
                    index = 2u,
                    title = title,
                    icon = icon
                )
            }
        }
}