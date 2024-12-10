package com.composablecode.coroutinesflow.sections.coroutine_cancelation

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import kotlin.math.roundToInt

class BitmapCompressor(
    private val context: Context
) {

    suspend fun compressImage(
        contentUri: Uri,
        compressionThreshold: Long
    ): Bitmap? {
        return withContext(Dispatchers.IO) {
            val inputBytes = context
                .contentResolver
                .openInputStream(contentUri)?.use { inputStream ->
                    inputStream.readBytes()
                } ?: return@withContext null

            ensureActive()

            withContext(Dispatchers.Default) {
                val bitmap = BitmapFactory.decodeByteArray(inputBytes, 0, inputBytes.size)

                ensureActive()

                var outputBytes: ByteArray
                var quality = 100
                do {
                    ByteArrayOutputStream().use { outputStream ->
                        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream)
                        outputBytes = outputStream.toByteArray()
                        quality -= (quality * 0.1).roundToInt()
                    }
                } while (isActive && outputBytes.size > compressionThreshold && quality > 5)

                ensureActive()

                BitmapFactory.decodeByteArray(outputBytes, 0, outputBytes.size)
            }
        }
    }
}