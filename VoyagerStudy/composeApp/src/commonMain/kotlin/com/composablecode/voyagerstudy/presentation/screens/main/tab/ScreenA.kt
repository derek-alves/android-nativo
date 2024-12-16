package com.composablecode.voyagerstudy.presentation.screens.main.tab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.composablecode.voyagerstudy.presentation.screens.ScreenB

class ScreenA : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Screen A")
            OutlinedTextField(
                value = "Value",
                onValueChange = {

                },
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            )
            Button(onClick = {
                navigator.push(ScreenB("STANDOUT"))
            }) {
                Text("Navigate to Screen B")
            }

        }
    }
}