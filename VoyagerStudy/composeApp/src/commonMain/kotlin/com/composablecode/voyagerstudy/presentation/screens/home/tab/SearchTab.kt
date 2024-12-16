package com.composablecode.voyagerstudy.presentation.screens.home.tab

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.components.Border
import com.composablecode.voyagerstudy.designSystem.components.InputSearch
import com.composablecode.voyagerstudy.designSystem.spacings
import com.composablecode.voyagerstudy.presentation.components.AppBar

object SearchTab : Tab {
    @Composable
    override fun Content() {
        Scaffold(
            topBar = {
                AppBar(
                    contentPadding = PaddingValues(
                        start = MaterialTheme.spacings().md,
                        end = MaterialTheme.spacings().xxxl
                    )
                ) {
                    InputSearch(
                        label = "Search Twitter",

                        ) { it ->
                    }
                }
            },
            modifier = Modifier.fillMaxSize(),
            content = { innerPadding ->


                Border(
                    modifier = Modifier.padding(MaterialTheme.spacings().lg)
                        .fillMaxSize()
                ) {
                }

            }
        )
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
