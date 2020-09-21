package com.hardikmahant.jobschedulersample.work_manager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.hardikmahant.jobschedulersample.R
import kotlinx.android.synthetic.main.activity_work_manager.*

class WorkManagerActivity : AppCompatActivity() {

    private lateinit var workManager: WorkManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)
        workManager = WorkManager.getInstance(applicationContext)
        btnStartWork.setOnClickListener {
            requestOneTimeTask()
        }
    }

    private fun requestOneTimeTask() {
        val workConstrains = Constraints.Builder()
            .setRequiresCharging(true)
            .build()
        val oneTimeWorkRequest = OneTimeWorkRequest.Builder(CounterWorker::class.java)
            .setConstraints(workConstrains)
            .build()
        workManager.enqueue(oneTimeWorkRequest)
        workManager.getWorkInfoByIdLiveData(oneTimeWorkRequest.id)
            .observe(this, {
                Log.i(TAG, "requestOneTimeTask: ${it.state.name}")
            })
    }

    companion object {
        private const val TAG = "WorkManagerActivity"
    }
}