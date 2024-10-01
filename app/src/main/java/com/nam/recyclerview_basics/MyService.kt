package com.nam.recyclerview_basics

// MyService.kt
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.d("MyService", "Service Created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // The service will do some work here
        Log.d("MyService", "Service Started")
        // If you want the service to restart automatically if it gets killed, return START_STICKY.
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyService", "Service Destroyed")
    }

    override fun onBind(intent: Intent?): IBinder? {
        // Return null because this is a started service, not a bound service.
        return null
    }
}
