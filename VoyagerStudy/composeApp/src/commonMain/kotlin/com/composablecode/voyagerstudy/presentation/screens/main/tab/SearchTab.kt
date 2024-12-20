package com.composablecode.voyagerstudy.presentation.screens.main.tab

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.presentation.screens.main.search.SearchScreen

object SearchTab : Tab {
    @Composable
    override fun Content() {
        SearchScreen()
    }

    override val options: TabOptions
        @Composable
        get() {
            val title = AppIcon.Search.name
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
