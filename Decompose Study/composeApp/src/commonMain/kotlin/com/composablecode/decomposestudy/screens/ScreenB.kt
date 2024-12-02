package com.composablecode.decomposestudy.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.composablecode.decomposestudy.navigation.ScreenBComponent

@Composable
fun ScreenB(component: ScreenBComponent) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Screen B")
        Button(onClick = {
            component.goBack()
        }) {
            Text("Go back")
        }

    }
}