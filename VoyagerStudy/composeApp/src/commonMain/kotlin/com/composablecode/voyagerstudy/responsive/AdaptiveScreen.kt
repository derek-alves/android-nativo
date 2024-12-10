package com.composablecode.voyagerstudy.responsive

import androidx.compose.runtime.Composable

@Composable
fun AdaptiveScreen(
    onMobile: @Composable () -> Unit,
    onTablet: (@Composable () -> Unit)? = null,
    onDesktop: (@Composable () -> Unit)? = null,
) {
    val resolvedContent: @Composable () -> Unit = mediaQueryProvider.current.let {
        when {
            it.isDesktop -> onDesktop ?: onTablet ?: onMobile
            it.isTable -> onTablet ?: onMobile
            else -> onMobile
        }
    }
    resolvedContent()
}