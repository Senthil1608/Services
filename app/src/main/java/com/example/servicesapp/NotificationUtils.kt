package com.example.servicesapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

fun createNotificationChannel(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            "ForegroundChannel",
            "Foreground Service",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        val manager = context.getSystemService(NotificationManager::class.java)
        manager?.createNotificationChannel(channel)
    }
}