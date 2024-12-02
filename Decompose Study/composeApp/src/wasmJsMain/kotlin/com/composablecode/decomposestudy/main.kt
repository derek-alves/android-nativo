package com.composablecode.decomposestudy

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry

import com.composablecode.decomposestudy.navigation.RootComponent
import kotlinx.browser.document


@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    val root =
        RootComponent(
            componentContext = DefaultComponentContext(lifecycle = LifecycleRegistry())
        )
    ComposeViewport(document.body!!) {
        App(root)
    }
}

