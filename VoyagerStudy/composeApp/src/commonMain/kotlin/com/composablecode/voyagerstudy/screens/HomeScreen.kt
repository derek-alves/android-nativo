package com.composablecode.voyagerstudy.screens

import HomeTab
import ProfileTab
import SettingsTab
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
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
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.composablecode.voyagerstudy.components.DrawerItem
import com.composablecode.voyagerstudy.designToken.customColors
import com.composablecode.voyagerstudy.responsive.AdaptiveScreen
import com.composablecode.voyagerstudy.responsive.mediaQueryProvider
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
                BottomNavigation {
                    TabNavigationItem(HomeTab)
                    TabNavigationItem(ProfileTab)
                    TabNavigationItem(SettingsTab)
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
                            DrawerItem(ProfileTab)
                            DrawerItem(SettingsTab)
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

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = { Icon(painter = tab.options.icon!!, contentDescription = tab.options.title) }
    )
}


