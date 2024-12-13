package com.composablecode.voyagerstudy.screens.home


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.composablecode.voyagerstudy.components.DrawerItem
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.components.ButtonIcon
import com.composablecode.voyagerstudy.designSystem.customColors
import com.composablecode.voyagerstudy.designSystem.spacings
import com.composablecode.voyagerstudy.responsive.AdaptiveScreen
import com.composablecode.voyagerstudy.responsive.mediaQueryProvider
import com.composablecode.voyagerstudy.screens.home.tab.HomeTab
import com.composablecode.voyagerstudy.screens.home.tab.MailTab
import com.composablecode.voyagerstudy.screens.home.tab.NotificationTab
import com.composablecode.voyagerstudy.screens.home.tab.SearchTab
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    AdaptiveScreen(
        onMobile = { onMobile() },
        onTablet = { onTablet() },
    )
}

@Composable
private fun onMobile() {
    TabNavigator(HomeTab) {
        Scaffold(
            backgroundColor = MaterialTheme.customColors().gray,
            content = {
                CurrentTab()
            },
            bottomBar = {
                val commonSpacing = MaterialTheme.spacings().xs
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
fun onTablet() {
    val mediaQuery = mediaQueryProvider.current
    val scope = rememberCoroutineScope()
    val drawerState = remember { DrawerState(DrawerValue.Closed) }
    TabNavigator(HomeTab) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("${mediaQuery.breakpoint.type}: ${mediaQuery.isMobile} + ${mediaQuery.orientation}") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },
            content = {
                ModalDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        Column {
                            DrawerItem(HomeTab)
                            DrawerItem(SearchTab)
                            DrawerItem(NotificationTab)
                            DrawerItem(MailTab)
                        }
                    },
                    content = {
                        CurrentTab()
                    })

            })


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


