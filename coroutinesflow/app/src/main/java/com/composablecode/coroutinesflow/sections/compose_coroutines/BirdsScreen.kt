package com.composablecode.coroutinesflow.sections.compose_coroutines


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch


@Composable
fun BirdsScreen() {
    var currentBird by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()
    var job by remember { mutableStateOf<Job?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            job?.cancel() // Cancel the previous coroutine
            currentBird = "Coo"
            job = coroutineScope.launch {
                while (isActive) {
                    println("Coo")
                    delay(1000L)
                }
            }
        }) {
            Text("Coo")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            job?.cancel()
            currentBird = "Caw"
            job = coroutineScope.launch {
                while (isActive) {
                    println("Caw")
                    delay(2000L)
                }
            }
        }) {
            Text("Caw")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            job?.cancel()
            currentBird = "Chirp"
            job = coroutineScope.launch {
                while (isActive) {
                    println("Chirp")
                    delay(3000L)
                }
            }
        }) {
            Text("Chirp")
        }

        currentBird?.let {
            Text(
                text = "Current Bird: $it",
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun BirdSoundsApp() {
    // State variable to track the current bird
    var currentBird by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Buttons for each bird
        Button(onClick = { currentBird = "Coo" }) {
            Text("Coo")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { currentBird = "Caw" }) {
            Text("Caw")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { currentBird = "Chirp" }) {
            Text("Chirp")
        }

        // Display the current bird's name and invoke its composable
        Spacer(modifier = Modifier.height(16.dp))
        currentBird?.let { bird ->
            Text(text = "Current Bird: $bird")
            Spacer(modifier = Modifier.height(8.dp))

            // Render the appropriate bird composable
            when (bird) {
                "Coo" -> BirdComposable(birdName = "Coo", interval = 1000L)
                "Caw" -> BirdComposable(birdName = "Caw", interval = 2000L)
                "Chirp" -> BirdComposable(birdName = "Chirp", interval = 3000L)
            }
        }
    }
}

@Composable
fun BirdComposable(birdName: String, interval: Long) {
    LaunchedEffect(birdName) {
        while (isActive) {
            println(birdName)
            delay(interval)
        }
    }
}

