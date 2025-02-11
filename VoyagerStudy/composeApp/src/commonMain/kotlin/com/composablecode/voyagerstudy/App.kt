package com.composablecode.voyagerstudy


import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.composablecode.voyagerstudy.data.jsonString
import com.composablecode.voyagerstudy.designSystem.AppTheme
import com.composablecode.voyagerstudy.designSystem.DesignSystemManager
import com.composablecode.voyagerstudy.di.appModule
import com.composablecode.voyagerstudy.presentation.screens.main.MainScreen
import com.composablecode.voyagerstudy.responsive.Breakpoint
import com.composablecode.voyagerstudy.responsive.MaxWidthBox
import com.composablecode.voyagerstudy.responsive.ResponsiveLayout
import com.composablecode.voyagerstudy.responsive.utils.BreakPointPlatform
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication


@Composable
@Preview
fun App() {
    val designSystemManager = remember {
        DesignSystemManager(jsonString)
    }

    AppTheme(designSystemManager) {
        ResponsiveLayout(
            breakpoints = listOf(
                Breakpoint(start = 0.0, end = 450.0, type = BreakPointPlatform.MOBILE),
                Breakpoint(start = 451.0, end = 800.0, type = BreakPointPlatform.TABLET),
                Breakpoint(start = 801.0, end = 1920.0, type = BreakPointPlatform.DESKTOP),
            )
        ) {
            MaxWidthBox(maxWidth = 900.dp, alignment = Alignment.Center) {
                KoinApplication(application = {
                    modules(
                        appModule
                    )
                }) {
                    MainScreen()
                }

            }
        }
    }
}





