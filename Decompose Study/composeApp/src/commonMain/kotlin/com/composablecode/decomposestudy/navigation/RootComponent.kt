package com.composablecode.decomposestudy.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.Serializable

class RootComponent(componentContext: ComponentContext) : ComponentContext by componentContext {
    private val navigation = StackNavigation<Configuration>()
    val stack = childStack(
        source = navigation,
        initialConfiguration = Configuration.ScreenA,
        handleBackButton = true,
        serializer = Configuration.serializer(),
        childFactory = ::createChild
    )

    private fun createChild(
        configuration: Configuration,
        componentContext: ComponentContext
    ): Child {
        return when (configuration) {
            is Configuration.ScreenA -> Child.ScreenA(
                ScreenAComponent(
                    componentContext = componentContext,
                    onNavigate = { text -> navigation.pushNew(Configuration.ScreenB(text)) })
            )

            is Configuration.ScreenB -> Child.ScreenB(
                ScreenBComponent(
                    text = configuration.text,
                    componentContext = componentContext, onGoBack = {
                        navigation.pop()
                    }
                )
            )
        }

    }

    sealed class Child {
        data class ScreenA(val component: ScreenAComponent) : Child()
        data class ScreenB(val component: ScreenBComponent) : Child()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object ScreenA : Configuration()

        @Serializable
        data class ScreenB(val text: String) : Configuration()
    }
}