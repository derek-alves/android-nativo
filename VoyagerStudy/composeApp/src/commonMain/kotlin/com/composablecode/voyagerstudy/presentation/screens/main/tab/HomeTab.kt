package com.composablecode.voyagerstudy.presentation.screens.main.tab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.composablecode.voyagerstudy.designSystem.spacings
import com.composablecode.voyagerstudy.domain.entity.Tweet
import com.composablecode.voyagerstudy.presentation.components.AppBar
import com.composablecode.voyagerstudy.presentation.components.Header
import com.composablecode.voyagerstudy.presentation.components.TweetCard


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

                    Header()
                    TweetCard(
                        tweet = Tweet(
                            text = "Amet habitant mollis adipiscing pretium scelerisque urna euismod nec nullam.",
                            id = "any-id",
                            image = "drawable/images/avatar-5.png",
                            likeQty = 3,
                            userName = "Tommy Blue",
                            identifier = "@tommy_blue"
                        )
                    )

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









