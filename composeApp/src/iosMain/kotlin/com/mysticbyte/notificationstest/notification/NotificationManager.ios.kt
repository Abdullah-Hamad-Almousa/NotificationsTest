package com.mysticbyte.notificationstest.notification

import platform.UserNotifications.UNAuthorizationOptionAlert
import platform.UserNotifications.UNAuthorizationOptionBadge
import platform.UserNotifications.UNAuthorizationOptionSound
import platform.UserNotifications.UNMutableNotificationContent
import platform.UserNotifications.UNNotificationRequest
import platform.UserNotifications.UNNotificationSound
import platform.UserNotifications.UNUserNotificationCenter

class IosNotificationManager : NotificationManager {

    override fun requestPermission() {

        val center = UNUserNotificationCenter.currentNotificationCenter()
        center.requestAuthorizationWithOptions(
            UNAuthorizationOptionAlert or UNAuthorizationOptionSound or UNAuthorizationOptionBadge
        ) { granted, error ->

            if (granted){
                println("Notifications permission granted")
            }

        }

    }

    override fun showNotification(title: String, message: String) {

        val content = UNMutableNotificationContent()
        content.setTitle(title)
        content.setBody(message)
        content.setSound(UNNotificationSound.defaultSound)

        val request = UNNotificationRequest.requestWithIdentifier(
            identifier = "local_notification",
            content = content,
            trigger = null
        )

        UNUserNotificationCenter.currentNotificationCenter().addNotificationRequest(request) { error ->
            if (error != null){
                println("Error showing notification: $error")
            }
        }
    }

}

actual fun getNotificationManager(): NotificationManager = IosNotificationManager()