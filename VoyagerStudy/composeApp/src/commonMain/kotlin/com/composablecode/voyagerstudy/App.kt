package com.composablecode.voyagerstudy

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.annotation.InternalVoyagerApi
import cafe.adriel.voyager.navigator.Navigator
import com.composablecode.voyagerstudy.screens.ScreenA
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import voyagerstudy.composeapp.generated.resources.Res
import voyagerstudy.composeapp.generated.resources.compose_multiplatform

@OptIn(InternalVoyagerApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        Navigator(ScreenA())
    }
}