package com.composablecode.voyagerstudy


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DrawerValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.composablecode.voyagerstudy.responsive.Breakpoint
import com.composablecode.voyagerstudy.responsive.MaxWidthBox
import com.composablecode.voyagerstudy.responsive.ResponsiveLayout
import com.composablecode.voyagerstudy.responsive.mediaQueryProvider
import com.composablecode.voyagerstudy.responsive.utils.BreakPointPlatform
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        ResponsiveLayout(
            breakpoints = listOf(
                Breakpoint(start = 0.0, end = 450.0, type = BreakPointPlatform.MOBILE),
                Breakpoint(start = 451.0, end = 800.0, type = BreakPointPlatform.TABLET),
                Breakpoint(start = 801.0, end = 1920.0, type = BreakPointPlatform.DESKTOP),
            )
        ) {
            MaxWidthBox(maxWidth = 900.dp, alignment = Alignment.Center) {
                TabNavigationExample()
            }

        }
    }
}

@Composable
fun TabNavigationExample() {
    val mediaQuery = mediaQueryProvider.current
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
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

//        Scaffold(
//            drawerContent = {
//
//            },
//            content = {
//                CurrentTab()
//            },
//            bottomBar = {
//                BottomNavigation {
//                    TabNavigationItem(HomeTab)
//                    TabNavigationItem(ProfileTab)
//                    TabNavigationItem(SettingsTab)
//                }
//            }
//        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DrawerItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    ListItem(
        text = { Text(tab.options.title) },
        icon = { Icon(tab.options.icon!!, contentDescription = null) },
        modifier = Modifier.clickable { tabNavigator.current = tab }
    )
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

object HomeTab : Tab {
    @Composable
    override fun Content() {
        Text("Welcome to Home Tab!")
    }

    override val options: TabOptions
        @Composable
        get() {
            val title = "Home"
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

object ProfileTab : Tab {
    @Composable
    override fun Content() {
        Text("This is the Profile Tab!")
    }

    override val options: TabOptions
        @Composable
        get() {
            val title = "Profile"
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

object SettingsTab : Tab {
    @Composable
    override fun Content() {
        Text("Settings are here.")
    }

    override val options: TabOptions
        @Composable
        get() {
            val title = "settings"
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