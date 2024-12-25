package com.composablecode.voyagerstudy.presentation.screens.main.adaptive

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DrawerValue
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.components.ButtonIcon
import com.composablecode.voyagerstudy.designSystem.customColors
import com.composablecode.voyagerstudy.designSystem.spacings
import com.composablecode.voyagerstudy.presentation.components.DrawerMobile
import com.composablecode.voyagerstudy.presentation.screens.main.tab.HomeTab
import com.composablecode.voyagerstudy.presentation.screens.main.tab.MailTab
import com.composablecode.voyagerstudy.presentation.screens.main.tab.NotificationTab
import com.composablecode.voyagerstudy.presentation.screens.main.tab.SearchTab
import com.composablecode.voyagerstudy.presentation.viewModel.DrawerState
import com.composablecode.voyagerstudy.presentation.viewModel.MainViewModel
import com.composablecode.voyagerstudy.utils.DrawerShape
import com.composablecode.voyagerstudy.utils.toDrawerValue
import kotlinx.coroutines.launch

@Composable
fun OnMobile(mainViewModel: MainViewModel) {
    val scope = rememberCoroutineScope()
    val drawerStateValue by mainViewModel.drawerState.collectAsState()
    val drawerValue = drawerStateValue.toDrawerValue()

    val drawerState = rememberDrawerState(initialValue = drawerValue)

    LaunchedEffect(drawerState.currentValue) {
        val newViewModelState = when (drawerState.currentValue) {
            DrawerValue.Open -> DrawerState.OPEN
            DrawerValue.Closed -> DrawerState.CLOSED
        }
        if (drawerStateValue != newViewModelState) {
            mainViewModel.setDrawerState(newViewModelState)
        }
    }

    LaunchedEffect(drawerStateValue) {
        when (drawerValue) {
            DrawerValue.Open -> drawerState.open()
            DrawerValue.Closed -> drawerState.close()
        }
    }

    val scaffoldState = rememberScaffoldState(drawerState = drawerState)


    TabNavigator(HomeTab) {
        Scaffold(
            drawerShape = DrawerShape(280.dp, 0f),
            scaffoldState = scaffoldState,
            backgroundColor = MaterialTheme.customColors().gray,
            content = {
                Box(modifier = Modifier.padding(it).fillMaxSize()) {
                    CurrentTab()
                }
            },
            drawerContent = {
                DrawerMobile(
                    onClosePressed = {
                        scope.launch { drawerState.close() }
                    }
                )

            },

            bottomBar = {
                val commonSpacing = MaterialTheme.spacings().xxs
                BottomNavigation(
                    elevation = 0.dp,
                    backgroundColor = MaterialTheme.customColors().grayMedium,
                    modifier = Modifier
                        .drawBehind {
                            val strokeWidth = commonSpacing.toPx()
                            drawLine(
                                color = Color.Black,
                                start = Offset(0f, 0f),
                                end = Offset(size.width, 0f),
                                strokeWidth = strokeWidth
                            )
                        },

                    ) {
                    Row(
                        modifier = Modifier
                            .padding(vertical = commonSpacing),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(SearchTab)
                        TabNavigationItem(NotificationTab)
                        TabNavigationItem(MailTab)
                    }

                }
            }
        )


    }

}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    val icon = when (tab.options.title) {
        AppIcon.Home.name -> AppIcon.Home
        AppIcon.Search.name -> AppIcon.Search
        AppIcon.Sign.name -> AppIcon.Sign
        AppIcon.Mail.name -> AppIcon.Mail
        else -> {
            AppIcon.Home
        }
    }
    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = { ButtonIcon(icon) },
    )
}