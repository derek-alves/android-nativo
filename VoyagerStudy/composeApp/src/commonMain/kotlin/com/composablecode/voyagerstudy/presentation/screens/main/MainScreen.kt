package com.composablecode.voyagerstudy.presentation.screens.main


import androidx.compose.foundation.layout.Column
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.composablecode.voyagerstudy.presentation.components.DrawerItem
import com.composablecode.voyagerstudy.presentation.screens.main.adaptive.OnMobile
import com.composablecode.voyagerstudy.presentation.screens.main.tab.HomeTab
import com.composablecode.voyagerstudy.presentation.screens.main.tab.MailTab
import com.composablecode.voyagerstudy.presentation.screens.main.tab.NotificationTab
import com.composablecode.voyagerstudy.presentation.screens.main.tab.SearchTab
import com.composablecode.voyagerstudy.responsive.AdaptiveScreen
import com.composablecode.voyagerstudy.responsive.mediaQueryProvider
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(mainViewModel: MainViewModel = koinViewModel()) {
    AdaptiveScreen(
        state = mainViewModel,
        onMobile = { it -> OnMobile(it) },
        onTablet = { onTablet() },
    )
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





