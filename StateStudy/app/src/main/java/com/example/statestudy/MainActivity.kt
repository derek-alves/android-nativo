package com.example.statestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.statestudy.ui.theme.StateStudyTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       collectLatestLifecycleFlow(mainViewModel.counter){
           number->
           binding.tvCounter.text = number.toString()
       }
        setContent {
            StateStudyTheme {
                val viewModel = viewModel<MainViewModel>()
                val composeColor = viewModel.composeColor
                val flowColor by viewModel.color.collectAsState()
                val flowCounter = viewModel.counter.collectAsState(0)


                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color(flowColor))
                    .clickable {
                        viewModel.generateNewColor()
                    }
                ) {
                    Button(
                        modifier = Modifier.align(Alignment.Center),
                        onClick = { viewModel.incrementCounter() }) {
                        Text("Click me $flowCounter")
                    }
                }
            }
        }
    }
}

fun <T> ComponentActivity.collectLatestLifecycleFlow(flow: Flow<T>, collect: suspend (T)-> Unit){
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED){
            flow.collectLatest(collect)
        }
    }
}