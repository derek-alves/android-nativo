package com.composablecode.coroutinesflow.sections.compose_coroutines

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun CounterScreen(modifier: Modifier = Modifier) {
    var count by remember {
        mutableIntStateOf(0)
    }
    val counter by produceState(initialValue = 0) {
        while(true){
            delay(1000L)
            value += 1
        }
    }
    LaunchedEffect(key1 = count) {
        delay(1000L)
        println("Launched effect finished")
    }
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        Button(onClick = {count++}) {
            Text(text = "Count: $counter")
        }
    }

}