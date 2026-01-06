package com.mysticbyte.notificationstest.vmodel

import com.mysticbyte.notificationstest.notification.getNotificationManager

class MainViewModel {

    private val notificationManager = getNotificationManager()

    fun onNotifyClicked(){

        notificationManager.requestPermission()
        notificationManager
            .showNotification("Hello KMP!", "This works on Android, iOS, and JVM!")

    }

}