package com.hardikmahant.jobschedulersample.job_scheduler

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.hardikmahant.jobschedulersample.R
import kotlinx.android.synthetic.main.activity_js.*

class JobSchedulerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_js)

        btnSchedule.setOnClickListener {

            val componentName = ComponentName(this, SampleJobService::class.java)
            val jobInfo = JobInfo.Builder(SampleJobService.JOB_ID, componentName)
                .setRequiresCharging(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true)
                .build()

            val jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val resultCode = jobScheduler.schedule(jobInfo)
            if (resultCode == JobScheduler.RESULT_SUCCESS) {
                Log.i(TAG, "onCreate: Job Scheduled")
            } else {
                Log.i(TAG, "onCreate: Unable to Schedule Job")
            }
        }

        btnCancel.setOnClickListener {
            val jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            jobScheduler.cancel(SampleJobService.JOB_ID)
            Log.i(TAG, "onCreate: Job Cancelled")
        }
    }

    companion object {
        const val TAG = "JS@: MainActivity"
    }
}