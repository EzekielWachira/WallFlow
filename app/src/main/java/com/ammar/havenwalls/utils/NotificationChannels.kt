package com.ammar.havenwalls.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.ammar.havenwalls.R

object NotificationChannels {
    const val DOWNLOADS_CHANNEL_ID = "downloads"
    const val AUTO_WALLPAPER_CHANNEL_ID = "auto_wallpaper"

    fun createChannels(context: Context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return
        val downloadsChannel = NotificationChannel(
            DOWNLOADS_CHANNEL_ID,
            context.getString(R.string.downloads_channel_name),
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = context.getString(R.string.downloads_channel_description)
        }
        val autoWallpaperChannel = NotificationChannel(
            AUTO_WALLPAPER_CHANNEL_ID,
            context.getString(R.string.auto_wallpaper_channel_name),
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = context.getString(R.string.auto_wallpaper_channel_description)
        }
        // Register the channel with the system
        val notificationManager: NotificationManager = context.getSystemService(
            Context.NOTIFICATION_SERVICE
        ) as NotificationManager
        notificationManager.apply {
            createNotificationChannel(downloadsChannel)
            createNotificationChannel(autoWallpaperChannel)
        }
    }
}
