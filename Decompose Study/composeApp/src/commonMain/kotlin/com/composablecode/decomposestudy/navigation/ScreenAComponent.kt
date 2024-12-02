package com.composablecode.decomposestudy.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class ScreenAComponent(
    componentContext: ComponentContext,
    private val onNavigate: (String) -> Unit
) : ComponentContext by componentContext {
    private var _text = MutableValue("")
    val text: Value<String> = _text

    fun onEvent(event: ScreenAEvent) {
        when (event) {
            is ScreenAEvent.ClickButton -> onNavigate(_text.value)
            is ScreenAEvent.UpdateText -> {
                _text.value = event.text
            }
        }
    }
}