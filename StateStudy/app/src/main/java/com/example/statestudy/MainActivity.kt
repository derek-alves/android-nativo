package com.example.statestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.statestudy.ui.theme.StateStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateStudyTheme {
               val viewModel = viewModel<MainViewModel>()
                val composeColor = viewModel.composeColor
                val flowColor by viewModel.color.collectAsState()


                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color(flowColor))
                    .clickable {
                        viewModel.generateNewColor()
                    }
                )
            }
        }
    }
}

