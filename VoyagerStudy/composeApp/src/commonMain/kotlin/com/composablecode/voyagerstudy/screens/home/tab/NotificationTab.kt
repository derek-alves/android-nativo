package com.composablecode.voyagerstudy.screens.home.tab

import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.composablecode.voyagerstudy.designSystem.AppIcon

object NotificationTab : Tab {
    @Composable
    override fun Content() {
        Text("Notification are here.")
    }

    override val options: TabOptions
        @Composable
        get() {
            val title = AppIcon.Sign.name
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