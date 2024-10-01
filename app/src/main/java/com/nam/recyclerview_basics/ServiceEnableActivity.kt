package com.nam.recyclerview_basics

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class ServiceEnableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_enable)

        // Button to start the service
        val startServiceButton = findViewById<Button>(R.id.startServiceButton)
        startServiceButton.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent)
        }

        // Button to stop the service
        val stopServiceButton = findViewById<Button>(R.id.stopServiceButton)
        stopServiceButton.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            stopService(intent)
        }
    }
}
