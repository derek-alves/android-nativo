package com.composablecode.voyagerstudy.presentation.screens.home.tab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.components.ButtonIcon
import com.composablecode.voyagerstudy.designSystem.components.ButtonPrimary
import com.composablecode.voyagerstudy.designSystem.components.ButtonType
import com.composablecode.voyagerstudy.designSystem.spacings
import com.composablecode.voyagerstudy.presentation.components.AppBar
import com.composablecode.voyagerstudy.presentation.components.Header


object HomeTab : Tab {
    @Composable
    override fun Content() {
        Scaffold(
            topBar = {
                AppBar()
            },
            modifier = Modifier.fillMaxSize(),
            content = {
                Column(
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacings().lg),
                    verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacings().lg)
                ) {
                    Spacer(modifier = Modifier.height(MaterialTheme.spacings().lg))
                    Header()
                    ButtonPrimary(text = "Home", leadIcon = AppIcon.Home) { }
                    ButtonIcon(icon = AppIcon.Home)
                    ButtonPrimary(text = "Edit Profile", type = ButtonType.Wrap) { }

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









