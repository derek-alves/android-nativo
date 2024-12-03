package com.composablecode.coroutinesflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.composablecode.coroutinesflow.sections.compose_coroutines.BirdSoundsApp
import com.composablecode.coroutinesflow.sections.compose_coroutines.BirdsScreen
import com.composablecode.coroutinesflow.ui.theme.CoroutinesflowTheme
import com.composablecode.coroutinesflow.sections.compose_coroutines.CounterScreen
import com.composablecode.coroutinesflow.sections.compose_coroutines.ProfileScreen
import com.composablecode.coroutinesflow.sections.coroutines_context.queryDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainActivity : ComponentActivity() {
    private val customLifecycleObserver = CoroutineScope(Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val job = lifecycleScope.launch {
                queryDatabase()

            val profileDeferred = async{
                println("Fetching profile")
                delay(2000L)
                "Profile"
            }

            val postsDeferred = async {
                println("Fetching posts")
                delay(3000L)
                "Posts"
            }

            val timeMillis = measureTimeMillis {
                val post = postsDeferred.await()
                val profile = profileDeferred.await()
                println("Post: $post")
                println("Profile: $profile")
            }
            println("Time taken: $timeMillis")
        }



        setContent {
            CoroutinesflowTheme {
                BirdSoundsApp()
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        customLifecycleObserver.cancel()
    }
}

