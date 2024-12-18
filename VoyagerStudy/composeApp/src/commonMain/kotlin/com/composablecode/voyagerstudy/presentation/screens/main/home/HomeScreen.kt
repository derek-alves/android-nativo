package com.composablecode.voyagerstudy.presentation.screens.main.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.components.Avatar
import com.composablecode.voyagerstudy.designSystem.components.ButtonIcon
import com.composablecode.voyagerstudy.designSystem.spacings
import com.composablecode.voyagerstudy.domain.entity.Tweet
import com.composablecode.voyagerstudy.presentation.components.AppBar
import com.composablecode.voyagerstudy.presentation.components.Header
import com.composablecode.voyagerstudy.presentation.components.TweetCard
import com.composablecode.voyagerstudy.presentation.screens.main.MainViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(mainViewModel: MainViewModel = koinViewModel()) {
    Scaffold(
        topBar = {
            AppBar(
                horizontalArrangement = Arrangement.SpaceBetween,
                leading = {
                    Avatar(
                        imageUrl = "drawable/images/avatar-1.png",
                        onPressed = {
                            mainViewModel.switchDrawer()
                        }
                    )
                },
                trailing = {
                    ButtonIcon(
                        icon = AppIcon.OpenPoints
                    )
                },


                )
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