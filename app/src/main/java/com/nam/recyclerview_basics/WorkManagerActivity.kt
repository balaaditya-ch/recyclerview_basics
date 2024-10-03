package com.nam.recyclerview_basics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import java.util.concurrent.TimeUnit

class WorkManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

        // Run One-Time Work
        runOneTimeWork()

        // Run Periodic Work
        runPeriodicWork()

        // Run Work with Constraints
        runWorkWithConstraints()

        // Chain Work Requests
        chainWorkRequests()
    }

    // One-time work request
    private fun runOneTimeWork() {
        val oneTimeRequest = OneTimeWorkRequest.Builder(SimpleWorker::class.java).build()
        WorkManager.getInstance(this).enqueue(oneTimeRequest)
    }

    // Periodic work request (every 15 minutes)
    private fun runPeriodicWork() {
        val periodicWorkRequest = PeriodicWorkRequest.Builder(
            SimpleWorker::class.java,
            15, TimeUnit.MINUTES // Repeats every 15 minutes
        ).build()

        WorkManager.getInstance(this).enqueue(periodicWorkRequest)
    }

    // Work with constraints (run only when charging and Wi-Fi connected)
    private fun runWorkWithConstraints() {
        val constraints = Constraints.Builder()
            .setRequiresCharging(true) // Only run when the device is charging
            .setRequiredNetworkType(NetworkType.UNMETERED) // Requires unmetered network (Wi-Fi)
            .build()

        val constrainedWorkRequest = OneTimeWorkRequest.Builder(SimpleWorker::class.java)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueue(constrainedWorkRequest)
    }

    // Chaining multiple work requests
    private fun chainWorkRequests() {
        val work1 = OneTimeWorkRequest.Builder(SimpleWorker::class.java).build()
        val work2 = OneTimeWorkRequest.Builder(SimpleWorker::class.java).build()
        val work3 = OneTimeWorkRequest.Builder(SimpleWorker::class.java).build()

        WorkManager.getInstance(this)
            .beginWith(work1)
            .then(work2)
            .then(work3)
            .enqueue()
    }
}
