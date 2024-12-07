package com.example.servicesapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class BasicService : Service() {
    override fun onCreate() {
        super.onCreate()
        Log.d("BasicService", "Service Created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("BasicService", "Service Started")
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("BasicService", "Service Destroyed")
    }

    override fun onBind(intent: Intent?): IBinder? = null
}