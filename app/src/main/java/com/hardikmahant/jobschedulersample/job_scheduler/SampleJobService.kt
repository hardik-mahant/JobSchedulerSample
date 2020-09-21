package com.hardikmahant.jobschedulersample.job_scheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class SampleJobService : JobService() {

    companion object {
        const val JOB_ID = 123
        private const val TAG = "JS@: SampleJobService"
    }

    var isJobCancelled = false

    override fun onStartJob(params: JobParameters?): Boolean {
        Log.i(TAG, "onStartJob: ")
        doBackgroundWork(params)
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.i(TAG, "onStopJob: ")
        isJobCancelled = true
        return true
    }

    private fun doBackgroundWork(params: JobParameters?) {
        Thread {
            for (i in 1..10) {
                if (isJobCancelled) return@Thread
                Log.i(TAG, "doBackgroundWork: run $i")
                Thread.sleep(1000)
            }
            jobFinished(params, false)
        }.start()
    }
}