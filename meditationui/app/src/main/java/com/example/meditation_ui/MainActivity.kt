package com.example.meditation_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.example.meditation_ui.databinding.ActivityNavigationBinding
import com.example.meditation_ui.ui.theme.MeditationuiTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationuiTheme {
                Message()
            }
        }
    }
}

@Composable
fun Message() {
    AndroidViewBinding(ActivityNavigationBinding::inflate)
}