package com.mysticbyte.notificationstest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mysticbyte.notificationstest.notification.getNotificationManager
import kotlinx.coroutines.launch

@Composable
fun App() {

    val notificationManager = remember { getNotificationManager() }
    val scope = rememberCoroutineScope()

    MaterialTheme {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

            Button(onClick = {
                scope.launch {
                    // First, request permission and wait for the result
                    val permissionGranted = notificationManager.requestPermission()

                    // Only show the notification if permission was granted
                    if (permissionGranted) {
                        notificationManager.showNotification(
                            title = "KMP Alert",
                            message = "This works on Android, iOS, and JVM!"
                        )
                    } else {
                        // Optionally, handle the case where permission was denied
                        // For example, show a snack bar or a message to the user.
                        println("Permission for notifications was not granted.")
                    }
                }
            }) {
                Text("Show notification")
            }

        }

    }

}