package com.example.servicesapp

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi


class MainActivity : ComponentActivity() {
    private var boundService: BoundService? = null
    private var isBound = false

    private var aidlService: IMyAidlInterface? = null
    private val aidlConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            aidlService = IMyAidlInterface.Stub.asInterface(service)
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            aidlService = null
        }
    }

    private val boundConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as BoundService.LocalBinder
            boundService = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            boundService = null
            isBound = false
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServiceControls(
                onStartBasicService = { startService(Intent(this, com.example.servicesapp.BasicService::class.java)) },
                onStartForegroundService = { startForegroundService(Intent(this, com.example.servicesapp.ForegroundService::class.java)) },
                onBindBoundService = {
                    bindService(Intent(this, BoundService::class.java), boundConnection, Context.BIND_AUTO_CREATE)
                },
                onSendAidlData = {
                    aidlService?.sendData("Hello from Client")
                }
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isBound) {
            unbindService(boundConnection)
            isBound = false
        }
        unbindService(aidlConnection)
    }
}