package com.composablecode.coroutinesflow

import android.content.Context
import android.location.LocationManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.app.ActivityCompat
import androidx.core.content.getSystemService
import androidx.lifecycle.lifecycleScope
import com.composablecode.coroutinesflow.exercise.AssignmentTwoScreen
import com.composablecode.coroutinesflow.ui.theme.CoroutinesflowTheme
import com.composablecode.coroutinesflow.sections.coroutine_cancelation.trap3.FileManager
import com.composablecode.coroutinesflow.sections.coroutines_context.queryDatabase
import com.composablecode.coroutinesflow.sections.coroutines_context.withContextDemo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis
import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.CancellationSignal
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.concurrent.Executors
import java.util.function.Consumer
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


class MainActivity : ComponentActivity() {
    private val customLifecycleObserver = CoroutineScope(Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ActivityCompat.requestPermissions(this, arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ),0)

        lifecycleScope.launch {
//            val location = getLocation()
//            println("Location: $location")
        }


       // val fileManager = FileManager(applicationContext)
//        lifecycleScope.launch {
//            val job = launch {
//                fileManager.writeRecordsToFile()
//            }
//            delay(3000L)
//            job.cancel()
//        }

        setContent {
            CoroutinesflowTheme {
                AssignmentTwoScreen()
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        customLifecycleObserver.cancel()
    }
}

@SuppressLint("NewApi")
suspend fun Context.getLocation():Location{
    return suspendCancellableCoroutine { continuation ->
        val locationManager = getSystemService<LocationManager>()!!

        val hasFineLocationPermission = ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) ==   PackageManager.PERMISSION_GRANTED

        val hasCoarseLocationPermission = ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) ==   PackageManager.PERMISSION_GRANTED
        val signal = CancellationSignal()
        if(hasFineLocationPermission || hasCoarseLocationPermission){
            val location = locationManager.getCurrentLocation(
                LocationManager.NETWORK_PROVIDER,
                signal,
                mainExecutor,
            ) { location ->
                continuation.resume(location)
            }
        }else{
            continuation.resumeWithException(
                RuntimeException("Missing permission")
            )
        }
        continuation.invokeOnCancellation {
            signal.cancel()
        }
    }

}

