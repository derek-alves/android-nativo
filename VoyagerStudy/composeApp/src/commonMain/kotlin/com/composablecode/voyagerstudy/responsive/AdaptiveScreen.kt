package com.composablecode.voyagerstudy.responsive

import androidx.compose.runtime.Composable

@Composable
fun <T : Any> AdaptiveScreen(
    state: T,
    onMobile: @Composable (T) -> Unit,
    onTablet: (@Composable (T) -> Unit)? = null,
    onDesktop: (@Composable (T) -> Unit)? = null,
) {
    val resolvedContent: @Composable (T) -> Unit = mediaQueryProvider.current.let {
        when {
            it.isDesktop -> onDesktop ?: onTablet ?: onMobile
            it.isTable -> onTablet ?: onMobile
            else -> onMobile
        }
    }
    resolvedContent(state)
}