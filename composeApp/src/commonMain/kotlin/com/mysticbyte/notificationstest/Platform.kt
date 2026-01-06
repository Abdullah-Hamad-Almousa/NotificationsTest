package com.mysticbyte.notificationstest

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform