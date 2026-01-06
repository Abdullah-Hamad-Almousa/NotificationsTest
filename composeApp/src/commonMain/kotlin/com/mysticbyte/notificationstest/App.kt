package com.mysticbyte.notificationstest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mysticbyte.notificationstest.notification.getNotificationManager

@Composable
fun App() {

    val notificationManager = remember { getNotificationManager() }

    MaterialTheme {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

            Button( onClick = {

                notificationManager.requestPermission()

                notificationManager.showNotification(
                    title = "KMP Aleart",
                    message = "This works on Android, iOS, and JVM!"
                )

            }

            ){
                Text("Show notification")
            }

        }

    }

}