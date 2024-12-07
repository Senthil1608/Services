package com.example.servicesapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class ForegroundService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification = NotificationCompat.Builder(this, "ForegroundChannel")
            .setContentTitle("Foreground Service")
            .setContentText("Running...")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()
        startForeground(1, notification)
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
