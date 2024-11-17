package com.image_effect_app.worker

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.HardwareRenderer
import android.graphics.PixelFormat
import android.graphics.RenderEffect
import android.graphics.RenderNode
import android.graphics.Shader
import android.hardware.HardwareBuffer
import android.media.ImageReader
import android.os.Build
import androidx.annotation.WorkerThread
import androidx.annotation.RequiresApi

import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.image_effect_app.CHANNEL_ID
import com.image_effect_app.NOTIFICATION_ID
import com.image_effect_app.NOTIFICATION_TITLE
import com.image_effect_app.R

private const val TAG = "WorkerUtils"
fun makeStatusNotification(message: String, context: Context) {
    var builder = NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle(NOTIFICATION_TITLE)
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    if (ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.POST_NOTIFICATIONS
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        // TODO: Consider calling
        //    ActivityCompat#requestPermissions
        // here to request the missing permissions, and then overriding
        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
        //                                          int[] grantResults)
        // to handle the case where the user grants the permission. See the documentation
        // for ActivityCompat#requestPermissions for more details.
        return
    }
    NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, builder.build())
}

@RequiresApi(Build.VERSION_CODES.Q)
@WorkerThread
fun blurBitmap(bitmap: Bitmap, applicationContext: Context): Bitmap {
    try {

        // Create the output bitmap
        val output = Bitmap.createBitmap(
            bitmap.width, bitmap.height, bitmap.config)

        val numberOfOutputImages = 1
        val imageReader = ImageReader.newInstance(
            bitmap.width, bitmap.height,
            PixelFormat.RGBA_8888, numberOfOutputImages,
            HardwareBuffer.USAGE_GPU_SAMPLED_IMAGE or HardwareBuffer.USAGE_GPU_COLOR_OUTPUT
        )
        val renderNode = RenderNode("BlurEffect")
        val hardwareRenderer = HardwareRenderer()

        hardwareRenderer.setSurface(imageReader.surface)
        hardwareRenderer.setContentRoot(renderNode)

        renderNode.setPosition(0, 0, imageReader.width, imageReader.height)
        val blurRenderEffect = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            RenderEffect.createBlurEffect(
                30f,
                30f,
                Shader.TileMode.MIRROR
            )
        } else {
            TODO("VERSION.SDK_INT < S")

        }
        renderNode.setRenderEffect(blurRenderEffect)

        return output
    } finally {
        rsContext.finish()
    }
}