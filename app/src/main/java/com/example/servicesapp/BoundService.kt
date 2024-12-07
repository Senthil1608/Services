package com.example.servicesapp

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class BoundService : Service() {
    private val binder = LocalBinder()

    inner class LocalBinder : Binder() {
        fun getService(): BoundService = this@BoundService
    }

    fun getData(): String = "Data from Bound Service"

    override fun onBind(intent: Intent?): IBinder = binder
}
