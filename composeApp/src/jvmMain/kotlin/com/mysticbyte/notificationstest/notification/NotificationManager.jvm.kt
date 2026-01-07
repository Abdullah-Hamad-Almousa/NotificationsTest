package com.mysticbyte.notificationstest.notification

import java.awt.SystemTray
import java.awt.Toolkit
import java.awt.TrayIcon

class JvmNotificationManager : NotificationManager  {

    override suspend fun requestPermission(): Boolean {
        return SystemTray.isSupported()
    }

    override fun showNotification(title: String, message: String) {
        if (!SystemTray.isSupported()) {
            println("System tray not supported")
            return
        }

        val tray = SystemTray.getSystemTray()
        val image = Toolkit.getDefaultToolkit().createImage("icon.png")
        val trayIcon = TrayIcon(image, "NotificationDemo")

        trayIcon.isImageAutoSize = true
        try {

            tray.add(trayIcon)
            trayIcon.displayMessage(title, message, TrayIcon.MessageType.INFO)

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}

actual fun getNotificationManager(): NotificationManager = JvmNotificationManager()