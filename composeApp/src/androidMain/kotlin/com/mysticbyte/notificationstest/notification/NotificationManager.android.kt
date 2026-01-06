package com.mysticbyte.notificationstest.notification

import android.app.NotificationChannel
import android.content.Context
import android.os.Build
import androidx.compose.ui.autofill.ContentType
import androidx.core.app.NotificationCompat
import android.app.NotificationManager as AndroidNotificationManager


class AndroidNotificationManagerImpl(private val context: Context) : NotificationManager {

    private val channelId = "default_channel"

    init {

        createNotificationChannel()

    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = "Default Channel"
            val importance = AndroidNotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance)
            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as
                    AndroidNotificationManager
            manager.createNotificationChannel(channel)
        }

    }

    override fun showNotification(title: String, message: String) {
        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as
                AndroidNotificationManager
        manager.notify(1, builder.build())
    }

    override fun requestPermission() {
        TODO("Not yet implemented")
    }

}

lateinit var appContext: Context

actual fun getNotificationManager(): NotificationManager = AndroidNotificationManagerImpl(appContext)