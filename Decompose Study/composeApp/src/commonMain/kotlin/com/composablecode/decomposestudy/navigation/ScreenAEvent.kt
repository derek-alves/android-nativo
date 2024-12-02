package com.composablecode.decomposestudy.navigation

sealed interface ScreenAEvent {
    data object ClickButton : ScreenAEvent
    data class UpdateText(val text: String) : ScreenAEvent
}