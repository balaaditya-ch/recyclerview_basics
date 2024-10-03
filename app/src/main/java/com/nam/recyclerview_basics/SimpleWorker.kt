package com.nam.recyclerview_basics

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class SimpleWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        // Background work code here
        Log.d("WorkManagerDemo", "SimpleWorker is running in the background")

        // Simulate some work (like network calls or long calculations)
        for (i in 1..5) {
            Log.d("WorkManagerDemo", "Working... Step $i")
            Thread.sleep(1000)
        }

        return Result.success()
    }
}
