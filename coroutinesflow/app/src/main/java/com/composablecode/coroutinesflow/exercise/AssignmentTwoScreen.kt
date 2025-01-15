package com.composablecode.coroutinesflow.exercise

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.composablecode.coroutinesflow.utils.PhotoProcessor
import com.composablecode.coroutinesflow.utils.RotatingBoxScreen
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun AssignmentTwoScreen() {
//    var photoUri by remember { mutableStateOf<Uri?>(null) }
//    val context = LocalContext.current
//    val scope = rememberCoroutineScope()
//    val isLoading by remember { mutableStateOf(false) }
//    var backgroundColor by remember { mutableStateOf(Color.White) }
//
//    val imagePicker = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.PickVisualMedia()
//    ) {
//        photoUri = it
//        if (it != null) {
//            // Start processing the image in a coroutine
//            scope.launch {
//                processImage(context, it) { color ->
//                    backgroundColor = color
//                }
//            }
//        }
//    }
//
//    Column(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .fillMaxSize()
//            .background(backgroundColor),
//    ) {
//        RotatingBoxScreen()
//        Spacer(modifier = Modifier.height(64.dp))
//        Button(onClick = {
//            imagePicker.launch(
//                input = PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly),
//            )
//        }) {
//            Text(text = "Pick Image")
//        }
//        if (isLoading) {
//            Text(text = "Finding dominant color...")
//        }
//
//        if (photoUri != null) {
//            val painter = rememberAsyncImagePainter(
//                ImageRequest
//                    .Builder(context)
//                    .data(data = photoUri)
//                    .build()
//            )
//
//            Image(
//                painter = painter,
//                contentDescription = null
//            )
//        }
   // }
}

suspend fun processImage(context: Context, uri: Uri, onResult: (Color) -> Unit) {
    withContext(Dispatchers.IO) {
        val bitmap = context.contentResolver.openInputStream(uri).use {
            BitmapFactory.decodeStream(it)
        }
        val dominantColor = withContext(Dispatchers.Default) {
            PhotoProcessor.findDominantColor(bitmap.downsample(4))
        }
        onResult(Color(dominantColor))
    }
}

fun Bitmap.downsample(factor: Int): Bitmap {
    return Bitmap.createScaledBitmap(
        this,
        this.width / factor,
        this.height / factor,
        true
    )
}