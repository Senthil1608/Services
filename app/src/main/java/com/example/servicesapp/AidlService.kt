package com.example.servicesapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.servicesapp.IMyAidlInterface

class AidlService : Service() {

    // Implement the AIDL interface
    private val binder = object : IMyAidlInterface.Stub() {
        override fun sendData(data: String) { // This matches the AIDL definition
            Log.d("AidlService", "Received data: $data")
        }
    }

    // Return the IBinder from the Stub
    override fun onBind(intent: Intent?): IBinder = binder
}
