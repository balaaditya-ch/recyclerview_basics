package com.nam.recyclerview_basics

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class MyJobService : JobService() {

    // Called when the job is started
    override fun onStartJob(params: JobParameters?): Boolean {
        Log.d("JobScheduler", "Job Started with ID: ${params?.jobId}")

        // Simulate work (in a background thread)
        Thread {
            try {
                Thread.sleep(3000) // Simulate 3 seconds of work
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            Log.d("JobScheduler", "Job Finished")
            jobFinished(params, false) // Mark job as finished
        }.start()

        return true // Return true if the job is still running in background thread
    }

    // Called when the job is interrupted
    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("JobScheduler", "Job Stopped with ID: ${params?.jobId}")
        return false // Return false to drop the job
    }
}
