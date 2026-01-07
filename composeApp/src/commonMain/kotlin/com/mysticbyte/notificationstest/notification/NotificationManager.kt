package com.mysticbyte.notificationstest.notification

interface NotificationManager {

    fun showNotification(title: String, message: String)

    suspend fun requestPermission() : Boolean

}

expect fun getNotificationManager(): NotificationManager