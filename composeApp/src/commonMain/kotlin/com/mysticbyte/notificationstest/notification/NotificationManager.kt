package com.mysticbyte.notificationstest.notification

interface NotificationManager {

    fun showNotification(title: String, message: String)

    fun requestPermission()

}

expect fun getNotificationManager(): NotificationManager