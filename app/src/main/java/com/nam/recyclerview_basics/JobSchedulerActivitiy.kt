package com.nam.recyclerview_basics

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class JobSchedulerActivitiy : AppCompatActivity() {

    private lateinit var jobScheduler: JobScheduler
    private val JOB_ID = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

        jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

        // Schedule different types of jobs
        scheduleSimpleJob()
        scheduleJobWithConstraints()
        schedulePeriodicJob()
        scheduleJobWithDeadline()
    }

    // 1. Schedule a simple job
    private fun scheduleSimpleJob() {
        val componentName = ComponentName(this, MyJobService::class.java)
        val jobInfo = JobInfo.Builder(JOB_ID, componentName)
            .setRequiresCharging(false) // Doesn't require charging
            .build()

        jobScheduler.schedule(jobInfo)
        Log.d("JobScheduler", "Simple job scheduled with ID: $JOB_ID")
    }

    // 2. Schedule a job with constraints (Wi-Fi and Charging)
    private fun scheduleJobWithConstraints() {
        val componentName = ComponentName(this, MyJobService::class.java)
        val jobInfo = JobInfo.Builder(JOB_ID + 1, componentName)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED) // Wi-Fi connection
            .setRequiresCharging(true) // Requires charging
            .build()

        jobScheduler.schedule(jobInfo)
        Log.d("JobScheduler", "Job with constraints scheduled with ID: ${JOB_ID + 1}")
    }

    // 3. Schedule a periodic job (API 24+)
    private fun schedulePeriodicJob() {
        val componentName = ComponentName(this, MyJobService::class.java)
        val jobInfo = JobInfo.Builder(JOB_ID + 2, componentName)
            .setPeriodic(15 * 60 * 1000) // 15 minutes
            .setPersisted(true) // Survive device reboot
            .build()

        jobScheduler.schedule(jobInfo)
        Log.d("JobScheduler", "Periodic job scheduled with ID: ${JOB_ID + 2}")
    }

    // 4. Schedule a job with a deadline
    private fun scheduleJobWithDeadline() {
        val componentName = ComponentName(this, MyJobService::class.java)
        val jobInfo = JobInfo.Builder(JOB_ID + 3, componentName)
            .setOverrideDeadline(5 * 60 * 1000) // Max delay of 5 minutes
            .build()

        jobScheduler.schedule(jobInfo)
        Log.d("JobScheduler", "Job with deadline scheduled with ID: ${JOB_ID + 3}")
    }

    // Optional: Cancel a job
    private fun cancelJob() {
        jobScheduler.cancel(JOB_ID)
        Log.d("JobScheduler", "Job with ID $JOB_ID cancelled")
    }
}
