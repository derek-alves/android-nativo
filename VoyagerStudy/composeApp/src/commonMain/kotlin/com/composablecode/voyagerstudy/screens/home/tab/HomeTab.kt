package com.composablecode.voyagerstudy.screens.home.tab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.components.ButtonIcon
import com.composablecode.voyagerstudy.designSystem.components.ButtonPrimary
import com.composablecode.voyagerstudy.designSystem.spacings


object HomeTab : Tab {
    @Composable
    override fun Content() {
        Scaffold(
            modifier = Modifier.fillMaxSize().padding(MaterialTheme.spacings().md),
            content = {
                Column {
                    Text("Welcome to Home Tab!", style = MaterialTheme.typography.h2)
                    ButtonPrimary(leadIcon = AppIcon.Home) { }
                    Spacer(modifier = Modifier.height(16.dp))
                    ButtonIcon(icon = AppIcon.Home) {
                    }
                }

            }
        )

    }

    override val options: TabOptions
        @Composable
        get() {
            val title = AppIcon.Home.name
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









